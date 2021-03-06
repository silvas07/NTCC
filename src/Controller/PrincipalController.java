package Controller;

import Negocio.FuncionarioNegocio;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 29/04/2017.
 */
public class PrincipalController implements Initializable {

    @FXML
    private Pane CentroPrincipal;
    @FXML
    private MenuBar MenuBarPrincipal;
    @FXML
    private Label labelMenssagem;
    @FXML
    private TextField TextFieldLogin;
    @FXML
    private PasswordField PasswordFieldSenha;

    FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void abrirCadastroProfessor(ActionEvent actionEvent) throws IOException {
        caminhoTela("/Visao/CadastroProfessor.fxml");
    }

    public void Sair(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void BuscarTCC(ActionEvent actionEvent) throws IOException {
        caminhoTela("/Visao/BuscaDoc.fxml");
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

    public void gerarDeclaracao(ActionEvent actionEvent) throws IOException {
       caminhoTela("/Visao/DeclaracaoBanca.fxml");
    }

    public void ButtonEntrar(ActionEvent actionEvent) throws IOException, SQLException {
        verificarSenhas();
    }

    public void ButtonCancelar(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void configuracao(ActionEvent actionEvent) throws IOException {
       caminhoTela("/Visao/Configuracao.fxml");
    }

    public void verificarSenhas () throws IOException, SQLException {
        if(funcionarioNegocio.verificarLoginSenha(TextFieldLogin.getText() , PasswordFieldSenha.getText()).equals("NãoEntra") ) {
            labelMenssagem.setText("Insira Login e senha!");
        }else if (funcionarioNegocio.verificarLoginSenha(TextFieldLogin.getText() , PasswordFieldSenha.getText()).equals("Entra")){
            MenuBarPrincipal.setDisable(false);
            caminhoTela("/Visao/TelaInicial.fxml");
        }
    }

    public void abrirCadastroAluno(ActionEvent actionEvent) throws IOException {
        caminhoTela("/Visao/CadastroAluno.fxml");
    }

    public void abrirCadastroTCC(ActionEvent actionEvent) throws IOException {
        caminhoTela("/Visao/cadastrarTCC.fxml");
    }

    public void GupoTCC(ActionEvent actionEvent) throws IOException {
        caminhoTela("/Visao/GrupoTCC.fxml");
    }

    public void CadastrarProfessorLeitor(ActionEvent actionEvent) throws IOException {
        caminhoTela("/Visao/AddProfessorLeitor.fxml");
    }

    public void caminhoTela (String caminho) throws IOException {
        URL arquivoFXML;
        arquivoFXML = getClass().getResource(caminho);
        Parent fxmlParent =(Parent) FXMLLoader.load(arquivoFXML);
        CentroPrincipal.getChildren().clear();
        CentroPrincipal.getChildren().add(fxmlParent);
    }


}