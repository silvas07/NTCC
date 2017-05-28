package Negocio;


import Dao.FuncionarioDAO;
import Modelo.FuncionarioModelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class FuncionarioNegocio extends PessoaNegocio {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    FuncionarioModelo funcionarioModelo = new FuncionarioModelo();
    List<FuncionarioModelo> listFuncionario = new ArrayList<FuncionarioModelo>();

    public void salvarFuncionario (FuncionarioModelo funcionarioModelo) throws SQLException {
        if(!funcionarioModelo.getLogin().equals("") &&
                !funcionarioModelo.getNome().equals("") &&
                !funcionarioModelo.getMatricula().equals("") &&
                !funcionarioModelo.getSobrenome().equals("") &&
                !funcionarioModelo.getSenha().equals("") &&
                !funcionarioModelo.getSegundaSenha().equals("")) {
            if(funcionarioModelo.getSenha().equals(funcionarioModelo.getSegundaSenha())) {
                funcionarioDAO.salvar(funcionarioModelo);
            }else {
                System.out.println("As senhas não são iguais"); // COLOCAR MENSSAGEM
            }
        }else {
            System.out.println("Faltou algum campo"); // COLOCAR MENSSAGEM
        }


    }

    public String verificarLoginSenha (String textFieldLogin,String passwordFieldSenha) throws SQLException {


       listFuncionario = funcionarioDAO.buscar();

        if(textFieldLogin.equals("")) {
            return "NãoEntra";
        }else if (passwordFieldSenha.equals("")) {
            return "NãoEntra";
        }else if (verificarListaLoginSenha(textFieldLogin , passwordFieldSenha) == true ){
            return "Entra";
        }
        return "NãoEntra";
    }

    public boolean verificarListaLoginSenha (String textFieldLogin,String passwordFieldSenha) throws SQLException {

        for (int i = 0; i < listFuncionario.size() ; i ++){
            funcionarioModelo = listFuncionario.get(i);


            if(textFieldLogin.equals(funcionarioModelo.getLogin()) && passwordFieldSenha.equals(funcionarioModelo.getSenha())){
                return true;
            }

        }
        return false;

    }

    public void editar(String senha , String matricula) throws SQLException {
        funcionarioDAO.editar(senha , matricula);

    }

}
