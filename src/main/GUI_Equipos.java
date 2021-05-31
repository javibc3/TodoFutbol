package main;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * Implementa el submenu de Equipos donde se muestra los apartados de Partidos, Jugadores y Estadio.
 * Esta clase en especifico se implementa solo los paneles superior e inferior, ya que el central
 * se delega en la clases {@code GUI_EquiposPartido GUI_EquiposJugadores GUI_EquiposEstadio}.
 * Se hace asi ya que la unica parte que varia entre esas tres es la central.
 */
public class GUI_Equipos extends JPanel {

    private JFrame framePrincipal;
    private ConexionBD baseDatos = ConexionBD.getInstance();


    JPanel panelContenedor;

    //JPanel intermedios
//    private JPanel frameSuperior;
//    private JPanel frameInferior;
//    private JPanel frameCentral;

    private JPanel panelArriba;
    private JPanel panelArriba2;
    private JPanel subpanelBotones;
    private JPanel subpanelEnBlanco1;

    private JPanel panelCentral;

    private JPanel panelAbajo;
    private JPanel subpanelEnBlanco2;
    private JPanel subpanelMenu;

    private JLabel textoBlanco;

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
    private GUI_Inicial gui;


    //TODO Se deberia crear mas funciones para cambiar la lista de partidos

