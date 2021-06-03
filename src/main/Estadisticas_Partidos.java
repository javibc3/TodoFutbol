package main;

public class Estadisticas_Partidos {
    int idpar;
    int ideq;
    int posesion;
    int goles;
    int fueras_juego;
    int corners;
    int tarjetas_amarillas;
    int tarjetas_rojas;
    int tiros_totales;
    int tiros_puerta;
    int pases;
    int penaltis;
    int faltas;

    public Estadisticas_Partidos(int idpar, int ideq, int posesion, int goles, int fueras_juego, int corners, int tarjetas_amarillas, int tarjetas_rojas, int tiros_totales, int tiros_puerta, int pases, int penaltis, int faltas){
        this.idpar=idpar;
        this.ideq=ideq;
        this.posesion=posesion;
        this.goles=goles;
        this.fueras_juego=fueras_juego;
        this.corners=corners;
        this.tarjetas_amarillas=tarjetas_amarillas;
        this.tarjetas_rojas=tarjetas_rojas;
        this.tiros_totales=tiros_totales;
        this.tiros_puerta=tiros_puerta;
        this.pases=pases;
        this.penaltis=penaltis;
        this.faltas=faltas;
    }

    public int getIdpar() {
        return idpar;
    }

    public void setIdpar(int idpar) {
        this.idpar = idpar;
    }

    public int getIdeq() {
        return ideq;
    }

    public void setIdeq(int ideq) {
        this.ideq = ideq;
    }

    public int getPosesion() {
        return posesion;
    }

    public void setPosesion(int posesion) {
        this.posesion = posesion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getFueras_juego() {
        return fueras_juego;
    }

    public void setFueras_juego(int fueras_juego) {
        this.fueras_juego = fueras_juego;
    }

    public int getCorners() {
        return corners;
    }

    public void setCorners(int corners) {
        this.corners = corners;
    }

    public int getTarjetas_amarillas() {
        return tarjetas_amarillas;
    }

    public void setTarjetas_amarillas(int tarjetas_amarillas) {
        this.tarjetas_amarillas = tarjetas_amarillas;
    }

    public int getTarjetas_rojas() {
        return tarjetas_rojas;
    }

    public void setTarjetas_rojas(int tarjetas_rojas) {
        this.tarjetas_rojas = tarjetas_rojas;
    }

    public int getTiros_totales() {
        return tiros_totales;
    }

    public void setTiros_totales(int tiros_totales) {
        this.tiros_totales = tiros_totales;
    }

    public int getTiros_puerta() {
        return tiros_puerta;
    }

    public void setTiros_puerta(int tiros_puerta) {
        this.tiros_puerta = tiros_puerta;
    }

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getPenaltis() {
        return penaltis;
    }

    public void setPenaltis(int penaltis) {
        this.penaltis = penaltis;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
}
