package tests;

import main.Equipo;
import main.Jugador;

import java.util.HashMap;
import java.util.List;

public class MainPruebaOrdenaEquipos {
    public static void main(String[] args) {
        Equipo equipo = new Equipo(1, "FCB", null, 4);
        HashMap<String, List<Jugador>> jugadores = equipo.jugadores();
        List<Jugador> POR = jugadores.get("POR");
        List<Jugador> DEF = jugadores.get("DEF");
        List<Jugador> CEN = jugadores.get("CEN");
        List<Jugador> DEL = jugadores.get("DEL");
        for (int i = 0; i < POR.size(); i++) {
            System.out.println(POR.get(i).getNombre() + " ");
        }
        for (int i = 0; i < DEF.size(); i++) {
            System.out.println(DEF.get(i).getNombre() + " ");
        }
        for (int i = 0; i < CEN.size(); i++) {
            System.out.println(CEN.get(i).getNombre() + " ");
        }
        for (int i = 0; i < DEL.size(); i++) {
            System.out.println(DEL.get(i).getNombre() + " ");
        }

    }
}
