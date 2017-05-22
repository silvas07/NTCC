package Negocio;

import Dao.GrupoTCCDAO;
import Modelo.GrupoTCCModelo;

import java.sql.SQLException;

/**
 * Created by rdsdo on 21/05/2017.
 */
public class GrupoTCCNegocio {

    GrupoTCCDAO grupoTCCDAO = new GrupoTCCDAO();

    public void salvarGrupoTCC (GrupoTCCModelo grupoTCCModelo) throws SQLException {
            grupoTCCDAO.salvar(grupoTCCModelo);
    }

    public  boolean testGrupo (GrupoTCCModelo grupoTCCModelo) {
        if ((grupoTCCModelo.getIdTcc() != 0) && (grupoTCCModelo.getIdAluno() != 0)) {
            return true;
        } else {
            return false;
        }
    }
}
