package Controller;

import Modelo.*;
import Negocio.AlunoNegocio;
import Negocio.GrupoTCCNegocio;
import Negocio.ProfessorNegocio;
import Negocio.TCCNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 28/05/2017.
 */
public class AddProfessorLeitorController implements Initializable {

    @FXML
    private ComboBox<String> ComboBoxTituloTcc;
    @FXML
    private TextField TextFieldProfessorOrientador;
    @FXML
    private TextField TextFieldMatriculaProfessorOrientador;
    @FXML
    private TextField TextFieldProfessorLeitor1;
    @FXML
    private TextField TextFieldMatriculaProfessorLeitor1;
    @FXML
    private TextField TextFieldProfessorLeitor2;
    @FXML
    private TextField TextFieldMatriculaProfessorLeitor2;
    @FXML
    private Button ButtonTituloTcc;
    @FXML
    private Button ButtonProfessorOrientador;
    @FXML
    private Button ButtonProfessorLeitor1;
    @FXML
    private Button ButtonProfessorLeitor2;




    TCCModelo tccModelo = new TCCModelo();
    TCCNegocio tccNegocio = new TCCNegocio();

    ProfessorModelo professorModelo = new ProfessorModelo();
    ProfessorModelo professorModeloLeitor1 = new ProfessorModelo();
    ProfessorModelo professorModeloLeitor2 = new ProfessorModelo();
    ProfessorNegocio professorNegocio = new ProfessorNegocio();

    ProfessorLeitorModelo professorLeitorModelo= new ProfessorLeitorModelo();

    List<TCCModelo> listTCC = new ArrayList<TCCModelo>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarComboBox();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ButtonBuscarProfessorLeitor1(ActionEvent actionEvent) throws SQLException {

        professorModeloLeitor1= null;
        professorModeloLeitor1 = professorNegocio.buscarProfessorOrientador(
                TextFieldMatriculaProfessorLeitor1.getText() , TextFieldProfessorLeitor1.getText());
        if (professorModeloLeitor1.getNome() == null){
            TextFieldProfessorLeitor1.setPromptText("Professor não encontrado.");
        }else {
            TextFieldProfessorLeitor1.setText(professorModeloLeitor1.getNome() + " " + professorModeloLeitor1.getSobrenome());
            TextFieldMatriculaProfessorLeitor1.setText(professorModeloLeitor1.getMatricula());

        }
    }

    public void ButtonBuscarProfessorLeitor2(ActionEvent actionEvent) throws SQLException {
        professorModeloLeitor2= null;
        professorModeloLeitor2 = professorNegocio.buscarProfessorOrientador(
                TextFieldMatriculaProfessorLeitor2.getText() , TextFieldProfessorLeitor2.getText());
        if (professorModeloLeitor2.getNome() == null){
            TextFieldProfessorLeitor2.setPromptText("Professor não encontrado.");
        }else {
            TextFieldProfessorLeitor2.setText(professorModeloLeitor2.getNome() + " " + professorModeloLeitor2.getSobrenome());
            TextFieldMatriculaProfessorLeitor2.setText(professorModeloLeitor2.getMatricula());
        }
    }

    public void salvarProfessor(ActionEvent actionEvent) throws SQLException {
        for(int i = 0 ; i<listTCC.size() ; i++ ){
            tccModelo = listTCC.get(i);
            if(tccModelo.getTitulo().equals(ComboBoxTituloTcc.getValue())){
                break;
            }

            professorLeitorModelo.setIdTcc( tccModelo.getId());
            professorLeitorModelo.setIdProfessor(professorModeloLeitor1.getId());
            professorNegocio.salvarProfessorLeitor(professorLeitorModelo);
            professorLeitorModelo.setIdProfessor(professorModeloLeitor2.getId());
            professorNegocio.salvarProfessorLeitor(professorLeitorModelo);
        }
        limparCampos();
    }

    public void cancelarProfessor(ActionEvent actionEvent) {
        limparCampos();
    }





    public void limparCampos (){


        ComboBoxTituloTcc.getItems().clear();
        TextFieldProfessorOrientador.setText("");
        TextFieldMatriculaProfessorOrientador.setText("");
        TextFieldProfessorLeitor1.setText("");
        TextFieldProfessorLeitor2.setText("");
        TextFieldMatriculaProfessorLeitor1.setText("");
        TextFieldMatriculaProfessorLeitor2.setText("");



    }



    public void carregarComboBox() throws SQLException {
        for (int i = 0 ; i < listTCC.size() ; i++){
            tccModelo = listTCC.get(i);
            ComboBoxTituloTcc.getItems().addAll(tccModelo.getTitulo());
        }

    }



    public void ButtonBuscarTituloTcc(ActionEvent actionEvent) throws SQLException {
        ComboBoxTituloTcc.getItems().clear();
        listTCC = tccNegocio.buscarTCC();
        carregarComboBox();
        ButtonTituloTcc.setDisable(true);
    }

    public void ButtonBuscarProfessorOrientador(ActionEvent actionEvent) throws SQLException {

        listTCC =null;
        professorModelo= null;
        professorModelo = professorNegocio.buscarProfessorOrientador(
                TextFieldMatriculaProfessorOrientador.getText() , TextFieldProfessorOrientador.getText());
        if (professorModelo.getNome() == null){
            TextFieldProfessorOrientador.setPromptText("Professor não encontrado.");
        }else {
            TextFieldProfessorOrientador.setText(professorModelo.getNome() + " " + professorModelo.getSobrenome());
            TextFieldMatriculaProfessorOrientador.setText(professorModelo.getMatricula());
            listTCC = tccNegocio.buscarTCCProfessorOrinetador(professorModelo);
            ComboBoxTituloTcc.getItems().clear();
            carregarComboBox();
            ButtonTituloTcc.setDisable(true);
            ButtonProfessorOrientador.setDisable(true);
        }

    }




}
