package emulator.manger.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by dsm_025 on 2017-05-02.
 */
public class DeviceSocketListener extends Thread{
    private Socket socket;
    private BufferedReader br = null;
    private PrintWriter pw = null;

    public DeviceSocketListener(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            service();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void service() throws IOException {
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream(), true);
        String str = null;
        while(true){
            str = br.readLine();
            if(str == null){

            }
        }
    }
}
