package main;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Implementa el submenu de Equipos donde se muestra los apartados de Partidos, Jugadores y Estadio.
 * Esta clase en especifico se implementa solo los paneles superior e inferior, ya que el central
 * se delega en la clases {@code GUI_EquiposPartido GUI_EquiposJugadores GUI_EquiposEstadio}.
 * Se hace asi ya que la unica parte que varia entre esas tres es la central.
 */
public class GUI_Equipos extends JFrame {

    private JFrame frameEquipos;

    JPanel panelContenedor;

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

    private Equipo eq;

    //TODO Se deberia crear mas funciones para cambiar la lista de partidos

    public GUI_Equipos(Equipo eq){

        this.eq = eq;
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

        panelContenedor = new JPanel(new GridLayout(3, 1));
        frameEquipos = new JFrame("TodoFútbol");

        panelContenedor.add(frameSuperior);
        panelContenedor.add(frameCentral);
        panelContenedor.add(frameInferior);

        frameEquipos.getContentPane().add(panelContenedor);

        frameEquipos.setVisible(true);
        frameEquipos.setMinimumSize(new Dimension(400,400));
        frameEquipos.pack();
        frameEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
     Metodo para cambiar la frame central por alguna de las de GUI_EquiposEstadio, GUI_EquiposJugadores, o
     GUI_EquiposPartido. En el metodo lo que he hecho es quitar el panel de en medio y el de abajo para poner el panel
     nuevo en medio y poner el panel de abajo sin cambiar otra vez. Si no se quita el panel de abajo antes de añadir el
     de en medio, el panel nuevo se añade abajo, y el que estaba abajo se va al medio.
    */
    public void cambiarFrameCentral (JPanel nuevaFrameCentral) {
        panelContenedor.remove(frameCentral);
        panelContenedor.remove(frameInferior);
        frameCentral = nuevaFrameCentral;
        panelContenedor.add(frameCentral);
        panelContenedor.add(frameInferior);
    }

    // Controlador de la clase, maneja tambien los botones de la barra inferior
    public void ControladorEquipos(ActionListener ctr) {
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
        //boton partidos del menu de equipos
        botonPartidoEquipo.addActionListener(ctr);
        botonPartidoEquipo.setActionCommand("PARTIDOS_EQ");
        //boton jugadores del menu de equipos
        botonJugadores.addActionListener(ctr);
        botonJugadores.setActionCommand("JUGADORES");
        //boton estadio del menu de equipos
        botonEstadio.addActionListener(ctr);
        botonEstadio.setActionCommand("ESTADIO");
        //boton retroceder
        botonRetroceder.addActionListener(ctr);
        botonRetroceder.setActionCommand("BOTON EQUIPOS");
    }

    // Metodo que usa la clase ControladorEquipos, lo que hace es crear una ventana con la GUI de GUI_Equipos, pero le
    // añade al panel de en medio el contenido de GUI_EquiposJugadores
    // TODO: Cambiar la clase GUI_EquiposJugadores para que reciba como parametro un Equipo y lo maneje

    public void LanzarJugadores(){
        GUI_Equipos gui = new GUI_Equipos(eq);
        ControladorEquipos ctr = new ControladorEquipos(gui);
        gui.ControladorEquipos(ctr);
        gui.cambiarFrameCentral(new GUI_EquiposJugadores(null));
        gui.setVisible(true);
        frameEquipos.dispose();
        dispose();
        System.out.println("Se ha pulsado el boton Jugadores");
    }

    // Metodo que usa la clase ControladorEquipos, lo que hace es crear una ventana con la GUI de GUI_Equipos, pero le
    // añade al panel de en medio el contenido de GUI_EquiposPartido pasandole un parametro null
    // TODO: Cambiar la clase GUI_EquiposPartido para que reciba como parametro un Equipo y lo maneje
    public void LanzarPartidos_Eq(){
        GUI_Equipos gui = new GUI_Equipos(eq);
        ControladorEquipos ctr = new ControladorEquipos(gui);
        gui.ControladorEquipos(ctr);
        gui.cambiarFrameCentral(new GUI_EquiposPartido(null));
        gui.setVisible(true);
        frameEquipos.dispose();
        dispose();
        System.out.println("Se ha pulsado el boton Partido_Equipos");

    }

    // Metodo que usa la clase ControladorEquipos, lo que hace es crear una ventana con la GUI de GUI_Equipos, pero le
    // añade al panel de en medio el contenido de GUI_EquiposEstadio
    // TODO: Cambiar la clase GUI_EquiposEstadio para que reciba como parametro un Equipo y lo maneje

    public void LanzarEstadio(){
        GUI_Equipos gui = new GUI_Equipos(eq);
        ControladorEquipos ctr = new ControladorEquipos(gui);
        gui.ControladorEquipos(ctr);
        gui.cambiarFrameCentral(new GUI_EquiposEstadio("https://es.wikipedia.org/wiki/Estadio_Santiago_Bernab%C3%A9u#/media/Archivo:Estadio_Santiago_Bernab%C3%A9u_(2016).jpg"));
        gui.setVisible(true);
        frameEquipos.dispose();
        dispose();
        System.out.println("Se ha pulsado el boton Estadio");
    }

    // Estos metodos son identicos a los de la clase GUI_Inicial y GUI_Partidos
    public void LanzarPartidos() {
        GUI_Partidos gui = new GUI_Partidos();
        Controlador ctr = new Controlador(gui);
        gui.controlador(ctr);
        gui.setVisible(true);
        frameEquipos.dispose();
        dispose();
        System.out.println("Se ha pulsado el boton partidos "
                + "Abrir GUI_partidos");
    }

    public void LanzarEquipos() {
        GUI_Inicial gui = new GUI_Inicial();
        Controlador ctr = new Controlador(gui);
        gui.controlador(ctr);
        gui.setVisible(true);
        frameEquipos.dispose();
        dispose();
        System.out.println("Se ha pulsado el boton equipos "
                + "Abrir GUI_equipos");
    }

    public void LanzarForos() {
        System.out.println("Se ha pulsado el boton foros "
                + "Abrir GUI_Foros");
    }
    public void LanzarPrensa() {
        System.out.println("Se ha pulsado el boton prensa "
                + "Abrir GUI_prensa");
    }

}
