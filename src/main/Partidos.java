package main;

import java.sql.Date;

public class Partidos {
    private int idPartido;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String colegiados;
    private String fecha;
    private String resultado;

    public Partidos(int idPartido, Equipo equipoLocal, Equipo equipoVisitante, String colegiados, String fecha, String resultado) {
        this.idPartido = idPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.colegiados = colegiados;
        this.fecha = fecha;
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getColegiados() {
        return colegiados;
    }

    public void setColegiados(String colegiados) {
        this.colegiados = colegiados;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Partidos{" +
                "idPartido=" + idPartido +
                ", equipoLocal=" + equipoLocal +
                ", equipoVisitante=" + equipoVisitante +
                ", colegiados='" + colegiados + '\'' +
                ", fecha=" + fecha +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
