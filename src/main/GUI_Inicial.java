package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class GUI_Inicial {

    private JFrame framePrincipal;

    JPanel panelContenedor;

    private JPanel panelArriba;
    private JPanel subpanelTitulo;
    private JPanel subpanelEnBlanco1;

    private JPanel panelBotones;

    private JPanel panelAbajo;
    private JPanel subpanelEnBlanco2;
    private JPanel subpanelMenu;


    private JLabel labelTitulo;

    private JButton botonEq1;
    private JButton botonEq2;
    private JButton botonEq3;
    private JButton botonEq4;
    private JButton botonEq5;
    private JButton botonEq6;
    private JButton botonEquipos;
    private JButton botonPartidos;
    private JButton botonForos;
    private JButton botonPrensa;

    public GUI_Inicial(){
        framePrincipal = new JFrame("TodoFútbol");

        panelContenedor = new JPanel(new GridLayout(3, 1));
        panelArriba = new JPanel(new GridLayout(2, 1));
        subpanelTitulo = new JPanel(new GridLayout(1, 1));
        subpanelEnBlanco1 = new JPanel(new GridLayout(1, 1));
        panelBotones = new JPanel(new GridLayout(2, 3));
        panelAbajo = new JPanel(new GridLayout(2, 1));
        subpanelEnBlanco2 = new JPanel(new GridLayout(1, 1));
        subpanelMenu = new JPanel(new GridLayout(1, 4));



        labelTitulo = new JLabel("TodoFútbol");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
        labelTitulo.setFont(new Font("Serif", Font.PLAIN, 50));

        subpanelTitulo.add(labelTitulo);

        botonEq1 = new JButton("Equipo 1");
        botonEq2 = new JButton("Equipo 2");
        botonEq3 = new JButton("Equipo 3");
        botonEq4 = new JButton("Equipo 4");
        botonEq5 = new JButton("Equipo 5");
        botonEq6 = new JButton("Equipo 6");



        botonEquipos = new JButton("Equipos");
        botonPartidos = new JButton("Partidos");
        botonForos = new JButton("Foros");
        botonPrensa = new JButton("Prensa");

        panelBotones.add(botonEq1);
        panelBotones.add(botonEq2);
        panelBotones.add(botonEq3);
        panelBotones.add(botonEq4);
        panelBotones.add(botonEq5);
        panelBotones.add(botonEq6);

        subpanelMenu.add(botonEquipos);
        subpanelMenu.add(botonPartidos);
        subpanelMenu.add(botonForos);
        subpanelMenu.add(botonPrensa);

        panelArriba.add(subpanelTitulo);
        panelArriba.add(subpanelEnBlanco1);

        panelAbajo.add(subpanelEnBlanco2);
        panelAbajo.add(subpanelMenu);

        panelContenedor.add(panelArriba);
        panelContenedor.add(panelBotones);
        panelContenedor.add(panelAbajo);



        framePrincipal.getContentPane().add(panelContenedor);



        framePrincipal.setVisible(true);
        framePrincipal.setMinimumSize(new Dimension(400,400));
        framePrincipal.pack();
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        framePrincipal.setVisible(true);
        framePrincipal.setMinimumSize(new Dimension(400,400));
        framePrincipal.pack();
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
