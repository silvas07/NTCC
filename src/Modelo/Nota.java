package Modelo;

/**
 * Created by rdsdo on 12/04/2017.
 */
public class Nota {
    private double forma;
    private  double processual;
    private int iD;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public double getForma() {
        return forma;
    }

    public void setForma(double forma) {
        this.forma = forma;
    }

    public double getProcessual() {
        return processual;
    }

    public void setProcessual(double processual) {
        this.processual = processual;
    }
}
