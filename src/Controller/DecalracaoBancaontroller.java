package Controller;

import Modelo.AlunoModelo;
import Modelo.ProfessorModelo;
import Modelo.TCCModelo;
import Negocio.AlunoNegocio;
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
 * Created by rdsdo on 24/05/2017.
 */
public class DecalracaoBancaontroller implements Initializable {


    @FXML
    private TextField TextFieldProferssor;
    @FXML
    private TextField TextFieldMatriculaProfessor;
    @FXML
    private ComboBox<String> ComboBoxTituloTCC;
    @FXML
    private TextField TextFieldNomeAluno;
    @FXML
    private TextField TextFieldMatriculaAluno;

    @FXML
    private TableView<TCCModelo>  TableViewResultado;
    @FXML
    private TableColumn<String , TCCModelo> TableColumnTituloTCC;
    @FXML
    private TableColumn<String, TCCModelo> TableColumnDataInicio;
    @FXML
    private TableColumn<String,TCCModelo> TableColumnTipoTCC;



    List<TCCModelo> listTCC = new ArrayList<>();
    TCCModelo tccModelo = new TCCModelo();
    TCCNegocio tccNegocio = new TCCNegocio();
    ProfessorModelo professorModelo = new ProfessorModelo();
    ProfessorNegocio professorNegocio = new ProfessorNegocio();
    AlunoModelo alunoModelo = new AlunoModelo();
    AlunoNegocio alunoNegocio = new AlunoNegocio();





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            listTCC = tccNegocio.buscarTCC();
            carregarComboBox();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void carregarComboBox() throws SQLException {
        for (int i = 0 ; i < listTCC.size() ; i++){
            tccModelo = listTCC.get(i);
            ComboBoxTituloTCC.getItems().addAll(tccModelo.getTitulo() + " (" + tccModelo.getTipoTCC() + ")");
        }

    }

    public void filtrarProfessor(ActionEvent actionEvent) throws SQLException {
        listTCC =null;
        professorModelo= null;
        professorModelo = professorNegocio.buscarProfessorOrientador(
                TextFieldMatriculaProfessor.getText() , TextFieldProferssor.getText());
        if (professorModelo.getNome() == null){
            TextFieldProferssor.setPromptText("Professor não encontrado.");
        }else {
            TextFieldProferssor.setText(professorModelo.getNome() + " " + professorModelo.getSobrenome());
            TextFieldMatriculaProfessor.setText(professorModelo.getMatricula());
            listTCC = tccNegocio.buscarTCCProfessorOrinetador(professorModelo);
            ComboBoxTituloTCC.getItems().clear();
            carregarComboBox();
        }
    }

    public void filtrarAluno(ActionEvent actionEvent) throws SQLException {
        alunoModelo=null;
        TextFieldNomeAluno.setText("");
        alunoModelo = alunoNegocio.buscarAluno(TextFieldNomeAluno.getText(), TextFieldMatriculaAluno.getText());
        if (alunoModelo.getNome() == null) {
            TextFieldNomeAluno.setPromptText("Aluno não encontrado.");
        } else {
            TextFieldNomeAluno.setText(alunoModelo.getNome() + " " + alunoModelo.getSobrenome());
            TextFieldMatriculaAluno.setText(alunoModelo.getMatricula());
        }
    }

    public void limparCampos() throws SQLException {
        TextFieldProferssor.setText("");
        TextFieldMatriculaProfessor.setText("");
        TextFieldNomeAluno.setText("");
        TextFieldMatriculaAluno.setText("");
        ComboBoxTituloTCC.getItems().clear();
        listTCC = tccNegocio.buscarTCC();
        carregarComboBox();
    }

    public void cancelar(ActionEvent actionEvent) throws SQLException {
        limparCampos();
    }

    public void Buscar(ActionEvent actionEvent) {
    }

    public void gerarTabela(){

    }
}
