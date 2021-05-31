package Controladores;

import GUI.GUI_Inicial;
import GUI.GUI_Partidos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private GUI_Inicial panel;
    private GUI_Partidos par;

    public Controlador(GUI_Inicial ppal) {
        this.panel = ppal;
    }

    public Controlador(GUI_Partidos par) {
        this.par = par;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "BOTON PARTIDOS" -> panel.LanzarPartidos();
            case "BOTON EQUIPOS" -> panel.LanzarEquipos();
            case "BOTON PRENSA" -> panel.LanzarPrensa();
            case "BOTON FOROS" -> panel.LanzarForos();
            case "BOTON PAR:EQUIPOS" -> par.LanzarEquipos();
            case "BOTON PAR:PRENSA" -> par.LanzarPrensa();
            case "BOTON PAR:FOROS" -> par.LanzarForos();
            case "BOTON PAR:PARTIDOS" -> par.LanzarPartidos();
            case "EQUIPOS1" -> panel.LanzarEquipos1_6(1);
            case "EQUIPOS2" -> panel.LanzarEquipos1_6(2);
            case "EQUIPOS3" -> panel.LanzarEquipos1_6(3);
            case "EQUIPOS4" -> panel.LanzarEquipos1_6(4);
            case "EQUIPOS5" -> panel.LanzarEquipos1_6(5);
            case "EQUIPOS6" -> panel.LanzarEquipos1_6(6);
        }
    }
}
