package Modelo;

import java.time.LocalDate;

/**
 * Created by rdsdo on 16/05/2017.
 */
public class TCCModelo {

    private int id;
    private String tipoTCC;
    private String titulo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int idCurso;
    private int idProfessor;
    private int id_grupoTCC;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoTCC() {
        return tipoTCC;
    }

    public void setTipoTCC(String tipoTCC) {
        this.tipoTCC = tipoTCC;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getId_grupoTCC() {
        return id_grupoTCC;
    }

    public void setId_grupoTCC(int id_grupoTCC) {
        this.id_grupoTCC = id_grupoTCC;
    }
}
