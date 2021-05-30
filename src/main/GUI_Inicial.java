package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class GUI_Inicial extends  JPanel{

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

    ConexionBD BD;
    List<Equipo> listaEquipos;


    public GUI_Inicial(JFrame frame){
        // Establecemos una conexión con la BD y obtenemos una lista con los equipos para poder rellenar los botones con los nombres
        BD = ConexionBD.getInstance();
        listaEquipos = BD.getEquipos();

        framePrincipal = frame;

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

        /*
        botonEq1 = new JButton("Equipo 1");
        botonEq2 = new JButton("Equipo 2");
        botonEq3 = new JButton("Equipo 3");
        botonEq4 = new JButton("Equipo 4");
        botonEq5 = new JButton("Equipo 5");
        botonEq6 = new JButton("Equipo 6");
        */

        // Los botones ya muestran los nombres de los equipos que tenemos en al BD
        botonEq1 = new JButton(listaEquipos.get(0).getNombre());
        botonEq2 = new JButton(listaEquipos.get(1).getNombre());
        botonEq3 = new JButton(listaEquipos.get(2).getNombre());
        botonEq4 = new JButton(listaEquipos.get(3).getNombre());
        botonEq5 = new JButton(listaEquipos.get(4).getNombre());
        botonEq6 = new JButton(listaEquipos.get(5).getNombre());


        botonEquipos = new JButton("Equipos");
        botonPartidos = new JButton("Partidos");
        /*Estoy probando el controlador
        botonPartidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                GUI_Partidos gui_Partidos = new GUI_Partidos();
                gui_Partidos.setVisible(true);
                framePrincipal.dispose();
            }
        });
         */
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



        //framePrincipal.getContentPane().
        add(panelContenedor);



        setVisible(true);
        setMinimumSize(new Dimension(400,400));
        //framePrincipal.pack();
        //framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void controlador(ActionListener ctr) {
        //boton partidos
        botonPartidos.addActionListener(ctr);
        botonPartidos.setActionCommand("BOTON PARTIDOS");
        //boton equipos
        botonEquipos.addActionListener(ctr);
        botonEquipos.setActionCommand("BOTON EQUIPOS");
        //boton Foros
        botonForos.addActionListener(ctr);
        botonForos.setActionCommand("BOTON FOROS");
        //boton prensa--goleadores
        botonPrensa.addActionListener(ctr);
        botonPrensa.setActionCommand("BOTON PRENSA");
        //boton equipo1
        botonEq1.addActionListener(ctr);
        botonEq1.setActionCommand("EQUIPOS1");
        //boton equipo2
        botonEq2.addActionListener(ctr);
        botonEq2.setActionCommand("EQUIPOS2");
        //boton equipo3
        botonEq3.addActionListener(ctr);
        botonEq3.setActionCommand("EQUIPOS3");
        //boton equipo4
        botonEq4.addActionListener(ctr);
        botonEq4.setActionCommand("EQUIPOS4");
        //boton equipo5
        botonEq5.addActionListener(ctr);
        botonEq5.setActionCommand("EQUIPOS5");
        //boton equipo6
        botonEq6.addActionListener(ctr);
        botonEq6.setActionCommand("EQUIPOS6");
    }
    public void LanzarPartidos() {
        /*
        GUI_Partidos gui = new GUI_Partidos();
        Controlador ctr = new Controlador(gui);
        gui.controlador(ctr);
        removeAll();
        add(gui);
        //framePrincipal.dispose();
        //dispose();
         */

        CardLayout layout = (CardLayout) framePrincipal.getContentPane().getLayout();
        layout.show(framePrincipal.getContentPane(),"Partidos");

        System.out.println("Se ha pulsado el boton Partidos "
                + "Abrir GUI_Partidos");
    }
    public void LanzarEquipos() {
        System.out.println("Se ha pulsado el boton equipos ");
    }
    public void LanzarForos() {
        System.out.println("Se ha pulsado el boton Foros "
                + "Abrir GUI_Foros");
    }
    public void LanzarPrensa() {
        System.out.println("Se ha pulsado el boton Prensa "
                + "Abrir GUI_Prensa");
    }

    /*
     Funcion que lanza la clase Controlador, y lo que hace es crear una ventana con la GUI de GUI_Equipos, y por
     defecto se enseña la pestaña de Partidos. En comentarios esta la version que usa la BD para pasarle un equipo
     a la GUI, pero eso todavia hay que testearlo.
     */
    public void LanzarEquipos1_6(int n) {
        /*
        GUI_Equipos gui = new GUI_Equipos(listaEquipos.get(n-1));

        // Si se descomenta la parte anterior, hay que borrar la siguiente linea
        //GUI_Equipos gui = new GUI_Equipos(null);
        ControladorEquipos ctr = new ControladorEquipos(gui);
        gui.ControladorEquipos(ctr);
        setVisible(false);
        remove(this);
        add(gui);
        setVisible(true);
        //gui.setVisible(true);
        //framePrincipal.dispose();
        //dispose();

         */

        CardLayout layout = (CardLayout) framePrincipal.getContentPane().getLayout();
        layout.show(framePrincipal.getContentPane(),"Equipos");

        System.out.println("Se ha pulsado el boton Equipos" + n + ". Abrir GUI_Equipos" + n);
    }
}