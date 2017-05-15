package Negocio;

import Dao.ProfessorDAO;
import Modelo.ProfessorModelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class ProfessorNegocio extends PessoaNegocio {
    ProfessorDAO professorDAO = new ProfessorDAO();
    ProfessorModelo professorModelo = new ProfessorModelo();
    List<ProfessorModelo> listarProfessor = new ArrayList<ProfessorModelo>();

    public void salvarProfessor (ProfessorModelo professorModelo) throws SQLException {
        if(!professorModelo.getNome().equals("") &&
                !professorModelo.getSobrenome().equals("") &&
                !professorModelo.getTitulacao().equals("") &&
                !professorModelo.getMatricula().equals("") &&
                !professorModelo.getEmail().equals("") ){

            if(validarEmail(professorModelo.getEmail()) == true){
                professorDAO.salvar(professorModelo);
            }else {
                System.out.println("E-mail incorreto"); // COLOCAR MENSSAGEM
            }

        }else {
            System.out.println("FAltou algum campo incorreto"); // COLOCAR MENSSAGEM
        }


    }

    public List<ProfessorModelo> buscarProfessorOrientador () throws SQLException {
     listarProfessor = professorDAO.buscarProfessorOrientador();

        return listarProfessor;
    }



}
