package emulator.manger;

import com.google.gson.Gson;
import emulator.data.Config;

import java.io.*;

/**
 * Created by dsm_025 on 2017-04-30.
 */
public class JSONManager {
    public static String parseJsonFile(){
        String result = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("data/config.txt")));

            String tmp;
            while ((tmp = in.readLine()) != null) {
                result += tmp;
            }

            Config.configFile = new Gson().fromJson(result, Config.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void bindJsonFile(Config config) {
        try {
            //json 파일 초기화
            PrintWriter writer = new PrintWriter(new File("data/config.txt"));
            writer.print("");
            writer.close();

            String json = new Gson().toJson(config);
            BufferedWriter out = new BufferedWriter(new FileWriter(new File("data/config.txt")));
            out.write(json);
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
