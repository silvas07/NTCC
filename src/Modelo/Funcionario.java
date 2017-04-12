package Modelo;

/**
 * Created by rdsdo on 12/04/2017.
 */
public class Funcionario extends Pessoa{
    private String login;
    private String sena;
    private int iD;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSena() {
        return sena;
    }

    public void setSena(String sena) {
        this.sena = sena;
    }
}
