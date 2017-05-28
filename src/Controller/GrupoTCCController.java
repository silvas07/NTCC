package Controller;

import Modelo.AlunoModelo;
import Modelo.GrupoTCCModelo;
import Modelo.ProfessorModelo;
import Modelo.TCCModelo;
import Negocio.AlunoNegocio;
import Negocio.GrupoTCCNegocio;
import Negocio.ProfessorNegocio;
import Negocio.TCCNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class GrupoTCCController implements Initializable {

    @FXML
    private Label LabelTituloTcc;
    @FXML
    private ComboBox<String> ComboBoxTituloTcc;
    @FXML
    private Button ButtonTituloTcc;

    @FXML
    private Label LabelProfessorOrientador;
    @FXML
    private  TextField TextFieldProfessorOrientador;
    @FXML
    private Label LabelMatriculaProfessorOrientador;
    @FXML
    private TextField TextFieldMatriculaProfessorOrientador;
    @FXML
    private Button ButtonProfessorOrientador;

    @FXML
    private Label Label1Intregante;
    @FXML
    private  TextField TextField1Intregante;
    @FXML
    private  Label LabelMatricula1Intregante;
    @FXML
    private  TextField TextFieldMatricula1Intregante;
    @FXML
    private  Button Button1Intregante;

    @FXML
    private Label Label2Intregante;
    @FXML
    private  TextField TextField2Intregante;
    @FXML
    private  Label LabelMatricula2Intregante;
    @FXML
    private  TextField TextFieldMatricula2Intregante;
    @FXML
    private  Button Button2Intregante;

    @FXML
    private Label Label3Intregante;
    @FXML
    private  TextField TextField3Intregante;
    @FXML
    private  Label LabelMatricula3Intregante;
    @FXML
    private  TextField TextFieldMatricula3Intregante;
    @FXML
    private  Button Button3Intregante;

    @FXML
    private Label Label4Intregante;
    @FXML
    private  TextField TextField4Intregante;
    @FXML
    private  Label LabelMatricula4Intregante;
    @FXML
    private  TextField TextFieldMatricula4Intregante;
    @FXML
    private  Button Button4Intregante;

    @FXML
    private Label Label5Intregante;
    @FXML
    private  TextField TextField5Intregante;
    @FXML
    private  Label LabelMatricula5Intregante;
    @FXML
    private  TextField TextFieldMatricula5Intregante;

    @FXML
    private HBox HboxSalvarCancelar1;
    @FXML
    private HBox HboxSalvarCancelar2;
    @FXML
    private HBox HboxSalvarCancelar3;
    @FXML
    private HBox HboxSalvarCancelar4;
    @FXML
    private HBox HboxSalvarCancelar5;

    @FXML
    private  HBox Hbox1Intregante;
    @FXML
    private  HBox Hbox2Intregante;
    @FXML
    private  HBox Hbox3Intregante;
    @FXML
    private  HBox Hbox4Intregante;
    @FXML
    private  HBox Hbox5Intregante;

    @FXML
    private  Button ButonBuscar1;
    @FXML
    private  Button ButonBuscar2;
    @FXML
    private  Button ButonBuscar3;
    @FXML
    private  Button ButonBuscar4;
    @FXML
    private  Button ButonBuscar5;

    @FXML
    private GridPane GridPaneCadastroGruposTCC;

    GrupoTCCModelo grupoTCCModelo = new GrupoTCCModelo();
    GrupoTCCNegocio grupoTCCNegocio = new GrupoTCCNegocio();

    TCCModelo tccModelo = new TCCModelo();
    TCCNegocio tccNegocio = new TCCNegocio();

    ProfessorModelo professorModelo = new ProfessorModelo();
    ProfessorNegocio professorNegocio = new ProfessorNegocio();

    AlunoModelo alunoModelo1 = new AlunoModelo();
    AlunoModelo alunoModelo2 = new AlunoModelo();
    AlunoModelo alunoModelo3 = new AlunoModelo();
    AlunoModelo alunoModelo4 = new AlunoModelo();
    AlunoModelo alunoModelo5 = new AlunoModelo();
    AlunoNegocio alunoNegocio = new AlunoNegocio();

    List<TCCModelo> listTCC = new ArrayList<TCCModelo>();

    @Override
    public void initialize(URL location, ResourceBundle resources   ) {
        try {
            carregarComboBox();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ButtonNovo1Intregante(ActionEvent actionEvent) throws SQLException {
        Label2Intregante.setVisible(true);
        TextField2Intregante.setVisible(true);
        LabelMatricula2Intregante.setVisible(true);
        TextFieldMatricula2Intregante.setVisible(true);
        Hbox2Intregante.setVisible(true);
        ButonBuscar2.setVisible(true);
        Button2Intregante.setVisible(true);
        Button1Intregante.setVisible(false);
        HboxSalvarCancelar1.setVisible(false);
        HboxSalvarCancelar2.setVisible(true);
    }

    public void ButtonNovo2Intregante(ActionEvent actionEvent) {
        Label3Intregante.setVisible(true);
        TextField3Intregante.setVisible(true);
        LabelMatricula3Intregante.setVisible(true);
        TextFieldMatricula3Intregante.setVisible(true);
        Hbox3Intregante.setVisible(true);
        ButonBuscar3.setVisible(true);
        Button3Intregante.setVisible(true);
        Button2Intregante.setVisible(false);
        HboxSalvarCancelar2.setVisible(false);
        HboxSalvarCancelar3.setVisible(true);
    }

    public void ButtonNovo3Intregante(ActionEvent actionEvent) {
        Label4Intregante.setVisible(true);
        TextField4Intregante.setVisible(true);
        LabelMatricula4Intregante.setVisible(true);
        TextFieldMatricula4Intregante.setVisible(true);
        Hbox4Intregante.setVisible(true);
        ButonBuscar4.setVisible(true);
        Button4Intregante.setVisible(true);
        Button3Intregante.setVisible(false);
        HboxSalvarCancelar3.setVisible(false);
        HboxSalvarCancelar4.setVisible(true);
    }

    public void ButtonNovo4Intregante(ActionEvent actionEvent) {
        Label5Intregante.setVisible(true);
        TextField5Intregante.setVisible(true);
        LabelMatricula5Intregante.setVisible(true);
        TextFieldMatricula5Intregante.setVisible(true);
        Hbox5Intregante.setVisible(true);
        ButonBuscar5.setVisible(true);
        Button4Intregante.setVisible(false);
        HboxSalvarCancelar4.setVisible(false);
        HboxSalvarCancelar5.setVisible(true);
    }

    public void limparCampos (){
        Button1Intregante.setVisible(true);
        Button2Intregante.setVisible(false);
        Button3Intregante.setVisible(false);
        Button4Intregante.setVisible(false);
        HboxSalvarCancelar1.setVisible(true);
        HboxSalvarCancelar2.setVisible(false);
        HboxSalvarCancelar3.setVisible(false);
        HboxSalvarCancelar4.setVisible(false);
        HboxSalvarCancelar5.setVisible(false);
        Label2Intregante.setVisible(false);
        TextField2Intregante.setVisible(false);
        LabelMatricula2Intregante.setVisible(false);
        TextFieldMatricula2Intregante.setVisible(false);
        Label3Intregante.setVisible(false);
        TextField3Intregante.setVisible(false);
        LabelMatricula3Intregante.setVisible(false);
        TextFieldMatricula3Intregante.setVisible(false);
        Label4Intregante.setVisible(false);
        TextField4Intregante.setVisible(false);
        LabelMatricula4Intregante.setVisible(false);
        TextFieldMatricula4Intregante.setVisible(false);
        Label5Intregante.setVisible(false);
        TextField5Intregante.setVisible(false);
        LabelMatricula5Intregante.setVisible(false);
        TextFieldMatricula5Intregante.setVisible(false);
        ComboBoxTituloTcc.getItems().clear();
        TextFieldProfessorOrientador.setText("");
        TextFieldMatriculaProfessorOrientador.setText("");
        TextField1Intregante.setText("");
        TextFieldMatricula1Intregante.setText("");
        TextField2Intregante.setText("");
        TextFieldMatricula2Intregante.setText("");
        TextField3Intregante.setText("");
        TextFieldMatricula3Intregante.setText("");
        TextField4Intregante.setText("");
        TextFieldMatricula4Intregante.setText("");
        TextField5Intregante.setText("");
        TextFieldMatricula5Intregante.setText("");
        ButtonProfessorOrientador.setDisable(false);
        ButtonTituloTcc.setDisable(false);
        ButonBuscar1.setVisible(true);
        ButonBuscar2.setVisible(false);
        ButonBuscar3.setVisible(false);
        ButonBuscar4.setVisible(false);
        ButonBuscar5.setVisible(false);
    }

    public void cancelarGrupo(ActionEvent actionEvent) {
        limparCampos();
    }

    public void carregarComboBox () throws SQLException {
        for (int i = 0 ; i < listTCC.size() ; i++){
            tccModelo = listTCC.get(i);
            ComboBoxTituloTcc.getItems().addAll(tccModelo.getTitulo() + " (" + tccModelo.getTipoTCC() + ")");
        }

    }

    public void buscarAluno1(ActionEvent actionEvent) throws SQLException {
        alunoModelo1=null;
        TextField1Intregante.setText("");
        alunoModelo1 = alunoNegocio.buscarAluno(TextField1Intregante.getText(), TextFieldMatricula1Intregante.getText());
        if (alunoModelo1.getNome() == null) {
            TextField1Intregante.setPromptText("Aluno não encontrado.");
        } else {
            TextField1Intregante.setText(alunoModelo1.getNome() + " " + alunoModelo1.getSobrenome());
            TextFieldMatricula1Intregante.setText(alunoModelo1.getMatricula());
        }
    }

    public void buscarAluno2(ActionEvent actionEvent) throws SQLException {
        alunoModelo2=null;
        TextField2Intregante.setText("");
        alunoModelo2 = alunoNegocio.buscarAluno(TextField2Intregante.getText(), TextFieldMatricula2Intregante.getText());
        if (alunoModelo2.getNome() == null) {
            TextField2Intregante.setPromptText("Aluno não encontrado.");
        } else {
            TextField2Intregante.setText(alunoModelo2.getNome() + " " + alunoModelo2.getSobrenome());
            TextFieldMatricula2Intregante.setText(alunoModelo2.getMatricula());

        }
    }

    public void buscarAluno3(ActionEvent actionEvent) throws SQLException {
        alunoModelo3=null;
        TextField3Intregante.setText("");
        alunoModelo3 = alunoNegocio.buscarAluno(TextField3Intregante.getText(), TextFieldMatricula3Intregante.getText());
        if (alunoModelo3.getNome() == null) {
            TextField3Intregante.setPromptText("Aluno não encontrado.");
        } else {
            TextField3Intregante.setText(alunoModelo3.getNome() + " " + alunoModelo3.getSobrenome());
            TextFieldMatricula3Intregante.setText(alunoModelo3.getMatricula());

        }
    }

    public void buscarAluno4(ActionEvent actionEvent) throws SQLException {
        alunoModelo4=null;
        TextField4Intregante.setText("");
        alunoModelo4 = alunoNegocio.buscarAluno(TextField4Intregante.getText(), TextFieldMatricula4Intregante.getText());
        if (alunoModelo4.getNome() == null) {
            TextField4Intregante.setPromptText("Aluno não encontrado.");
        } else {
            TextField4Intregante.setText(alunoModelo4.getNome() + " " + alunoModelo4.getSobrenome());
            TextFieldMatricula4Intregante.setText(alunoModelo4.getMatricula());

        }
    }

    public void buscarAluno5(ActionEvent actionEvent) throws SQLException {
        alunoModelo5=null;
        TextField5Intregante.setText("");
        alunoModelo5 = alunoNegocio.buscarAluno(TextField5Intregante.getText(), TextFieldMatricula5Intregante.getText());
        if (alunoModelo5.getNome() == null) {
            TextField5Intregante.setPromptText("Aluno não encontrado.");
        } else {
            TextField5Intregante.setText(alunoModelo5.getNome() + " " + alunoModelo5.getSobrenome());
            TextFieldMatricula5Intregante.setText(alunoModelo5.getMatricula());

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

    public void salvarGrupo(ActionEvent actionEvent) throws SQLException {

        for(int i = 0 ; i<listTCC.size() ; i++ ){
            tccModelo = listTCC.get(i);
            if(tccModelo.getTitulo().equals(ComboBoxTituloTcc.getValue())){
                break;
            }

        }

        grupoTCCModelo.setIdTcc(tccModelo.getId());
        if (alunoModelo1.getNome() != null) {
            grupoTCCModelo.setIdAluno(alunoModelo1.getId());
            grupoTCCNegocio.salvarGrupoTCC(grupoTCCModelo);
        }
        if (alunoModelo2.getNome() != null) {
            grupoTCCModelo.setIdAluno(alunoModelo2.getId());
            grupoTCCNegocio.salvarGrupoTCC(grupoTCCModelo);
        }
        if (alunoModelo3.getNome() != null) {
            grupoTCCModelo.setIdAluno(alunoModelo3.getId());
            grupoTCCNegocio.salvarGrupoTCC(grupoTCCModelo);
        }
        if (alunoModelo4.getNome() != null) {
            grupoTCCModelo.setIdAluno(alunoModelo4.getId());
            grupoTCCNegocio.salvarGrupoTCC(grupoTCCModelo);
        }
        if (alunoModelo5.getNome() != null) {
            grupoTCCModelo.setIdAluno(alunoModelo5.getId());
            grupoTCCNegocio.salvarGrupoTCC(grupoTCCModelo);
        }
        limparCampos();

    }
}
