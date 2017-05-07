package Negocio;

import Dao.ProfessorDAO;

import java.sql.SQLException;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class ProfessorNegocio extends PessoaNegocio {
    public void salvarProfessor (ProfessorNegocio professorNegocio) throws SQLException {
        ProfessorDAO professorDAO = new ProfessorDAO();
        professorDAO.salvar(professorNegocio);
    }

}
