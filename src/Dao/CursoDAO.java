package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.CursoModelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rdsdo on 14/05/2017.
 */
public class CursoDAO {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public CursoDAO() {
        ConnectDaoItil connectDaoItil  = new  ConnectDaoItil();
        connection = connectDaoItil.abrirCanneccao();
    }

    public String salvar (CursoModelo cursoModelo) throws SQLException {
        String salvo = "falha";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO ntcc.curso(nome_curso)VALUES(?);");
            preparedStatement.setString(1,cursoModelo.getCurso());
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

    public List<CursoModelo> buscar () throws SQLException{
        List<CursoModelo> listCurso = new ArrayList<CursoModelo>();

        ResultSet resposta = null;

        try {
            statement = connection.createStatement();
            resposta = statement.executeQuery("select * from curso ");
            while (resposta.next()) {

                CursoModelo cursoModelo = new CursoModelo();
                cursoModelo.setId(resposta.getInt("id"));
                cursoModelo.setCurso(resposta.getString("nome_curso"));

                listCurso.add(cursoModelo);
            }
        }
        catch (SQLException e){
            System.out.println("Erro na consulta1:" + e.getMessage());
        }
        return listCurso;
    }



    public CursoModelo buscarCurso (String nomeCurso) throws SQLException{

        ResultSet resultSet = null;
        CursoModelo cursoModelo = new CursoModelo();

        try {
            preparedStatement = connection.prepareStatement("select * from curso where nome_curso = ?");
            preparedStatement.setString(1, nomeCurso);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cursoModelo.setId(resultSet.getInt("id"));
                cursoModelo.setCurso(resultSet.getString("nome_curso"));
            }
        }catch (SQLException e){
            System.out.println("Erro na consulta1:" + e.getMessage());
        }
        return cursoModelo;
    }
}
