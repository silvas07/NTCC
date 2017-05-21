package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.GrupoTCCModelo;
import java.sql.*;


/**
 * Created by rdsdo on 21/05/2017.
 */
public class GrupoTCCDAO {
    ConnectDaoItil connectDaoItil = null;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public GrupoTCCDAO() {
        ConnectDaoItil connectDaoItil  = new  ConnectDaoItil();
        connection = connectDaoItil.abrirCanneccao();
    }

    public String salvar ( GrupoTCCModelo grupoTCCModelo) throws SQLException {
        String salvo = "falha";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO ntcc.grupo_tcc(id_tcc,id_aluno)VALUES(?,?)");
            preparedStatement.setInt(1, grupoTCCModelo.getIdTcc());
            preparedStatement.setInt(2,grupoTCCModelo.getIdAluno());
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
