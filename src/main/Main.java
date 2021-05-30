package main;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
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

        GUI_Equipos equipos = new GUI_Equipos(null,frame);
        ControladorEquipos ctrEquipos = new ControladorEquipos(equipos);
        equipos.ControladorEquipos(ctrEquipos);


        frame.getContentPane().add(gui,"Inicial");
        frame.getContentPane().add(equipos,"Equipos");
        frame.getContentPane().add(partidos,"Partidos");
        layout.show(frame.getContentPane(),"Inicial");


        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800,600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
