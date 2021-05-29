package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private GUI_Inicial panel;
    private GUI_Partidos par;

    public Controlador(GUI_Inicial ppal) { this.panel = ppal;}
    public Controlador(GUI_Partidos par) { this.par = par;}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("BOTON PARTIDOS")) {
            panel.LanzarPartidos();
        } else if (e.getActionCommand().equals("BOTON EQUIPOS")) {
            panel.LanzarEquipos();
        } else if (e.getActionCommand().equals("BOTON PRENSA")) {
        panel.LanzarPrensa();
        } else if (e.getActionCommand().equals("BOTON FOROS")) {
            panel.LanzarForos();
        } else if (e.getActionCommand().equals("BOTON PAR:EQUIPOS")) {
            par.LanzarEquipos();
        } else if (e.getActionCommand().equals("BOTON PAR:PRENSA")) {
            par.LanzarPrensa();
        } else if (e.getActionCommand().equals("BOTON PAR:FOROS")) {
            par.LanzarForos();
        } else if (e.getActionCommand().equals("BOTON PAR:PARTIDOS")) {
            par.LanzarPartidos();
        }
    }
}
