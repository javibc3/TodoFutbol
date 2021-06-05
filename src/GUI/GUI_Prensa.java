package GUI;

import main.ConexionBD;
import main.Equipo;
import main.Partidos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class GUI_Prensa extends JPanel {

    JPanel panelContenedor;
    private final JFrame framePrincipal;
    private final JPanel panelArriba;
    private final JPanel subpanelTitulo;
    private final JPanel subpanelEnBlanco1;

    private final JPanel panelParYClas;

    private final JPanel panelAbajo;
    private final JPanel subpanelEnBlanco2;
    private final JPanel subpanelMenu;


    private final JLabel labelTitulo;
    private final JButton botonEquipos;
    private final JButton botonPartidos;
    private final JButton botonForos;
    private final JButton botonPrensa;

    private final JButton botonMarca;
    private final JButton botonAS;
    private final JButton botonMD;


    public GUI_Prensa(JFrame frame) {
        framePrincipal = frame;

        panelContenedor = new JPanel(new GridLayout(3, 2));
        panelArriba = new JPanel(new GridLayout(2, 1));
        subpanelTitulo = new JPanel(new GridLayout(1, 1));
        subpanelEnBlanco1 = new JPanel(new GridLayout(1, 1));
        panelParYClas = new JPanel(new GridLayout(1, 2));
        panelAbajo = new JPanel(new GridLayout(2, 1));
        subpanelEnBlanco2 = new JPanel(new GridLayout(1, 1));
        subpanelMenu = new JPanel(new GridLayout(1, 4));


        labelTitulo = new JLabel("TodoFútbol");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
        labelTitulo.setFont(new Font("Serif", Font.PLAIN, 50));

        subpanelTitulo.add(labelTitulo);


        botonEquipos = new JButton("Equipos");
        /*
        botonEquipos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                GUI_Inicial inicial = new GUI_Inicial();
                inicial.setVisible(true);
                framePartidos.dispose();
            }
        });
         */
        botonPartidos = new JButton("Partidos");
        botonForos = new JButton("Foros");
        botonPrensa = new JButton("Prensa");

        botonMarca = new JButton("Marca");
        botonAS = new JButton("AS");
        botonMD = new JButton("Mundo Deportivo");

        subpanelMenu.add(botonEquipos);
        subpanelMenu.add(botonPartidos);
        subpanelMenu.add(botonForos);
        subpanelMenu.add(botonPrensa);

        panelParYClas.add(botonMarca);
        panelParYClas.add(botonAS);
        panelParYClas.add(botonMD);

        panelArriba.add(subpanelTitulo);
        panelArriba.add(subpanelEnBlanco1);


        panelAbajo.add(subpanelEnBlanco2);
        panelAbajo.add(subpanelMenu);

        panelContenedor.add(panelArriba);
        panelContenedor.add(panelParYClas);
        panelContenedor.add(panelAbajo);

        //framePartidos.getContentPane()
        add(panelContenedor);

        setVisible(true);
        setMinimumSize(new Dimension(400, 400));
        //framePartidos.pack();
        //framePartidos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void openWebpage(String urlstring) {
        try {
            Desktop.getDesktop().browse(new URL(urlstring).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        botonAS.addActionListener(ctr);
        botonAS.setActionCommand("BOTON AS");

        botonMarca.addActionListener(ctr);
        botonMarca.setActionCommand("BOTON MARCA");

        botonMD.addActionListener(ctr);
        botonMD.setActionCommand("BOTON MD");
    }

    public void LanzarPartidos() {
        CardLayout layout = (CardLayout) framePrincipal.getContentPane().getLayout();
        layout.show(framePrincipal.getContentPane(), "Partidos");

        System.out.println("Se ha pulsado el boton Partidos "
                + "Abrir GUI_Partidos");
    }

    public void LanzarEquipos() {


        CardLayout layout = (CardLayout) framePrincipal.getContentPane().getLayout();
        layout.show(framePrincipal.getContentPane(), "Inicial");

        System.out.println("Se ha pulsado el boton Equipos "
                + "Abrir GUI_Inicial");
    }

    public void LanzarForos() {
        System.out.println("Se ha pulsado el boton Foros "
                + "Abrir GUI_Foros");
    }

    public void LanzarPrensa() {
        System.out.println("Se ha pulsado el boton Prensa "
                + "Abrir GUI_Prensa");
    }
}
