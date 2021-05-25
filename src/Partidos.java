import java.sql.Date;

public class Partidos {
    private int idPartido;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String colegiados;
    private Date fecha;

    public Partidos(int idPartido, Equipo equipoLocal, Equipo equipoVisitante, String colegiados, Date fecha) {
        this.idPartido = idPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.colegiados = colegiados;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
