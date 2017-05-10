package Controller;


import Modelo.FuncionarioModelo;
import Negocio.FuncionarioNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 06/05/2017.
 */
public class ConfiguracaoController implements Initializable {


@FXML
private TextField TextFieldNome;
@FXML
private TextField TextFieldSobrenome;
@FXML
private  TextField TextFieldMatricula;
@FXML
private  TextField TextFieldLogin;
@FXML
private PasswordField PasswordFieldSenha;
@FXML
private  PasswordField PasswordFieldRepitaSenha;

    FuncionarioModelo funcionarioModelo = new FuncionarioModelo();
    FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();

    public void getFuncionario (){
        funcionarioModelo.setNome(TextFieldNome.getText());
        funcionarioModelo.setSobrenome(TextFieldSobrenome.getText());
        funcionarioModelo.setMatricula(TextFieldMatricula.getText());
        funcionarioModelo.setLogin(TextFieldLogin.getText());
        funcionarioModelo.setSenha(PasswordFieldSenha.getText());
        funcionarioModelo.setSegundaSenha(PasswordFieldRepitaSenha.getText());
    }

    public void limparFuncionario(){
        TextFieldNome.setText("");
        TextFieldSobrenome.setText("");
        TextFieldMatricula.setText("");
        TextFieldLogin.setText("");
        PasswordFieldSenha.setText("");
        PasswordFieldRepitaSenha.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void salvarFuncionario(ActionEvent actionEvent) {
        getFuncionario();
    }

    public void CancelarFuncionario(ActionEvent actionEvent) {
        limparFuncionario();
    }
}
