package controlsystem.controller;

import com.jfoenix.controls.JFXButton;
import emulator.Emulator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dsm_025 on 2017-04-18.
 */
public class MainController implements Initializable {
    @FXML
    private JFXButton wireLessBtn;
    @FXML
    private JFXButton portForwardBtn;
    @FXML
    private JFXButton startURLBtn;
    @FXML
    private JFXButton timeLimitBtn;
    @FXML
    private JFXButton DHCPBtn;
    @FXML
    private RadioButton powerBtn;

    private Emulator emulator;

    private void menuHandle(MouseEvent event) {
        Stage newStage;
        switch (((Button) event.getSource()).getId()) {
            case "wireLessBtn":
                newStage  = settingNewState(new Scene(new WireLessSettingController()), "WireLessSetting");
                newStage.showAndWait();
                break;
            case "portForwardBtn":
                newStage = settingNewState(new Scene(new PortForwardSettingController()), "PortForwardSetting");
                newStage.showAndWait();
                break;
            case "startURLBtn":
                newStage = settingNewState(new Scene(new StartURLSettingController()), "StartURLSetting");
                newStage.showAndWait();
                break;
            case "timeLimitBtn":
                newStage = settingNewState(new Scene(new TimeLimitSettingController()), "TimeLimitSetting");
                newStage.showAndWait();
                break;
            case "DHCPBtn":
                newStage = settingNewState(new Scene(new DHCPSettingController()), "DHCPSetting");
                newStage.showAndWait();
                break;
        }
    }

    private void closeWindowHandle(){

    }

    private void powerHandle(){
        if(powerBtn.isSelected()){      // Power On
            LoginController controller = new LoginController();
            Stage newStage = settingNewState(new Scene(controller), "Login");
            newStage.setOnHidden(event -> {
                if(controller.getLoginState()){
                    setButtonsDisable(false);
                    emulator.setPowerState(true);
                }else{
                    powerBtn.setSelected(false);
                }
            });
            newStage.showAndWait();
        }else{                          //Power Off
            setButtonsDisable(true);
            emulator.setPowerState(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wireLessBtn.setOnMouseClicked(event -> menuHandle(event));
        portForwardBtn.setOnMouseClicked(event -> menuHandle(event));
        startURLBtn.setOnMouseClicked(event -> menuHandle(event));
        timeLimitBtn.setOnMouseClicked(event -> menuHandle(event));
        DHCPBtn.setOnMouseClicked(event -> menuHandle(event));
        powerBtn.setOnMouseClicked(event -> powerHandle());
        setButtonsDisable(true);
        emulator = new Emulator();
    }

    private Stage settingNewState(Scene scene, String title){
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle(title);
        return newStage;
    }

    private void setButtonsDisable(boolean state){
        wireLessBtn.setDisable(state);
        portForwardBtn.setDisable(state);
        startURLBtn.setDisable(state);
        timeLimitBtn.setDisable(state);
        DHCPBtn.setDisable(state);
    }
}
