package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.AlunoModelo;
import Modelo.CursoModelo;
import Modelo.PessoaModelo;

import java.sql.*;

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
            preparedStatement = connection.prepareStatement("INSERT INTO ntcc.aluno(nome,sobrenome,genero,email,matricula,curso,telefone,rg)VALUES(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,alunoModelo.getNome());
            preparedStatement.setString(2,alunoModelo.getSobrenome());
            preparedStatement.setString(3,alunoModelo.getGenero());
            preparedStatement.setString(4,alunoModelo.getEmail());
            preparedStatement.setString(5,alunoModelo.getMatricula());
            preparedStatement.setString(6,alunoModelo.getCurso());
            preparedStatement.setString(7,alunoModelo.getTelefone());
            preparedStatement.setString(8, alunoModelo.getRg());
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

    public AlunoModelo buscarAluno (String nomeAluno , String matricula) throws SQLException{

        ResultSet resultSet = null;
        AlunoModelo alunoModelo = new AlunoModelo();

        try {
            preparedStatement = connection.prepareStatement("select * from aluno where nome= ? or matricula = ?");
            preparedStatement.setString(1,nomeAluno );
            preparedStatement.setString(2,matricula);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                alunoModelo .setId(resultSet.getInt("id"));
                alunoModelo.setNome(resultSet.getString("nome"));
                alunoModelo.setSobrenome(resultSet.getString("sobrenome"));
                alunoModelo.setGenero(resultSet.getString("genero"));
                alunoModelo.setEmail(resultSet.getString("email"));
                alunoModelo.setMatricula(resultSet.getString("matricula"));
                alunoModelo.setCurso(resultSet.getString("curso"));
                alunoModelo.setTelefone(resultSet.getString("telefone"));
                alunoModelo.setRg(resultSet.getString("rg"));

            }
        }catch (SQLException e){
            System.out.println("Erro na consulta1:" + e.getMessage());
        }
        return alunoModelo;
    }
}
