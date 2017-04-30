package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 30/04/2017.
 */
public class TermoDeAceiteController implements Initializable {

    @FXML
    private TextField TextFieldMatricula;
    @FXML
    private TextField TextFieldNome;
    @FXML
    private TextField TextFieldTitulacao;
    @FXML
    private TextField TextFieldCurso;
    @FXML
    private TextField TextFieldTelefone;
    @FXML
    private TextField TextFieldEmail;
    @FXML
    private TextArea TextAreaDadosASerOrientados;
    @FXML
    private DatePicker DatePickerDataInicio;
    @FXML
    private DatePicker DatePickerDataFim;

    @FXML
    private TableView TableViewDadosOrientados;
    @FXML
    private TableColumn TableColumnNome;
    @FXML
    private TableColumn TableColumnCueso;
    @FXML
    private TableColumn TableColumnTelefone;
    @FXML
    private TableColumn TableColumnEmail;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void salvar(ActionEvent actionEvent) {
    }

    public void Cacelar(ActionEvent actionEvent) {
    }
}
