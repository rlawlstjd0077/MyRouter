package controlsystem.manager;

import com.google.gson.Gson;
import controlsystem.data.Config;

/**
 * Created by dsm_025 on 2017-04-30.
 */
public class SocketClientManager extends Thread{
    private static boolean connectState;

    public interface OnConnectionChanged{
        void onConnectionChange(boolean state);
    }

    private SocketListener.OnConnectionChanged mOnConnectionChanged;

    public void setOnConnectionChanged(SocketListener.OnConnectionChanged mOnConnectionChanged) {
        this.mOnConnectionChanged = mOnConnectionChanged;
    }

    @Override
    public void run() {
        super.run();
        SocketListener listener = new SocketListener();
        connectState = true;
        listener.setOnMessageReceived(msg -> {
            Config.configFile = new Gson().fromJson(msg, Config.class);
        });
        listener.setOnConnectionChanged(state -> {
            mOnConnectionChanged.onConnectionChange(state);
            setConnectState(state);
        });
        listener.start();
    }

    private static void setConnectState(boolean state){
        connectState = state;
    }

    public static boolean isConnectState(){
        return connectState;
    }
}