    public GUI_Equipos(Equipo eq,JFrame frame, GUI_Inicial gui){

        this.eq = eq;
        this.gui = gui;

        setLayout(new GridLayout(1,2));

        panelArriba = new JPanel(new GridLayout(1,1));
        panelArriba2 = new JPanel(new GridLayout(2,1));
        subpanelBotones= new JPanel(new GridLayout(1, 4));
        panelAbajo = new JPanel(new GridLayout(2,1));
        subpanelEnBlanco1 = new JPanel(new GridLayout(1, 1));
        subpanelEnBlanco2 = new JPanel(new GridLayout(1, 1));
        panelContenedor = new JPanel(new GridLayout(4, 1));
        subpanelMenu= new JPanel(new GridLayout(1, 4));
        panelCentral = new GUI_EquiposPartido(null);

        Icon iconoRetroceder = null;

        iconoRetroceder = new ImageIcon("src/Imagenes/flecha_atras.jpg");

        botonRetroceder = new JButton(iconoRetroceder);
        botonPartidoEquipo = new JButton("Partidos");
        botonJugadores = new JButton("Jugadores");
        botonEstadio = new JButton("Estadio");

        textoBlanco = new JLabel("TodoFútbol");
        textoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
        textoBlanco.setVerticalAlignment(SwingConstants.BOTTOM);
        textoBlanco.setFont(new Font("Serif", Font.PLAIN, 50));

        subpanelEnBlanco1.add(textoBlanco);

        subpanelBotones.add(botonRetroceder);
        subpanelBotones.add(botonPartidoEquipo);
        subpanelBotones.add(botonJugadores);
        subpanelBotones.add(botonEstadio);

        /*
        main.ConexionBD BD = main.ConexionBD.getInstance();
        List<Partidos> partidos = BD.getPartidosDeEquipo(eq);
        frameCentral = new GUI_EquiposPartido(partidos);
        */
        //Si descomentas la parte anterior, quita la linea siguiente


        botonEquipos = new JButton("Equipos");
        botonPartidos = new JButton("Partidos");
        botonForos = new JButton("Foros");
        botonPrensa = new JButton("Prensa");


        subpanelMenu.add(botonEquipos);
        subpanelMenu.add(botonPartidos);
        subpanelMenu.add(botonForos);
        subpanelMenu.add(botonPrensa);


        framePrincipal = frame;

        panelArriba.add(subpanelEnBlanco1);
        panelArriba2.add(subpanelEnBlanco2);
        panelArriba2.add(subpanelBotones);

        //panelAbajo.add(subpanelEnBlanco1);
        panelAbajo.add(subpanelMenu);

        panelContenedor.add(panelArriba);
        panelContenedor.add(panelArriba2);
        panelContenedor.add(panelCentral);
        panelContenedor.add(panelAbajo);

        //frameEquipos.getContentPane().
        add(panelContenedor);

        setVisible(true);
        setMinimumSize(new Dimension(400,400));
        //frameEquipos.pack();
        //frameEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
     Metodo para cambiar la frame central por alguna de las de GUI_EquiposEstadio, GUI_EquiposJugadores, o
     GUI_EquiposPartido. En el metodo lo que he hecho es quitar el panel de en medio y el de abajo para poner el panel
     nuevo en medio y poner el panel de abajo sin cambiar otra vez. Si no se quita el panel de abajo antes de añadir el
     de en medio, el panel nuevo se añade abajo, y el que estaba abajo se va al medio.
    */
    public void cambiarFrameCentral (JPanel nuevaFrameCentral) {
        panelContenedor.remove(panelCentral);
        panelContenedor.remove(panelCentral);
        panelCentral = nuevaFrameCentral;
        panelContenedor.add(panelCentral);
        panelContenedor.add(panelAbajo);
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
    // TODO: Añadir metodos a la clase GUI_EquiposJugadores para que maneje una lista de jugadores

    public void LanzarJugadores(){
        /*
        GUI_Equipos gui = new GUI_Equipos(eq);
        ControladorEquipos ctr = new ControladorEquipos(gui);
        gui.ControladorEquipos(ctr);
        */
        eq = gui.getEquipo();
        HashMap<String, List<Jugador>> jugadores=eq.jugadores();
        panelCentral.setVisible(false);
        cambiarFrameCentral(new GUI_EquiposJugadores(jugadores));
        panelCentral.setVisible(true);
        /*
        frameEquipos.dispose();
        dispose();
        +/
         */
        System.out.println("Se ha pulsado el boton Jugadores");
    }

    // Metodo que usa la clase ControladorEquipos, lo que hace es crear una ventana con la GUI de GUI_Equipos, pero le
    // añade al panel de en medio el contenido de GUI_EquiposPartido pasandole un parametro null
    public void LanzarPartidos_Eq(){
        /*
        GUI_Equipos gui = new GUI_Equipos(eq);
        ControladorEquipos ctr = new ControladorEquipos(gui);
        gui.ControladorEquipos(ctr);
        */

        /*
        main.ConexionBD BasDat = main.ConexionBD.getInstance();
        List<Partidos> partidos = BasDat.getPartidosDeEquipo(eq);
        */

        //Si descomentas la parte anterior, cambia null por partidos en la siguiente linea
        eq = gui.getEquipo();
        List partidos = baseDatos.getPartidosDeEquipo(eq);

        panelCentral.setVisible(false);
        cambiarFrameCentral(new GUI_EquiposPartido(partidos));
        panelCentral.setVisible(true);
        /*
        frameEquipos.dispose();
        dispose();
        */
        System.out.println("Se ha pulsado el boton Partido_Equipos");

    }

    // Metodo que usa la clase ControladorEquipos, lo que hace es crear una ventana con la GUI de GUI_Equipos, pero le
    // añade al panel de en medio el contenido de GUI_EquiposEstadio

    public void LanzarEstadio(){
        /*
        GUI_Equipos gui = new GUI_Equipos(eq);
        ControladorEquipos ctr = new ControladorEquipos(gui);
        gui.ControladorEquipos(ctr);
        +/
         */

        /*
        main.ConexionBD BasDat = main.ConexionBD.getInstance();
        Estadio estadio = BasDat.getEstadioDeEquipo(eq);

         */


        //Si descomentas la parte anterior, cambia null por estadio en la siguiente linea

        eq = gui.getEquipo();
        Estadio estadio = baseDatos.getEstadioDeEquipo(eq);
        System.out.println("Estadio: " + estadio.getNombre());
        panelCentral.setVisible(false);
        cambiarFrameCentral(new GUI_EquiposEstadio("https://imagesvc.timeincapp.com/v3/fan/image?url=https://therealchamps.com/wp-content/uploads/getty-images/2018/12/458769189.jpeg&c=sc&w=1600&h=1132", estadio));
        panelCentral.setVisible(true);
        //frameEquipos.dispose();
        //dispose();
        System.out.println("Se ha pulsado el boton Estadio");

    }

    // Estos metodos son identicos a los de la clase GUI_Inicial y GUI_Partidos
    public void LanzarPartidos() {
        /*
        GUI_Partidos gui = new GUI_Partidos();
        Controlador ctr = new Controlador(gui);
        gui.controlador(ctr);
        gui.setVisible(true);
        //frameEquipos.dispose();
        //dispose();
         */

        CardLayout layout = (CardLayout) framePrincipal.getContentPane().getLayout();
        layout.show(framePrincipal.getContentPane(),"Partidos");
        System.out.println("Se ha pulsado el boton Partidos "
                + "Abrir GUI_Partidos");
    }

    public void LanzarEquipos() {
        /*
        GUI_Inicial gui = new GUI_Inicial();
        Controlador ctr = new Controlador(gui);
        gui.controlador(ctr);
        gui.setVisible(true);
        //frameEquipos.dispose();
        //dispose();
        */
        eq = gui.nullEquipo();
        cambiarFrameCentral(new GUI_EquiposPartido(null));
        CardLayout layout = (CardLayout) framePrincipal.getContentPane().getLayout();
        layout.show(framePrincipal.getContentPane(),"Inicial");

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
