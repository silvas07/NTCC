package Controller;

import Modelo.CursoModelo;
import Modelo.ProfessorModelo;
import Negocio.CursoNegocio;
import Negocio.ProfessorNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    List<ProfessorModelo> listarProfessor = new ArrayList<ProfessorModelo>();
    CursoModelo cursoModelo = new CursoModelo();
    CursoNegocio cursoNegocio = new CursoNegocio();

    ProfessorModelo professorModelo = new ProfessorModelo();
    ProfessorNegocio professorNegocio= new ProfessorNegocio();

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
        TextFieldProfessorOrientador.setText(professorModelo.getNome() + " " + professorModelo.getSobrenome());
        TextFieldMatriculaProfessor.setText(professorModelo.getMatricula());

    }

    public void vrificarMatricula(ActionEvent actionEvent) {
        TextFieldMatriculaProfessor.setVisible(true);
        LabelMatriculaProfessor.setVisible(true);


    }

    public void buscarProfessorOrientador () throws SQLException {
        listarProfessor = professorNegocio.buscarProfessorOrientador();

        for (int i = 0 ; i < listarProfessor.size() ; i ++){
            professorModelo = listarProfessor.get(i);
            if(TextFieldMatriculaProfessor.getText().equals(professorModelo.getMatricula())){

                TextFieldProfessorOrientador.setText(professorModelo.getNome() + " " + professorModelo.getSobrenome());
                TextFieldMatriculaProfessor.setText(professorModelo.getMatricula());

                break;

            }else if (TextFieldProfessorOrientador.getText().equals(professorModelo.getNome())) {

                TextFieldProfessorOrientador.setText(professorModelo.getNome() + " " + professorModelo.getSobrenome());
                TextFieldMatriculaProfessor.setText(professorModelo.getMatricula());
                break;
            }
        }
    }










    public void salvarTCC(ActionEvent actionEvent) {

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

    public void carregarTCC (){
        
    }
}
