package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Equipo {
    private int id;
    private String nombre;
    private String escudo;
    private int puntos;
    private final ConexionBD baseDatos = ConexionBD.getInstance();
    private HashMap<String, List<Jugador>> jugadores;

    public Equipo(int id, String nom, String Esc, int pun) {
        this.id = id;
        nombre = nom;
        escudo = Esc;
        puntos = pun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public HashMap<String, List<Jugador>> jugadores() {
        this.jugadores = this.ordenaJugadoresPosicion(this.baseDatos.getJugadoresDeEquipo(this.id));
        return this.jugadores;
    }

    public HashMap<String, List<Jugador>> ordenaJugadoresPosicion(List<Jugador> jugadores) {
        HashMap<String, List<Jugador>> mapa = new HashMap<>();
        List<Jugador> POR = new ArrayList<>();
        List<Jugador> DEF = new ArrayList<>();
        List<Jugador> CEN = new ArrayList<>();
        List<Jugador> DEL = new ArrayList<>();

        for (int i = 0; i < jugadores.size(); ++i) {

            switch (jugadores.get(i).getPosicion()) {
                case "POR": POR.add(jugadores.get(i));break;
                case "DEF": DEF.add(jugadores.get(i));break;
                case "CEN": CEN.add(jugadores.get(i));break;
                case "DEL": DEL.add(jugadores.get(i));break;
            }
        }

        POR = this.ordenaJugadoresDorsal(POR);
        DEF = this.ordenaJugadoresDorsal(DEF);
        CEN = this.ordenaJugadoresDorsal(CEN);
        DEL = this.ordenaJugadoresDorsal(DEL);

        try {
            mapa.put("POR", POR);
            mapa.put("DEF", DEF);
            mapa.put("CEN", CEN);
            mapa.put("DEL", DEL);
        } catch (NullPointerException var10) {
            var10.printStackTrace();
        }

        return mapa;
    }

    public List<Jugador> ordenaJugadoresDorsal(List<Jugador> jugadores) {
        List<Jugador> listaOrdenada = new ArrayList<>();
        Jugador jug = new Jugador(0, null, null, null, 0, 0, 0);
        int idx = -1, menor, size = jugadores.size();

        for (int i = 0; i < size; ++i) {
            menor = 100;
            for (int j = 0; j < jugadores.size(); ++j) {
                if ((jugadores.get(j)).getDorsal() < menor) {
                    menor = (jugadores.get(j)).getDorsal();
                    jug = jugadores.get(j);
                    idx = j;
                }
            }
            listaOrdenada.add(jug);
            jugadores.remove(idx);
        }

        return listaOrdenada;
    }

/* toString de prueba para la clase test.PruebaConexionBD
    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", escudo='" + escudo + '\'' +
                '}';
    }
 */
}
