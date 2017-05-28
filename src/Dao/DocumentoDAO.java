package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.DocumentoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by rdsdo on 24/05/2017.
 */
public class DocumentoDAO {

    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;

    public  DocumentoDAO(){
        ConnectDaoItil connectDaoItil  = new  ConnectDaoItil();
        connection = connectDaoItil.abrirCanneccao();
    }


    public  String salvarDocumento (DocumentoModelo documentoModelo) throws SQLException {
        String salvo = "falha";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO ntcc.documento(nome_documento)VALUES(?)");
            preparedStatement.setString(1, documentoModelo.getNomeDocumento());
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
