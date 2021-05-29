package main;

import main.GUI_Inicial;
import main.GUI_Partidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEquipos implements ActionListener {

    private GUI_Inicial panel;
    private GUI_Equipos EquiposPPal;

    public ControladorEquipos(GUI_Equipos equ) { this.EquiposPPal = equ;}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("JUGADORES")) {
            EquiposPPal.LanzarJugadores();
        } else if (e.getActionCommand().equals("ESTADIO")) {
            EquiposPPal.LanzarEstadio();
        } else if (e.getActionCommand().equals("PARTIDOS_EQ")) {
            EquiposPPal.LanzarPartidos_Eq();
        } else if (e.getActionCommand().equals("BOTON PARTIDOS")) {
            EquiposPPal.LanzarPartidos();
        } else if (e.getActionCommand().equals("BOTON EQUIPOS")) {
            EquiposPPal.LanzarEquipos();
        } else if (e.getActionCommand().equals("BOTON PRENSA")) {
            EquiposPPal.LanzarPrensa();
        } else if (e.getActionCommand().equals("BOTON FOROS")) {
            EquiposPPal.LanzarForos();
        }
    }
}