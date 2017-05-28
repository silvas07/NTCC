package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.ProfessorLeitorModelo;
import Modelo.ProfessorModelo;

import java.sql.*;

/**
 * Created by rdsdo on 28/05/2017.
 */
public class ProfessorLeitorDAO {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public ProfessorLeitorDAO () {
        ConnectDaoItil connectDaoItil  = new  ConnectDaoItil();
        connection = connectDaoItil.abrirCanneccao();
    }

    public String salvarProfessorLeitor (ProfessorLeitorModelo professorLeitorModelo) throws SQLException {
        String salvo = "falha";

        try {

            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO ntcc.professor_leitor(id_professor,id_tcc)VALUES(?,?)");
            preparedStatement.setInt(1,professorLeitorModelo.getIdProfessor());
            preparedStatement.setInt(2,professorLeitorModelo.getIdTcc());

            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    System.err.print("Rollback efetuado na transação");
                    connection.rollback();
                } catch(SQLException e2) {
                    System.err.print("Erro na transação!"+e2);
                    salvo = "\"Erro na transação!\"+e2";
                }
            }
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            connection.setAutoCommit(true);
        }
        return salvo;
    }

   /* public ProfessorModelo buscarProfessorOrientador (String matricula , String nome) throws SQLException{

        ResultSet resposta = null;
        ProfessorModelo professorModelo = new ProfessorModelo();

        try {
            preparedStatement = connection.prepareStatement("select * from professor where matricula = ? or nome= ?");
            preparedStatement.setString(1, matricula);
            preparedStatement.setString(2,nome);
            resposta = preparedStatement.executeQuery();

            while (resposta.next()) {

                professorModelo.setId(resposta.getInt("id"));
                professorModelo.setNome(resposta.getString("nome"));
                professorModelo.setSobrenome(resposta.getString("sobrenome"));
                professorModelo.setGenero(resposta.getString("genero"));
                professorModelo.setEmail(resposta.getString("email"));
                professorModelo.setMatricula(resposta.getString("matricula"));
                professorModelo.setTitulacao(resposta.getString("titulacao"));
                professorModelo.setTelefone(resposta.getString("telefone"));


            }
        }
        catch (SQLException e){
            System.out.println("Erro na consulta1:" + e.getMessage());
        }

        return professorModelo ;
    }*/
}
