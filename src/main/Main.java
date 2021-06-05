package main;

import Controladores.Controlador;
import Controladores.ControladorEquipos;
import Controladores.ControladorEstadisticas;
import GUI.*;
import main.ConexionBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    private static final ConexionBD BD = ConexionBD.getInstance();


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TodoFútbol");
        CardLayout layout = new CardLayout();
        frame.getContentPane().setLayout(layout);

        GUI_Inicial gui = new GUI_Inicial(frame);
        Controlador ctrInicial = new Controlador(gui);
        gui.controlador(ctrInicial);

        GUI_Partidos partidos = new GUI_Partidos(frame);
        Controlador ctrPartidos = new Controlador(partidos);
        partidos.controlador(ctrPartidos);

        GUI_Equipos equipos = new GUI_Equipos(null, frame, gui);
        ControladorEquipos ctrEquipos = new ControladorEquipos(equipos);
        equipos.ControladorEquipos(ctrEquipos);

        GUI_EstadisticasPartido estadisticasPartido = new GUI_EstadisticasPartido(1, frame, partidos);
        ControladorEstadisticas ctrEstadisticas = new ControladorEstadisticas(estadisticasPartido);
        estadisticasPartido.ControladorEstadisticas(ctrEstadisticas);

        frame.getContentPane().add(gui, "Inicial");
        frame.getContentPane().add(equipos, "Equipos");
        frame.getContentPane().add(partidos, "Partidos");
        frame.getContentPane().add(estadisticasPartido, "EstadisticasPartido");
        layout.show(frame.getContentPane(), "Inicial");


        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
