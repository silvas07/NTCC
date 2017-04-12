package Modelo;

/**
 * Created by rdsdo on 12/04/2017.
 */
public class Professor extends Pessoa {
    private String titulaçao;
    private int iD;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getTitulaçao() {
        return titulaçao;
    }

    public void setTitulaçao(String titulaçao) {
        this.titulaçao = titulaçao;
    }
}
