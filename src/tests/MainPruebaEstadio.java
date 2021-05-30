package tests;

import main.ConexionBD;
import main.Equipo;
import main.Estadio;

public class MainPruebaEstadio {
    public static void main (String []args) {
        ConexionBD baseDatos = ConexionBD.getInstance();
        Equipo equipo = baseDatos.getEquipoDeID(1);
        System.out.println("Equipo : " + equipo.getNombre());
        Estadio estadio = baseDatos.getEstadioDeEquipo(equipo);
        System.out.println("Estadio : " + estadio.getNombre());

    }
}
