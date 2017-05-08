package Modelo;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class AlunoModelo extends PessoaModelo {
    private int id;
    private String Matricula;
    private String curso;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
