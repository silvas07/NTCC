package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.AlunoModelo;
import Modelo.PessoaModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class AlunoDAO {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public AlunoDAO() {
        ConnectDaoItil connectDaoItil  = new  ConnectDaoItil();
        connection = connectDaoItil.abrirCanneccao();
    }

    public String salvar (AlunoModelo alunoModelo) throws SQLException {
        String salvo = "falha";

        try {
            connection.setAutoCommit(false);


            preparedStatement.executeUpdate();
            preparedStatement.setString(1,alunoModelo.getCurso());
            preparedStatement.setString(2,alunoModelo.getMatricula());
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
