package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rdsdo on 30/04/2017.
 */
public class TermoDeAutorizaçaoBibliotecaController implements Initializable {

    @FXML
    private TextField TextFieldMatriculaTCC;
    @FXML
    private ListView ListViewNomes;
    @FXML
    private TextField TextFieldTelefone;
    @FXML
    private TextField TextFieldEmail;
    @FXML
    private TextField TextFieldCurso;
    @FXML
    private TextField TextFieldModalidade;
    @FXML
    private TextArea TextAreaTitulo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Buscar(ActionEvent actionEvent) {
    }

    public void Salvar(ActionEvent actionEvent) {
    }

    public void Cancelar(ActionEvent actionEvent) {
    }
}
