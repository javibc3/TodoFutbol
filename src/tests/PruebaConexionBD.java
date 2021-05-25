package tests;

import main.Equipo;

import java.util.Arrays;
import java.util.List;

public class PruebaConexionBD {

    public static void main(String[] args) {
        main.ConexionBD BD = main.ConexionBD.getInstance();
        List<Equipo> equipo = BD.getEquipos();
        System.out.println(Arrays.toString(equipo.toArray()));
    }
}
