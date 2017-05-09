package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.ProfessorModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class ProfessorDAO {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public ProfessorDAO() {
        ConnectDaoItil connectDaoItil  = new  ConnectDaoItil();
        connection = connectDaoItil.abrirCanneccao();
    }

    public String salvar (ProfessorModelo professorModelo) throws SQLException {
        String salvo = "falha";

        try {

            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO ntcc.professor(nome,sobrenome,genero,email,matricula,titulacao,telefone)VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setString(1,professorModelo.getNome());
            preparedStatement.setString(2,professorModelo.getSobrenome());
            preparedStatement.setString(3,professorModelo.getGenero());
            preparedStatement.setString(4,professorModelo.getEmail());
            preparedStatement.setString(5,professorModelo.getMatricula());
            preparedStatement.setString(6,professorModelo.getTitulacao());
            preparedStatement.setString(7,professorModelo.getTelefone());
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

}
