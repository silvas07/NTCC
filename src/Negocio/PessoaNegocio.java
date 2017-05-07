package Negocio;


import Dao.PessoaDAO;
import Modelo.PessoaModelo;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rdsdo on 07/05/2017.
 */
public class PessoaNegocio {

    public void salvarPessoa (PessoaModelo pessoaModelo) throws SQLException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.salvar(pessoaModelo);


    }


    public  boolean validarEmail(String email) {
        if ((email == null) || (email.trim().length() == 0))
            return false;

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*" +
                "((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
