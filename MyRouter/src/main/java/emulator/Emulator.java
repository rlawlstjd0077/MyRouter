package emulator;

import emulator.data.NetWorkInfoData;
import emulator.data.NetWorkSettingData;

/**
 * Created by dsm_025 on 2017-04-18.
 */
public class Emulator extends Equipment{
    NetWorkSettingData settingData;

    public void setNetWorkData(NetWorkInfoData data){
        settingData.setData(data);
    }
    public void resetNetWorkData(){
    }

    @Override
    public void setPowerState(boolean state){
        System.out.println("Emulator is " + (state ? "On" : "Off"));
        this.powerState = state;
    }

}
