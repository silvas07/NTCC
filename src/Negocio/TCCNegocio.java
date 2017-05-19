package Negocio;

import Dao.TCCDAO;
import Modelo.TCCModelo;

import java.sql.SQLException;

/**
 * Created by rdsdo on 15/05/2017.
 */
public class TCCNegocio {
    TCCDAO tccdao = new TCCDAO();
    TCCModelo tccModelo = new TCCModelo();

    public void salvarTCC(TCCModelo tccModelo ) throws SQLException {
        tccdao.salvar(tccModelo);
    }
}
