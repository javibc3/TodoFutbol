package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGuiInicial implements ActionListener {

    private GUI_Inicial panel;

    public ControladorGuiInicial (GUI_Inicial panel) {
        this.panel = panel;
    }

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
        }
    }
}
