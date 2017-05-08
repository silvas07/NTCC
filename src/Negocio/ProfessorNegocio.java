package Negocio;

import Dao.ProfessorDAO;
import Modelo.ProfessorModelo;

import java.sql.SQLException;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class ProfessorNegocio extends PessoaNegocio {
    public void salvarProfessor (ProfessorModelo professorModelo) throws SQLException {
        ProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.salvar(professorModelo);
    }

}
