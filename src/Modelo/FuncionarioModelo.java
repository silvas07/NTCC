package Modelo;

/**
 * Created by rdsdo on 01/05/2017.
 */
public class FuncionarioModelo extends PessoaModelo {
    private int id;
    private String login;
    private String senha;
    private String segundaSenha;
    private String Matricula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSegundaSenha() {
        return segundaSenha;
    }

    public void setSegundaSenha(String segundaSenha) {
        this.segundaSenha = segundaSenha;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }
}
