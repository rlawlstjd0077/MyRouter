package controlsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import controlsystem.common.UiUtil;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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

    public DHCPSettingController(){
        try {
            UiUtil.loadFxml(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveBtn.setOnMouseClicked(event -> {
            ((Stage) getScene().getWindow()).close();
        });
        cancelBtn.setOnMouseClicked(event -> {
            ((Stage) getScene().getWindow()).close();
        });

        DHCPPower.setOnMouseClicked(event -> {
            System.out.println("DHCP is on");
        });
    }
}
