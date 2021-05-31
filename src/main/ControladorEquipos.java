package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEquipos implements ActionListener {

    private GUI_Equipos EquiposPPal;

    public ControladorEquipos(GUI_Equipos equ) { this.EquiposPPal = equ;}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "JUGADORES" -> EquiposPPal.LanzarJugadores();
            case "ESTADIO" -> EquiposPPal.LanzarEstadio();
            case "PARTIDOS_EQ" -> EquiposPPal.LanzarPartidos_Eq();
            case "BOTON PARTIDOS" -> EquiposPPal.LanzarPartidos();
            case "BOTON EQUIPOS" -> EquiposPPal.LanzarEquipos();
            case "BOTON PRENSA" -> EquiposPPal.LanzarPrensa();
            case "BOTON FOROS" -> EquiposPPal.LanzarForos();
        }
    }
}