package Negocio;

import Dao.CursoDAO;
import Modelo.CursoModelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rdsdo on 14/05/2017.
 */
public class CursoNegocio {
    CursoDAO cursoDAO = new CursoDAO();
    List<CursoModelo> listCurso = new ArrayList<CursoModelo>();
    public void salvarCurso (CursoModelo cursoModelo) throws SQLException {
        if(!cursoModelo.getCurso().equals("")){
            cursoDAO.salvar(cursoModelo);
        }else{
            System.out.println("Preencha curso"); // ADICIONAR MENSSAGEM
        }
    }

    public List<CursoModelo> buscarCurso () throws SQLException {
        listCurso = cursoDAO.buscar();
        return listCurso;
    }


}
