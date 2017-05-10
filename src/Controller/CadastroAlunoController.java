package Controller;


import Modelo.AlunoModelo;
import Negocio.AlunoNegocio;
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
public class CadastroAlunoController implements Initializable{

    @FXML
    private TextField TextFieldNome;
    @FXML
    private TextField TextFieldSobrenome;
    @FXML
    private TextField TextFieldMatricula;
    @FXML
    private TextField TextFieldCurso;
    @FXML
    private TextField TextFieldTelefone;
    @FXML
    private TextField TextFieldeEmail;
    @FXML
    private RadioButton radioFeminino;
    @FXML
    private RadioButton radioMascolino;
    @FXML
    private ToggleGroup groupGenero;
    @FXML
    private TextField TextFieldRg;

    AlunoModelo alunoModelo = new AlunoModelo();
    AlunoNegocio alunoNegocio = new AlunoNegocio();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void limparCaixaDeTexto(){
        TextFieldNome.setText("");
        TextFieldSobrenome.setText("");
        TextFieldMatricula.setText("");
        TextFieldRg.setText("");
        TextFieldCurso.setText("");
        TextFieldTelefone.setText("");
        TextFieldeEmail.setText("");



    }

    public void getAlunoSalvar() throws SQLException {
        alunoModelo.setNome(TextFieldNome.getText());
        alunoModelo.setSobrenome(TextFieldSobrenome.getText());
        alunoModelo.setMatricula(TextFieldMatricula.getText());
        alunoModelo.setCurso(TextFieldCurso.getText());
        alunoModelo.setEmail(TextFieldeEmail.getText());
        alunoModelo.setRg(TextFieldRg.getText());


        try {

            RadioButton radioButton = new RadioButton();
            radioButton = (RadioButton) groupGenero.getSelectedToggle();
            String genero = radioButton.getText();
            alunoModelo.setGenero(genero);

        }catch (Exception e){
            System.out.println("Preencher geneto"); // COLOCAR MENSSAGEM
        }

        alunoNegocio.salvarAluno(alunoModelo);

    }

    public void salvar(ActionEvent actionEvent) throws SQLException {
        getAlunoSalvar();

    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        limparCaixaDeTexto();
    }






}