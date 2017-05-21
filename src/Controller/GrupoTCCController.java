package Controller;

import Modelo.GrupoTCCModelo;
import Modelo.ProfessorModelo;
import Modelo.TCCModelo;
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
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 19/05/2017.
 */
public class GrupoTCCController implements Initializable {

    @FXML
    private Label LabelTituloTcc;
    @FXML
    private ComboBox<String> ComboBoxTituloTcc;
    @FXML
    private Button ButtonTituloTcc;

    @FXML
    private Label LabelProfessorPrientador;
    @FXML
    private  TextField TextFieldProfessorPrientador;
    @FXML
    private Label LabelMatriculaProfessorPrientador;
    @FXML
    private TextField TextFieldMatriculaProfessorPrientador;
    @FXML
    private Button ButtonProfessorPrientador;

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
    private GridPane GridPaneCadastroGruposTCC;


    GrupoTCCModelo grupoTCCModelo = new GrupoTCCModelo();
    GrupoTCCNegocio grupoTCCNegocio = new GrupoTCCNegocio();

    TCCModelo tccModelo = new TCCModelo();
    TCCNegocio tccNegocio = new TCCNegocio();

    ProfessorModelo professorModelo = new ProfessorModelo();
    ProfessorNegocio professorNegocio = new ProfessorNegocio();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void ButtonBuscarTituloTcc(ActionEvent actionEvent) {
    }

    public void ButtonBuscarProfessorOrientador(ActionEvent actionEvent) {
    }

    public void ButtonNovo1Intregante(ActionEvent actionEvent) {
        Label2Intregante.setVisible(true);
        TextField2Intregante.setVisible(true);
        LabelMatricula2Intregante.setVisible(true);
        TextFieldMatricula2Intregante.setVisible(true);
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
        Button4Intregante.setVisible(false);
        HboxSalvarCancelar4.setVisible(false);
        HboxSalvarCancelar5.setVisible(true);
    }

    public void salvarGrupo(ActionEvent actionEvent) {

    }

    public void cancelarGrupo(ActionEvent actionEvent) {

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


        ComboBoxTituloTcc.setValue("");
        TextFieldProfessorPrientador.setText("");
        TextFieldMatriculaProfessorPrientador.setText("");

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



    }


}
