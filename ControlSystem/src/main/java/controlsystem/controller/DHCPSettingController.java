package controlsystem.controller;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import controlsystem.common.UiUtil;
import controlsystem.data.Config;
import controlsystem.data.DHCP;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by dsm_025 on 2017-04-19.
 */
public class DHCPSettingController extends BorderPane{
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXToggleButton DHCPPower;
    @FXML
    private JFXTextField startFirstField;
    @FXML
    private JFXTextField startSecondField;
    @FXML
    private JFXTextField startThirdField;
    @FXML
    private JFXTextField startFourthField;
    @FXML
    private JFXTextField endFirstField;
    @FXML
    private JFXTextField endSecondField;
    @FXML
    private JFXTextField endThirdField;
    @FXML
    private JFXTextField endFourthField;

    private boolean saveState;

    public DHCPSettingController(){
        try {
            UiUtil.loadFxml(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DHCP data = Config.configFile.getDhcp();

        String[] startIP = data.getStart().split("\\.");
        String[] endIP = data.getEnd().split("\\.");

        startFirstField.setText(startIP[0]);
        startSecondField.setText(startIP[1]);
        startThirdField.setText(startIP[2]);
        startFourthField.setText(startIP[3]);

        endFirstField.setText(endIP[0]);
        endSecondField.setText(endIP[1]);
        endThirdField.setText(endIP[2]);
        endFourthField.setText(endIP[3]);

        saveBtn.setOnMouseClicked(event -> {
            saveState = true;
            ((Stage) getScene().getWindow()).close();
        });
        cancelBtn.setOnMouseClicked(event -> {
            ((Stage) getScene().getWindow()).close();
        });

        DHCPPower.setOnMouseClicked(event -> {
            if(DHCPPower.isSelected()) {
                System.out.println("DHCP is On");
            }else{
                System.out.println("DHCP is Off");
            }
        });
    }

    public boolean isSaveState() {
        return saveState;
    }

    public String toString(){
        DHCP dhcp = new DHCP(startFirstField.getText() + "." + startSecondField + "."
              + startThirdField.getText() + "." + startFourthField.getText(),
                endFirstField.getText() + "." + endSecondField.getText() + "."
              + endThirdField.getText() + "." + endFourthField.getText());
        Config.getConfigFile().setDhcp(dhcp);
        JSONObject object = null;
        try {
            object = new JSONObject();
            object.put("type", "startUrl");
            object.put("data", new Gson().toJson(dhcp));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }
}
