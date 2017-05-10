package Negocio;

import Dao.AlunoDAO;
import Modelo.AlunoModelo;

import java.sql.SQLException;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class AlunoNegocio extends  PessoaNegocio{
    AlunoDAO alunoDAO = new AlunoDAO();
    public void salvarAluno (AlunoModelo alunoModelo) throws SQLException {

        if(!alunoModelo.getNome().equals("") &&
                !alunoModelo.getSobrenome().equals("") &&
                !alunoModelo.getCurso().equals("") &&
                !alunoModelo.getMatricula().equals("") &&
                !alunoModelo.getEmail().equals("") &&
                !alunoModelo.getRg().equals("")){

            if(validarEmail(alunoModelo.getEmail()) == true){
                alunoDAO.salvar(alunoModelo);
            }else {
                System.out.println("E-mail incorreto"); // COLOCAR MENSSAGEM
            }

        }else {
            System.out.println("FAltou algum campo incorreto"); // COLOCAR MENSSAGEM
        }





    }
}
