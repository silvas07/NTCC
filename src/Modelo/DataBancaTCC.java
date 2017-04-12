package Modelo;

import java.util.Date;

/**
 * Created by rdsdo on 12/04/2017.
 */
public class DataBancaTCC {
    private Date dataDeInico;
    private Date dataDeFim;
    private Date horaDeico;
    private Date hotaDeFim;
    private int iD;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Date getDataDeInico() {
        return dataDeInico;
    }

    public void setDataDeInico(Date dataDeInico) {
        this.dataDeInico = dataDeInico;
    }

    public Date getDataDeFim() {
        return dataDeFim;
    }

    public void setDataDeFim(Date dataDeFim) {
        this.dataDeFim = dataDeFim;
    }

    public Date getHoraDeico() {
        return horaDeico;
    }

    public void setHoraDeico(Date horaDeico) {
        this.horaDeico = horaDeico;
    }

    public Date getHotaDeFim() {
        return hotaDeFim;
    }

    public void setHotaDeFim(Date hotaDeFim) {
        this.hotaDeFim = hotaDeFim;
    }
}
