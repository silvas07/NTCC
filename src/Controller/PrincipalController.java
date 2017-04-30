package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 29/04/2017.
 */
public class PrincipalController implements Initializable {

    @FXML
    private Pane CentroPrincipal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void abrirCadastro(ActionEvent actionEvent) throws IOException {
        URL arquivoFXML;
        arquivoFXML = getClass().getResource("/Visao/CadastroPessoa.fxml");
        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
        CentroPrincipal.getChildren().clear();
        CentroPrincipal.getChildren().add(fxmlParent);
    }

    public void Sair(ActionEvent actionEvent) {
        Platform.exit();
    }
}
