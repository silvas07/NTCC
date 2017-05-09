package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 29/04/2017.
 */
public class CadastroProfessorController implements Initializable{

    @FXML
    private TextField TextFieldNome;
    @FXML
    private TextField TextFieldSobrenome;
    @FXML
    private TextField TextFieldTitulacao;
    @FXML
    private TextField TextFieldTelefone;
    @FXML
    private TextField TextFieldeEmail;
    @FXML
    private TextField TextFieldMatricula;
    @FXML
    private RadioButton radioFeminino;
    @FXML
    private RadioButton radioMascolino;
    @FXML
    private ToggleGroup groupGenero;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void limparCaixaDeTexto(){
        TextFieldNome.setText("");
        TextFieldSobrenome.setText("");
        TextFieldTitulacao.setText("");
        TextFieldTelefone.setText("");
        TextFieldeEmail.setText("");
        TextFieldMatricula.setText("");


    }

    public void salvar(ActionEvent actionEvent) throws SQLException {



    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        limparCaixaDeTexto();
    }





}