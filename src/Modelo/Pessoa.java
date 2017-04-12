package Modelo;

import java.util.Date;

/**
 * Created by rdsdo on 12/04/2017.
 */
public class Pessoa {
    private String nome;
    private String genero;
    private Date DataDeNascimento;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataDeNascimento() {
        return DataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        DataDeNascimento = dataDeNascimento;
    }
}
