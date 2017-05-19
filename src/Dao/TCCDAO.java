package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.CursoModelo;
import Modelo.TCCModelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rdsdo on 15/05/2017.
 */
public class TCCDAO {


        private Connection connection;
        private Statement statement;
        private PreparedStatement preparedStatement;

        public TCCDAO() {
            ConnectDaoItil connectDaoItil  = new  ConnectDaoItil();
            connection = connectDaoItil.abrirCanneccao();
        }

        public String salvar (TCCModelo tccModelo) throws SQLException {
            String salvo = "falha";

            try {
                connection.setAutoCommit(false);
                preparedStatement = connection.prepareStatement("INSERT INTO ntcc.tcc(tipo_tcc,titulo,data_inicio,data_fim," +
                        "id_Curso,id_professor,id_grupoTCC)VALUES(?,?,?,?,?,?,?)");

                preparedStatement.setString(1,tccModelo.getTipoTCC());
                preparedStatement.setString(2, tccModelo.getTitulo());
                preparedStatement.setDate(3, Date.valueOf(tccModelo.getDataInicio()));
                preparedStatement.setDate(4, Date.valueOf(tccModelo.getDataFim()));
                preparedStatement.setInt(5,tccModelo.getIdCurso());
                preparedStatement.setInt(6, tccModelo.getIdProfessor());
                preparedStatement.setInt(7,tccModelo.getIdGrupoTCC());





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
}
