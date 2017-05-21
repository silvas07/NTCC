package Controller;


import Modelo.ProfessorModelo;
import Negocio.ProfessorNegocio;
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

    ProfessorModelo professorModelo = new ProfessorModelo();
    ProfessorNegocio professorNegocio = new ProfessorNegocio();

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

    public void getProfessorSalvar() throws SQLException {
        professorModelo.setNome(TextFieldNome.getText());
        professorModelo.setSobrenome(TextFieldSobrenome.getText());
        professorModelo.setMatricula(TextFieldMatricula.getText());
        professorModelo.setTitulacao(TextFieldTitulacao.getText());
        professorModelo.setEmail(TextFieldeEmail.getText());

        try {

            RadioButton radioButton = new RadioButton();
            radioButton = (RadioButton) groupGenero.getSelectedToggle();
            String genero = radioButton.getText();
            professorModelo.setGenero(genero);

        }catch (Exception e){
            System.out.println("Preencher genero"); // colocar mensagem
        }

        professorNegocio.salvarProfessor(professorModelo);

    }

    public void salvar(ActionEvent actionEvent) throws SQLException {
        getProfessorSalvar();


    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        limparCaixaDeTexto();
    }





}