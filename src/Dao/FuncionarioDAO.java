package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.FuncionarioModelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class FuncionarioDAO {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;


    public FuncionarioDAO() {
        ConnectDaoItil connectDaoItil  = new  ConnectDaoItil();
        connection = connectDaoItil.abrirCanneccao();
    }



    public String salvar ( FuncionarioModelo funcionarioModelo) throws SQLException {
        String salvo = "falha";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO ntcc.funcionario(nome,sobrenome,matricula,login,senha)VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, funcionarioModelo.getNome());
            preparedStatement.setString(2,funcionarioModelo.getSobrenome());
            preparedStatement.setString(3, funcionarioModelo.getMatricula());
            preparedStatement.setString(4,funcionarioModelo.getLogin());
            preparedStatement.setString(5, funcionarioModelo.getSenha());
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

    public List<FuncionarioModelo> buscar () throws SQLException{
            List<FuncionarioModelo> listFuncionario = new ArrayList<FuncionarioModelo>();

            ResultSet resposta = null;

            try {



                    statement = connection.createStatement();
                    resposta = statement.executeQuery("select * from funcionario ");
                while (resposta.next()) {
                    FuncionarioModelo funcionarioModelo = new FuncionarioModelo();

                    funcionarioModelo.setId(resposta.getInt("id"));
                    funcionarioModelo.setNome(resposta.getString("nome"));
                    funcionarioModelo.setSobrenome(resposta.getString("sobrenome"));
                    funcionarioModelo.setMatricula(resposta.getString("matricula"));
                    funcionarioModelo.setLogin(resposta.getString("login"));
                    funcionarioModelo.setSenha(resposta.getString("Senha"));

                    listFuncionario.add(funcionarioModelo);

                }
            }
            catch (SQLException e){
                System.out.println("Erro na consulta1:" + e.getMessage());
            }
            return listFuncionario ;

        }

    }

