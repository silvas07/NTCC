package Modelo;

/**
 * Created by rdsdo on 12/04/2017.
 */
public class Telefone {
    private String dDD;
    private String telefone;
    private int iD;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getdDD() {
        return dDD;
    }

    public void setdDD(String dDD) {
        this.dDD = dDD;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
