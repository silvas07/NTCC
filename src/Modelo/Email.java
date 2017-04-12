package Modelo;

/**
 * Created by rdsdo on 12/04/2017.
 */
public class Email {
    private String nome;
    private String email;
    private String tipoDeEmail;
    private int iD;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoDeEmail() {
        return tipoDeEmail;
    }

    public void setTipoDeEmail(String tipoDeEmail) {
        this.tipoDeEmail = tipoDeEmail;
    }
}
