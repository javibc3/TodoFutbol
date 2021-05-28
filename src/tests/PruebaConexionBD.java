package tests;

import main.Equipo;
import main.Jugador;

import java.util.Arrays;
import java.util.List;

public class PruebaConexionBD {

    public static void main(String[] args) {
        main.ConexionBD BD = main.ConexionBD.getInstance();
        List<Equipo> equipo = BD.getEquipos();
        List<Jugador> jugadores = BD.getJugadoresDeEquipo(1);

        System.out.println(Arrays.toString(equipo.toArray()));
        for(int i=0;i<jugadores.size();i++) {
            System.out.println(jugadores.get(i).getNombre() + " ");
        }
        System.out.println(jugadores);
        System.out.println("Prueba de conexion:");
    }
}
