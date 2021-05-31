package Controladores;

import GUI.GUI_Equipos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEquipos implements ActionListener {

    private final GUI_Equipos EquiposPPal;

    public ControladorEquipos(GUI_Equipos equ) {
        this.EquiposPPal = equ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "JUGADORES": EquiposPPal.LanzarJugadores();break;
            case "ESTADIO": EquiposPPal.LanzarEstadio();break;
            case "PARTIDOS_EQ": EquiposPPal.LanzarPartidos_Eq();break;
            case "BOTON PARTIDOS": EquiposPPal.LanzarPartidos();break;
            case "BOTON EQUIPOS": EquiposPPal.LanzarEquipos();break;
            case "BOTON PRENSA": EquiposPPal.LanzarPrensa();break;
            case "BOTON FOROS": EquiposPPal.LanzarForos();break;
        }
    }
}