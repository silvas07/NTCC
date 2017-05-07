package Negocio;

import Dao.AlunoDAO;
import Modelo.AlunoModelo;

import java.sql.SQLException;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class AlunoNegocio extends  PessoaNegocio{
    public void salvarAluno (AlunoModelo alunoModelo) throws SQLException {
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.salvar(alunoModelo);
    }
}
