package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 29/04/2017.
 */
public class AtaDeDefasaController implements Initializable {


    @FXML
    private TextField TextFieldCodigoTCC;
    @FXML
    private TextField TextFieldProfessorOrientador;
    @FXML
    private TextField TextFieldTitulacaoProfessorOrientador;
    @FXML
    private TextField TextFieldProfessorLeitorTCC;
    @FXML
    private TextField TextFieldProfessorLeitorTCCTitulacao;
    @FXML
    private TextField TextFieldProfessorLeitor;
    @FXML
    private TextField TextFieldProfessorLeitorTitulacao;
    @FXML
    private TableView TableViewAtaDeDefasa;
    @FXML
    private TableColumn TableColumnNome;
    @FXML
    private TableColumn TableColumnCurso;
    @FXML
    private TableColumn TableColumnAF;
    @FXML
    private TableColumn TableColumnAP;
    @FXML
    private TableColumn TableColumnNF;
    @FXML
    private TableColumn TableColumnResultado;

    public void Salvar(ActionEvent actionEvent) {
    }

    public void Editar(ActionEvent actionEvent) {
    }

    public void Buscar(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
