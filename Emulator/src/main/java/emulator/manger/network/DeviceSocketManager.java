package emulator.manger.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dsm_025 on 2017-05-02.
 */
public class DeviceSocketManager extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(DeviceSocketManager.class);

    ServerSocket ss;
    Socket s;

    @Override
    public void run() {
        try {
            ss = new ServerSocket(8881);
            while(true) {
                s = ss.accept();
                DeviceSocketListener st = new DeviceSocketListener(s);
                st.start();
                logger.info(s.getInetAddress() + "Device Connected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
