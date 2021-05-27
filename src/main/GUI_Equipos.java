package main;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Implementa el submenu de Equipos donde se muestra los apartados de Partidos, Jugadores y Estadio.
 * Esta clase en especifico se implementa solo los paneles superior e inferior, ya que el central
 * se delega en la clases {@code GUI_EquiposPartido GUI_EquiposJugadores GUI_EquiposEstadio}.
 * Se hace asi ya que la unica parte que varia entre esas tres es la central.
 */
public class GUI_Equipos extends JPanel {
    //JPanel intermedios
    private JPanel frameSuperior;
    private JPanel frameInferior;
    private JPanel frameCentral;

    //Botonoes de la parte superior
    private JButton botonRetroceder;
    private JButton botonPartidoEquipo;
    private JButton botonJugadores;
    private JButton botonEstadio;



    //Botones de la parte inferior
    private JButton botonEquipos;
    private JButton botonPartidos;
    private JButton botonForos;
    private JButton botonPrensa;

    //TODO Se deberia crear mas funciones para cambiar la lista de partidos

    public GUI_Equipos(List<String> partidos){

        setLayout(new GridLayout(3,1));
        setMinimumSize(new Dimension(800,600));
        setPreferredSize(new Dimension(Math.round((float).33*getWidth()),Math.round((float) .33*getHeight())));

        frameSuperior = new JPanel(new GridLayout(1,4));

        Icon iconoRetroceder = null;
        try {
            iconoRetroceder = new ImageIcon(new URL("https://image.freepik.com/iconos-gratis/flecha-atras-izquierda_318-74925.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        botonRetroceder = new JButton(iconoRetroceder);
        botonPartidoEquipo = new JButton("Partidos");
        botonJugadores = new JButton("Jugadores");
        botonEstadio = new JButton("Estadio");

        frameSuperior.add(botonRetroceder);
        frameSuperior.add(botonPartidoEquipo);
        frameSuperior.add(botonJugadores);
        frameSuperior.add(botonEstadio);

        frameCentral = new GUI_EquiposEstadio("https://imagesvc.timeincapp.com/v3/fan/image?url=https://therealchamps.com/wp-content/uploads/getty-images/2018/12/458769189.jpeg&c=sc&w=1600&h=1132");

        frameInferior = new JPanel(new GridLayout(1,4));

        botonEquipos = new JButton("Equipos");
        botonPartidos = new JButton("Partidos");
        botonForos = new JButton("Foros");
        botonPrensa = new JButton("Prensa");

        frameInferior.add(botonEquipos);
        frameInferior.add(botonPartidos);
        frameInferior.add(botonForos);
        frameInferior.add(botonPrensa);

        add(frameSuperior);
        add(frameCentral);
        add(frameInferior);

        setVisible(false);


    }

}
