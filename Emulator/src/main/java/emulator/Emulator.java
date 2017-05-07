package emulator;

import com.google.gson.Gson;
import emulator.data.*;
import emulator.manger.JSONManager;
import emulator.manger.network.ControlSystemSocketListener;
import emulator.manger.network.ControlSystemSocketManager;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by dsm_025 on 2017-04-18.
 */
public class Emulator extends Equipment {
    private static final Logger logger = LoggerFactory.getLogger(Emulator.class);
    private Config settingData;

    public void startEmulator(){
        logger.info("Router Emulator is on");
        ControlSystemSocketListener listener = new ControlSystemSocketListener();

        listener.setmOnMessageReceived(msg -> {
            try {
                settingChangeHandler(msg);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        listener.start();
        refresh();

        try {
            ControlSystemSocketManager.sendMsg(JSONManager.parseJsonFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void setNetWorkData(NetWorkInfoData data){
//        settingData.setData(data);
//    }
//    public void resetNetWorkData(){
//
//    }

    private void refresh(){
        JSONManager.parseJsonFile();
    }

    @Override
    public void setPowerState(boolean state){
        System.out.println("Emulator is " + (state ? "On" : "Off"));
        this.powerState = state;
    }

    private void settingChangeHandler(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        logger.info(jsonObject.getString("type") + " Type is Changed");
        switch (jsonObject.getString("type")){
            case "wireless":
                Config.configFile.setWireless(new Gson().fromJson(jsonObject.getString("data"), Wireless.class));
                break;
            case "portForward":
                Config.configFile.setPortForward(new Gson().fromJson(jsonObject.getString("data"), PortForward.class));
                break;
            case "startUrl":
                Config.configFile.setStartUrl(new Gson().fromJson(jsonObject.getString("data"), StartURL.class));
                break;
            case "timeLimit":
                Config.configFile.setTimeLimit(new Gson().fromJson(jsonObject.getString("data"), TimeLimit.class));
                break;
            case "dhcp":
                Config.configFile.setDHCP(new Gson().fromJson(jsonObject.getString("data"), DHCP.class));
                break;
        }
        JSONManager.bindJsonFile(Config.getConfigFile());
    }
}
