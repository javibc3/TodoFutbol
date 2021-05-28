package main;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.StringJoiner;

public class Pichichi {
    private String nombre;
    private int numGoles;
    private SortedMap<String, Integer> goleadores;
    private ConexionBD baseDatos = ConexionBD.getInstance();

    public Pichichi() {
        goleadores = baseDatos.getGoleadores();
    }

    public int getNumGoles() {
        return numGoles;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int num;
        sb.append("Maximos Goleadores:\n");
        for(String nombre: goleadores.keySet()) {
            num = goleadores.get(nombre);
            sb.append("Jugador: " + nombre + ", Numero de goles: " + num + "\n");
        }
        return sb.toString();
        //return super.toString();
    }


}
