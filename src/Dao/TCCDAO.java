package Dao;

import DAOItil.ConnectDaoItil;
import Modelo.CursoModelo;
import Modelo.ProfessorModelo;
import Modelo.TCCModelo;
import Negocio.TCCNegocio;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import static java.lang.String.valueOf;

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

        public List<TCCModelo> buscarTcc() throws SQLException{
            List<TCCModelo> listTCC = new ArrayList<TCCModelo>();

            ResultSet resposta = null;

            try {
                statement = connection.createStatement();
                resposta = statement.executeQuery("select * from tcc ");
                while (resposta.next()) {

                    TCCModelo tccModelo = new TCCModelo();
                    tccModelo.setId(resposta.getInt("id"));
                    tccModelo.setTipoTCC(resposta.getString("tipo_tcc"));
                    tccModelo.setTitulo(resposta.getString("titulo"));
                    Date data = resposta.getDate("data_inicio");
                    tccModelo.setDataInicio(data.toLocalDate());
                    data = resposta.getDate("data_fim");
                    tccModelo.setDataFim(data.toLocalDate());
                    tccModelo.setIdCurso(resposta.getInt("id_Curso"));
                    tccModelo.setIdProfessor(resposta.getInt("id_professor"));
                    tccModelo.setIdGrupoTCC(resposta.getInt("id_grupoTCC"));


                    listTCC.add(tccModelo);
                }
            }
            catch (SQLException e){
                System.out.println("Erro na consulta1:" + e.getMessage());
            }
            return listTCC;
        }

    public List<TCCModelo> buscarTCCProfessorOrinetador (ProfessorModelo professorModelo) throws SQLException{

        ResultSet resposta = null;
        TCCModelo tccModelo = new TCCModelo();
        List<TCCModelo> listTCC = new ArrayList<TCCModelo>();

        try {
            preparedStatement = connection.prepareStatement("select * from tcc where id_professor =  ?");
            preparedStatement.setInt(1, professorModelo.getId() );
            resposta = preparedStatement.executeQuery();

            while (resposta.next()) {

                tccModelo.setId(resposta.getInt("id"));
                tccModelo.setTipoTCC(resposta.getString("tipo_tcc"));
                tccModelo.setTitulo(resposta.getString("titulo"));
                Date data = resposta.getDate("data_inicio");
                tccModelo.setDataInicio(data.toLocalDate());
                data = resposta.getDate("data_fim");
                tccModelo.setDataFim(data.toLocalDate());
                tccModelo.setIdCurso(resposta.getInt("id_Curso"));
                tccModelo.setIdProfessor(resposta.getInt("id_professor"));
                tccModelo.setIdGrupoTCC(resposta.getInt("id_grupoTCC"));
                listTCC.add(tccModelo);
            }
        }catch (SQLException e){
            System.out.println("Erro na consulta1:" + e.getMessage());
        }
        return listTCC ;
    }
}
