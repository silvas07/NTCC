package Controller;

import Modelo.CursoModelo;
import Negocio.CursoNegocio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

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

    List<CursoModelo> listCurso = new ArrayList<>();
    CursoModelo cursoModelo = new CursoModelo();
    CursoNegocio cursoNegocio = new CursoNegocio();





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


}
