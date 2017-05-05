package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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



    public void BuscarTCC(ActionEvent actionEvent) throws IOException {
        URL arquivoFXML;
        arquivoFXML = getClass().getResource("/Visao/BuscaDeTCC.fxml");
        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
        CentroPrincipal.getChildren().clear();
        CentroPrincipal.getChildren().add(fxmlParent);
    }

    public void informacoes(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Visao/Informacao.fxml"));
        primaryStage.setTitle("NTCC");
        primaryStage.setScene(new Scene(root, 400, 391));
        primaryStage.setMinHeight(400);
        primaryStage.setMaxWidth(391);
        primaryStage.show();
    }
}
