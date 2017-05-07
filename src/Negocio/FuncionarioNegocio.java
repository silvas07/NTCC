package Negocio;


import Dao.FuncionarioDAO;
import Modelo.FuncionarioModelo;

import java.sql.SQLException;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class FuncionarioNegocio extends PessoaNegocio {

public void salvarFuncionario (FuncionarioModelo funcionarioModelo) throws SQLException {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    funcionarioDAO.salvar(funcionarioModelo);

}

    public String verificarLoginSenha (String textFieldLogin,String passwordFieldSenha){
        if(textFieldLogin.equals("")) {
            return "NãoEntra";
        }else if (passwordFieldSenha.equals("")) {
            return "NãoEntra";
        }else if (textFieldLogin.equals("root") && passwordFieldSenha.equals("root") ) {
            return "Entra";
        }
        return "NãoEntra";
    }

}
