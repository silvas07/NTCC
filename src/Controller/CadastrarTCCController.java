package Controller;

import Modelo.CursoModelo;
import Modelo.ProfessorModelo;
import Modelo.TCCModelo;
import Negocio.CursoNegocio;
import Negocio.ProfessorNegocio;
import Negocio.TCCNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 14/05/2017.
 */
public class CadastrarTCCController implements Initializable {
    @FXML
    private ToggleGroup groupTCC;
    @FXML
    private RadioButton radioTCC2;
    @FXML
    private RadioButton radioTCC1;

    @FXML
    private ComboBox<String> ComboBoxCurso;
    @FXML
    private TextField TextFieldMatriculaProfessor;
    @FXML
    private Label LabelMatriculaProfessor;
    @FXML
    private TextField TextFieldProfessorOrientador;
    @FXML
    private TextField TextFieldTituloTCC;
    @FXML
    private DatePicker DatePickerDataInicio;
    @FXML
    private DatePicker DatePickerDataFim;

    List<CursoModelo> listCurso = new ArrayList<>();

    CursoModelo cursoModelo = new CursoModelo();
    CursoNegocio cursoNegocio = new CursoNegocio();

    ProfessorModelo professorModelo = new ProfessorModelo();
    ProfessorNegocio professorNegocio= new ProfessorNegocio();
    TCCModelo tccModelo = new TCCModelo();
    TCCNegocio tccNegocio = new TCCNegocio();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarCombobox();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void carregarCombobox () throws SQLException {
        listCurso = cursoNegocio.buscarCurso();

        for(int i = 0 ; i < listCurso.size(); i++) {
            cursoModelo = listCurso.get(i);
            ComboBoxCurso.getItems().add(cursoModelo.getCurso());
        }
    }


    public void verifiarProfessor(ActionEvent actionEvent) throws SQLException {
        buscarProfessorOrientador();
       if (professorModelo.getNome() == null) {
            TextFieldProfessorOrientador.setPromptText("Professor não encontrado!");
        } else{
            buscarProfessorOrientador();
        TextFieldProfessorOrientador.setText(professorModelo.getNome() + " " + professorModelo.getSobrenome());
        TextFieldMatriculaProfessor.setText(professorModelo.getMatricula());
    }

    }

    public void buscarProfessorOrientador () throws SQLException {

        professorModelo = professorNegocio.buscarProfessorOrientador(TextFieldMatriculaProfessor.getText() ,
                TextFieldProfessorOrientador.getText());



    }

    public void salvarTCC(ActionEvent actionEvent) throws SQLException {
        carregarTCC();

    }

    public void cancelar(ActionEvent actionEvent) throws SQLException {
        limparCampos();
    }

    public void limparCampos () throws SQLException {
        TextFieldProfessorOrientador.setText("");
        TextFieldTituloTCC.setText("");
        TextFieldMatriculaProfessor.setText("");
        ComboBoxCurso.getItems().clear();
        carregarCombobox();
        DatePickerDataInicio.getEditor().clear();
        DatePickerDataFim.getEditor().clear();

    }

    public void carregarTCC () throws SQLException {

        tccModelo.setTitulo(TextFieldTituloTCC.getText());
        tccModelo.setDataInicio(DatePickerDataInicio.getValue());
        tccModelo.setDataFim(DatePickerDataFim.getValue());
        cursoModelo = cursoNegocio.buscarCurso(ComboBoxCurso.getValue());
        tccModelo.setIdCurso(cursoModelo.getId());
        tccModelo.setIdProfessor(professorModelo.getId());

        try {

            RadioButton radioButton = new RadioButton();
            radioButton = (RadioButton) groupTCC.getSelectedToggle();
            String tipo = radioButton.getText();
            tccModelo.setTipoTCC(tipo);

        }catch (Exception e){
            System.out.println("Preencher geneto"); // COLOCAR MENSSAGEM
        }

        tccNegocio.salvarTCC(tccModelo);



    }
}
