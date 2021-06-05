package Controladores;

import GUI.GUI_Inicial;
import GUI.GUI_Partidos;
import GUI.GUI_Prensa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private GUI_Inicial panel;
    private GUI_Partidos par;
    private GUI_Prensa pre;

    public Controlador(GUI_Inicial ppal) {
        this.panel = ppal;
    }

    public Controlador(GUI_Partidos par) {
        this.par = par;
    }

    public Controlador(GUI_Prensa pre){ this.pre = pre;}

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "BOTON PARTIDOS": panel.LanzarPartidos(); break;
            case "BOTON EQUIPOS": panel.LanzarEquipos();break;
            case "BOTON PRENSA": panel.LanzarPrensa();break;
            case "BOTON FOROS": panel.LanzarForos();break;
            case "BOTON PAR:EQUIPOS": par.LanzarEquipos();break;
            case "BOTON PAR:PRENSA": par.LanzarPrensa();break;
            case "BOTON PAR:FOROS":  par.LanzarForos();break;
            case "BOTON PAR:PARTIDOS": par.LanzarPartidos();break;
            case "EQUIPOS1": panel.LanzarEquipos1_6(1);break;
            case "EQUIPOS2": panel.LanzarEquipos1_6(2);break;
            case "EQUIPOS3": panel.LanzarEquipos1_6(3);break;
            case "EQUIPOS4": panel.LanzarEquipos1_6(4);break;
            case "EQUIPOS5": panel.LanzarEquipos1_6(5);break;
            case "EQUIPOS6": panel.LanzarEquipos1_6(6);break;
        }
    }
}
