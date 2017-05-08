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
public class CadastroPessoaController implements Initializable{

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
    private Label LabelLogin;
    @FXML
    private TextField TextFieldLogin;
    @FXML
    private  Label LabelSenha;
    @FXML
    private PasswordField PasswordFieldSenha;
    @FXML
    private  Label LabelRepitaSenha;
    @FXML
    private PasswordField PasswordFieldRepitaSenha;
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
            tipo.add("Funcionário");
            ComboBoxTipo.getItems().addAll(tipo);
        }catch (Exception e){

        }
    }

    public void selecionar(ActionEvent actionEvent) {
        String selecionar = ComboBoxTipo.getValue();
        this.salvar = selecionar;

        try {
            LabelMenssagem.setText("");
            if (selecionar.equals("Aluno")) {
                visualizarAluno();

            } else if (selecionar.equals("Professor")) {
                visualizarProfessor();
            } else if (selecionar.equals("Funcionário")) {
                visualizarFuncionario();
            }
        }catch (Exception e){
            LabelMenssagem.setText("Selecione um tipo de item!");
        }

    }

    public void visualizarAluno(){
        limparCaixaDeTexto();
        desabilitarComponetes();
        LabelNome.setDisable(false);
        TextFieldNome.setDisable(false);
        LabelSobrenome.setDisable(false);
        TextFieldSobrenome.setDisable(false);
        LabelMatricula.setDisable(false);
        TextFieldMatricula.setDisable(false);
        LabelCurso.setDisable(false);
        TextFieldCurso.setDisable(false);
        LabelTelefone.setDisable(false);
        TextFieldTelefone.setDisable(false);
        LabelEmail.setDisable(false);
        TextFieldeEmail.setDisable(false);
        HboxGenero.setDisable(false);
        LabelCpf.setDisable(false);
        TextFieldCpf.setDisable(false);

    }

    public void visualizarProfessor(){
        limparCaixaDeTexto();
        desabilitarComponetes();
        LabelNome.setDisable(false);
        TextFieldNome.setDisable(false);
        LabelSobrenome.setDisable(false);
        TextFieldSobrenome.setDisable(false);
        LabelMatricula.setDisable(false);
        TextFieldMatricula.setDisable(false);
        LabelTitulacao.setDisable(false);
        TextFieldTitulacao.setDisable(false);
        LabelTelefone.setDisable(false);
        TextFieldTelefone.setDisable(false);
        LabelEmail.setDisable(false);
        TextFieldeEmail.setDisable(false);
        HboxGenero.setDisable(false);
        LabelCpf.setDisable(false);
        TextFieldCpf.setDisable(false);
    }

    public void visualizarFuncionario(){
        limparCaixaDeTexto();
        desabilitarComponetes();
        LabelNome.setDisable(false);
        TextFieldNome.setDisable(false);
        LabelSobrenome.setDisable(false);
        TextFieldSobrenome.setDisable(false);
        LabelMatricula.setDisable(false);
        TextFieldMatricula.setDisable(false);
        LabelTelefone.setDisable(false);
        TextFieldTelefone.setDisable(false);
        LabelEmail.setDisable(false);
        TextFieldeEmail.setDisable(false);
        LabelLogin.setDisable(false);
        TextFieldLogin.setDisable(false);
        LabelSenha.setDisable(false);
        PasswordFieldSenha.setDisable(false);
        LabelRepitaSenha.setDisable(false);
        PasswordFieldRepitaSenha.setDisable(false);
        HboxGenero.setDisable(false);
        LabelCpf.setDisable(false);
        TextFieldCpf.setDisable(false);

    }

    public void desabilitarComponetes (){
        LabelNome.setDisable(true);
        TextFieldNome.setDisable(true);
        LabelSobrenome.setDisable(true);
        TextFieldSobrenome.setDisable(true);
        LabelMatricula.setDisable(true);
        TextFieldMatricula.setDisable(true);
        LabelTitulacao.setDisable(true);
        TextFieldTitulacao.setDisable(true);
        LabelCurso.setDisable(true);
        TextFieldCurso.setDisable(true);
        LabelTelefone.setDisable(true);
        TextFieldTelefone.setDisable(true);
        LabelEmail.setDisable(true);
        TextFieldeEmail.setDisable(true);
        HboxGenero.setDisable(true);
        LabelLogin.setDisable(true);
        TextFieldLogin.setDisable(true);
        PasswordFieldSenha.setDisable(true);
        LabelRepitaSenha.setDisable(true);
        PasswordFieldRepitaSenha.setDisable(true);
        HboxGenero.setDisable(true);
        LabelSenha.setDisable(true);
        LabelCpf.setDisable(true);
        TextFieldCpf.setDisable(true);
    }

    public void limparCaixaDeTexto(){
        TextFieldNome.setText("");
        TextFieldSobrenome.setText("");
        TextFieldMatricula.setText("");
        TextFieldTitulacao.setText("");
        TextFieldCurso.setText("");
        TextFieldTelefone.setText("");
        TextFieldeEmail.setText("");
        TextFieldLogin.setText("");
        PasswordFieldSenha.setText("");
        PasswordFieldRepitaSenha.setText("");
        TextFieldCpf.setText("");

    }

    public void salvar(ActionEvent actionEvent) throws SQLException {

        salvaPessoa();
        if (salvar == null){
            LabelMenssagem.setText("Selecione um tipo de item!");
        }else if (salvar.equals("Aluno")){

        }else if(salvar.equals("Professor")){

        }else if(salvar.equals("Funcionário")){


        }

    }

    public void cancelar(ActionEvent actionEvent) throws IOException {
        limparCaixaDeTexto();
    }

    public void salvaPessoa () throws SQLException {

        pessoaModelo.setNome(TextFieldNome.getText());
        pessoaModelo.setSobrenome(TextFieldSobrenome.getText());
        pessoaModelo.setEmail(TextFieldeEmail.getText());

        pessoaModelo.setCpf(TextFieldCpf.getText());


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

    public void salvarFuncionario(){
        funcionarioModelo.setSenha(PasswordFieldSenha.getText());
        funcionarioModelo.setSegundaSenha(PasswordFieldRepitaSenha.getText());

    }
}