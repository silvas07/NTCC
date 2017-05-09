package Controller;

import Modelo.AlunoModelo;
import Modelo.FuncionarioModelo;
import Modelo.PessoaModelo;
import Modelo.ProfessorModelo;
import Negocio.AlunoNegocio;
import Negocio.FuncionarioNegocio;
import Negocio.PessoaNegocio;
import Negocio.ProfessorNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 29/04/2017.
 */
public class CadastroAlunoController implements Initializable{

    @FXML
    private GridPane Cadastropessoa;
    @FXML
    private Label LabelMenssagem;
    @FXML
    private ComboBox<String> ComboBoxTipo;
    @FXML
    private Label LabelNome;
    @FXML
    private TextField TextFieldNome;
    @FXML
    private Label LabelSobrenome ;
    @FXML
    private TextField TextFieldSobrenome;
    @FXML
    private Label LabelMatricula;
    @FXML
    private TextField TextFieldMatricula;
    @FXML
    private Label LabelTitulacao;
    @FXML
    private TextField TextFieldTitulacao;
    @FXML
    private Label LabelCurso;
    @FXML
    private TextField TextFieldCurso;
    @FXML
    private Label LabelTelefone;
    @FXML
    private TextField TextFieldTelefone;
    @FXML
    private Label LabelEmail;
    @FXML
    private TextField TextFieldeEmail;
    @FXML
    private HBox HboxGenero;
    @FXML
    private Label LabelCpf;
    @FXML
    private TextField TextFieldCpf;
    @FXML
    private RadioButton radioFeminino;
    @FXML
    private RadioButton radioMascolino;
    @FXML
    private ToggleGroup groupGenero;

    private List<String> tipo = new ArrayList<String>();
    private PessoaNegocio pessoaNegocio = new PessoaNegocio();
    private PessoaModelo pessoaModelo = new PessoaModelo();
    private FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
    private FuncionarioModelo funcionarioModelo = new FuncionarioModelo();
    private AlunoNegocio alunoNegocio = new  AlunoNegocio();
    private AlunoModelo alunoModelo = new AlunoModelo();
    private ProfessorNegocio professorNegocio = new ProfessorNegocio();
    private ProfessorModelo professorModelo = new ProfessorModelo();
    private String salvar = null;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarComboBoxTipo();
    }

    public void carregarComboBoxTipo () {

        try {
            tipo.add("Aluno");
            tipo.add("Professor");
            ComboBoxTipo.getItems().addAll(tipo);
        }catch (Exception e){

        }
    }

    public void salvar(ActionEvent actionEvent) throws SQLException {



    }

    public void cancelar(ActionEvent actionEvent) throws IOException {

    }

    public void salvaPessoa () throws SQLException {

        pessoaModelo.setNome(TextFieldNome.getText());
        pessoaModelo.setSobrenome(TextFieldSobrenome.getText());
        pessoaModelo.setEmail(TextFieldeEmail.getText());




        RadioButton rb = new RadioButton();
        rb =(RadioButton) groupGenero.getSelectedToggle();
        String o = rb.getText();
        pessoaModelo.setGenero(o);

        pessoaNegocio.salvarPessoa(pessoaModelo);



        }

    public void salvarProfessor () throws SQLException {
        professorModelo.setMatricula(TextFieldMatricula.getText());
        professorModelo.setTitulacao(TextFieldTitulacao.getText());
        professorNegocio.salvarProfessor(professorModelo);

    }

    public void salvarAluno(){

        alunoModelo.setCurso(TextFieldCurso.getText());
        alunoModelo.setMatricula(TextFieldMatricula.getText());
    }


}