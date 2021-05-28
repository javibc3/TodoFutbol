package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI_Partidos extends  JFrame{

    private JFrame framePartidos;

    JPanel panelContenedor;

    private JPanel panelArriba;
    private JPanel subpanelTitulo;
    private JPanel subpanelEnBlanco1;

    private JPanel panelBotones;

    private JPanel panelAbajo;
    private JPanel subpanelEnBlanco2;
    private JPanel subpanelMenu;


    private JLabel labelTitulo;
    private JButton botonEquipos;
    private JButton botonPartidos;
    private JButton botonForos;
    private JButton botonPrensa;
    private JLabel lblClasificacion;
    private JLabel lblPartidos_1;

    public GUI_Partidos(){
        framePartidos = new JFrame("TodoFútbol");

        panelContenedor = new JPanel(new GridLayout(3, 1));
        panelArriba = new JPanel(new GridLayout(2, 1));
        subpanelTitulo = new JPanel(new GridLayout(1, 1));
        subpanelEnBlanco1 = new JPanel(new GridLayout(1, 1));
        panelBotones = new JPanel(new GridLayout(2, 3));
        panelAbajo = new JPanel(new GridLayout(2, 1));
        subpanelEnBlanco2 = new JPanel(new GridLayout(1, 1));
        subpanelMenu = new JPanel(new GridLayout(1, 4));



        labelTitulo = new JLabel("TodoFÃºtbol");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
        labelTitulo.setFont(new Font("Serif", Font.PLAIN, 50));

        subpanelTitulo.add(labelTitulo);



        botonEquipos = new JButton("Equipos");
        botonEquipos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                GUI_Inicial inicial = new GUI_Inicial();
                inicial.setVisible(true);
                framePartidos.dispose();
            }
        });
        botonPartidos = new JButton("Partidos");
        botonForos = new JButton("Foros");
        botonPrensa = new JButton("Prensa");

        subpanelMenu.add(botonEquipos);
        subpanelMenu.add(botonPartidos);
        subpanelMenu.add(botonForos);
        subpanelMenu.add(botonPrensa);

        panelArriba.add(subpanelTitulo);
        panelArriba.add(subpanelEnBlanco1);

        lblPartidos_1 = new JLabel("Partidos");
        subpanelEnBlanco1.add(lblPartidos_1);

        lblClasificacion = new JLabel("Clasificaci\u00F3n");
        subpanelEnBlanco1.add(lblClasificacion);

        panelAbajo.add(subpanelEnBlanco2);
        panelAbajo.add(subpanelMenu);

        panelContenedor.add(panelArriba);
        panelContenedor.add(panelBotones);
        panelContenedor.add(panelAbajo);



        framePartidos.getContentPane().add(panelContenedor);



        framePartidos.setVisible(true);
        framePartidos.setMinimumSize(new Dimension(400,400));
        framePartidos.pack();
        framePartidos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}