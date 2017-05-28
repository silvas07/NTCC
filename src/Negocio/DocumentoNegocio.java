package Negocio;

import Dao.DocumentoDAO;
import Modelo.DocumentoModelo;

import java.sql.SQLException;

/**
 * Created by rdsdo on 24/05/2017.
 */
public class DocumentoNegocio {
    DocumentoDAO documentoDAO = new DocumentoDAO();


    public  void salvarDocumento (DocumentoModelo documentoModelo) throws SQLException{
        documentoDAO.salvarDocumento(documentoModelo);
    }

}
