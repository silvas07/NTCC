package Negocio;

import Dao.TCCDAO;
import Modelo.ProfessorModelo;
import Modelo.TCCModelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rdsdo on 15/05/2017.
 */
public class TCCNegocio {
    TCCDAO tccdao = new TCCDAO();
    TCCModelo tccModelo = new TCCModelo();
    List<TCCModelo> listTCC = new ArrayList<TCCModelo>();

    public void salvarTCC(TCCModelo tccModelo ) throws SQLException {
        tccdao.salvar(tccModelo);
    }

    public List<TCCModelo> buscarTCC () throws SQLException {
        listTCC = tccdao.buscarTcc();
        return listTCC;

    }

    public List<TCCModelo> buscarTCCProfessorOrinetador (ProfessorModelo professorModelo) throws SQLException {
        listTCC = tccdao.buscarTCCProfessorOrinetador(professorModelo);
        return listTCC;

    }
}
