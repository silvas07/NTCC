package Dao;


import DAOItil.ConnectDaoItil;
import Modelo.PessoaModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by rdsdo on 07/05/2017.
 */
public class PessoaDAO {

ConnectDaoItil connectDaoItil = null;
private Connection connection;
private Statement statement;
private PreparedStatement preparedStatement;

    public PessoaDAO() {
        ConnectDaoItil connectDaoItil  = new  ConnectDaoItil();
        connection = connectDaoItil.abrirCanneccao();
    }

    public String salvar (PessoaModelo pessoaModelo) throws SQLException {
        String salvo = "falha";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO ntcc.pessoa(nome,sobrenome,genero,email)VALUES(?,?,?,?)");
            preparedStatement.setString(1,pessoaModelo.getNome());
            preparedStatement.setString(2,pessoaModelo.getSobrenome());
            preparedStatement.setString(3,pessoaModelo.getGernero());
            preparedStatement.setString(4,pessoaModelo.getEmail());
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
