package Negocio;

import Dao.ProfessorDAO;
import Dao.ProfessorLeitorDAO;
import Modelo.ProfessorLeitorModelo;
import Modelo.ProfessorModelo;
import java.sql.SQLException;


/**
 * Created by rdsdo on 01/05/2017.
 */
public class ProfessorNegocio extends PessoaNegocio {
    ProfessorDAO professorDAO = new ProfessorDAO();
    ProfessorModelo professorModelo = new ProfessorModelo();
    ProfessorLeitorDAO professorLeitorDAO = new ProfessorLeitorDAO();


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


    public ProfessorModelo buscarProfessorOrientador (String matricula , String nome) throws SQLException{
        professorModelo = professorDAO.buscarProfessorOrientador(matricula,nome);
        return professorModelo;
    }

    public void salvarProfessorLeitor (ProfessorLeitorModelo professorLeitorModelo) throws SQLException {
        professorLeitorDAO.salvarProfessorLeitor(professorLeitorModelo);

    }



}
