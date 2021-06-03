package Controladores;

import GUI.GUI_EstadisticasPartido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEstadisticas implements ActionListener{

    private final GUI_EstadisticasPartido EstadisticasPPal;

    public ControladorEstadisticas(GUI_EstadisticasPartido est) {
            this.EstadisticasPPal = est;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "BOTON PARTIDOS": EstadisticasPPal.LanzarPartidos();break;
            case "BOTON EQUIPOS": EstadisticasPPal.LanzarEquipos();break;
            case "BOTON PRENSA": EstadisticasPPal.LanzarPrensa();break;
            case "BOTON FOROS": EstadisticasPPal.LanzarForos();break;
        }
    }
}
