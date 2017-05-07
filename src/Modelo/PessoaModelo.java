package Modelo;

/**
 * Created by rdsdo on 07/05/2017.
 */
public class PessoaModelo {
    int id;
    String nome;
    String sobrenome;
    String telefone;
    String email;
    String gernero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRelefone() {
        return telefone;
    }

    public void setRelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGernero() {
        return gernero;
    }

    public void setGernero(String gernero) {
        this.gernero = gernero;
    }
}
