package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;

/**
 * Created by rdsdo on 06/05/2017.
 */
public class LoginController {
    @FXML
    private GridPane GridPaneLogin;
    public void ButtonEntrar(ActionEvent actionEvent) throws IOException {

    }

    public void ButtonCancelar(ActionEvent actionEvent) {
        Platform.exit();
    }
}
