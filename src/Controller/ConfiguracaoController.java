package Controller;


import Modelo.CursoModelo;
import Modelo.FuncionarioModelo;
import Negocio.CursoNegocio;
import Negocio.FuncionarioNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
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
    @FXML
    private TextField TextFieldCurso;

    FuncionarioModelo funcionarioModelo = new FuncionarioModelo();
    FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
    CursoModelo cursoModelo = new CursoModelo();
    CursoNegocio cursoNegocio = new CursoNegocio();





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void getFuncionario () throws SQLException {
        funcionarioModelo.setNome(TextFieldNome.getText());
        funcionarioModelo.setSobrenome(TextFieldSobrenome.getText());
        funcionarioModelo.setMatricula(TextFieldMatricula.getText());
        funcionarioModelo.setLogin(TextFieldLogin.getText());
        funcionarioModelo.setSenha(PasswordFieldSenha.getText());
        funcionarioModelo.setSegundaSenha(PasswordFieldRepitaSenha.getText());

        funcionarioNegocio.salvarFuncionario(funcionarioModelo);
    }

    public void limparFuncionario(){
        TextFieldNome.setText("");
        TextFieldSobrenome.setText("");
        TextFieldMatricula.setText("");
        TextFieldLogin.setText("");
        PasswordFieldSenha.setText("");
        PasswordFieldRepitaSenha.setText("");
    }

    public void salvarFuncionario(ActionEvent actionEvent) throws SQLException {
        getFuncionario();
        limparFuncionario();
    }

    public void CancelarFuncionario(ActionEvent actionEvent) {
        limparFuncionario();
    }





    public  void  getCadastrarCurso () throws SQLException {
        cursoModelo.setCurso(TextFieldCurso.getText());
        cursoNegocio.salvarCurso(cursoModelo);
    }

    public void salvarCurso(ActionEvent actionEvent) throws SQLException {
        getCadastrarCurso();
        TextFieldCurso.setText("");

    }

    public void cancelarCruso(ActionEvent actionEvent) {
        TextFieldCurso.setText("");
    }
}
