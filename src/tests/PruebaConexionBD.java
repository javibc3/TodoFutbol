package tests;

import main.Equipo;
import main.Partidos;

import java.util.Arrays;
import java.util.List;

public class PruebaConexionBD {

    public static void main(String[] args) {
        main.ConexionBD BD = main.ConexionBD.getInstance();
        List<Equipo> equipo = BD.getEquipos();
        List<Partidos> partidos = BD.getPartidos();
        System.out.println(Arrays.toString(equipo.toArray()));
        System.out.println(Arrays.toString(partidos.toArray()));
    }
}
