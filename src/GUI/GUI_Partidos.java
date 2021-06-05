package GUI;

import main.ConexionBD;
import main.Equipo;
import main.Jugador;
import main.Partidos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;


public class GUI_Partidos extends JPanel {

    private final ConexionBD baseDatos = ConexionBD.getInstance();

    JPanel panelContenedor;

    private Partidos partido;
    private final JFrame framePrincipal;
    private final JPanel panelArriba;
    private final JPanel subpanelTitulo;
    private final JPanel subpanelEnBlanco1;

    private final JPanel panelParYClas;
    private final JPanel panelPartidos;
    private final JPanel panelClasificacion;

    private final JPanel panelAbajo;
    private final JPanel subpanelEnBlanco2;
    private final JPanel subpanelMenu;


    private final JLabel labelTitulo;
    private final JButton botonEquipos;
    private final JButton botonPartidos;
    private final JButton botonForos;
    private final JButton botonPrensa;
    private final JLabel lblClasificacion;
    private final JLabel lblPartidos_1;
    private final JLabel lbClasif1;
    private final JLabel lbClasif2;
    private final JLabel lbClasif3;

    private List<Partidos> listaPartidos = new ArrayList<>();
    JList lista = new JList();

    public GUI_Partidos(JFrame frame) {
        framePrincipal = frame;

        panelContenedor = new JPanel(new GridLayout(3, 2));
        panelArriba = new JPanel(new GridLayout(2, 1));
        subpanelTitulo = new JPanel(new GridLayout(1, 1));
        subpanelEnBlanco1 = new JPanel(new GridLayout(1, 1));
        panelParYClas = new JPanel(new GridLayout(1, 2));
        panelPartidos = new JPanel(new GridLayout(1, 1));
        panelClasificacion = new JPanel(new GridLayout(3, 1));
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

        subpanelMenu.add(botonEquipos);
        subpanelMenu.add(botonPartidos);
        subpanelMenu.add(botonForos);
        subpanelMenu.add(botonPrensa);

        panelArriba.add(subpanelTitulo);
        panelArriba.add(subpanelEnBlanco1);

        lblPartidos_1 = new JLabel("Partidos");
        lblPartidos_1.setHorizontalAlignment(SwingConstants.CENTER);
        subpanelEnBlanco1.add(lblPartidos_1);

        lblClasificacion = new JLabel("Clasificaci\u00F3n");
        lblClasificacion.setHorizontalAlignment(SwingConstants.CENTER);
        subpanelEnBlanco1.add(lblClasificacion);


        List<Equipo> listaEquipos = new ArrayList<>();

        main.ConexionBD BD = main.ConexionBD.getInstance();

        listaPartidos = BD.getPartidos();
        lista=ListToJlist(listaPartidos);
        lista.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                jlistEvent(e);
            }
        });

        panelPartidos.add(lista);

        listaEquipos = RankingEquipos(baseDatos);
        lbClasif1 = new JLabel("1º " + listaEquipos.get(0).getNombre() + " con " + listaEquipos.get(0).getPuntos() + " puntos");
        lbClasif2 = new JLabel("2º " + listaEquipos.get(1).getNombre() + " con " + listaEquipos.get(1).getPuntos() + " puntos");
        lbClasif3 = new JLabel("3º " + listaEquipos.get(2).getNombre() + " con " + listaEquipos.get(2).getPuntos() + " puntos");
        lbClasif1.setHorizontalAlignment(SwingConstants.CENTER);
        lbClasif2.setHorizontalAlignment(SwingConstants.CENTER);
        lbClasif3.setHorizontalAlignment(SwingConstants.CENTER);

        panelClasificacion.add(lbClasif1);
        panelClasificacion.add(lbClasif2);
        panelClasificacion.add(lbClasif3);

        panelParYClas.add(panelPartidos);
        panelParYClas.add(panelClasificacion);

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

    private List<Equipo> ordenaLista(List<Equipo> Top3){
        int res1 = Top3.get(0).getPuntos();
        int res2 = Top3.get(1).getPuntos();
        int res3 = Top3.get(2).getPuntos();

        if (res1 < res2) {  // Si el primer equipo tiene peores resultados que el segundo, se intercambian
            Equipo resAux = Top3.get(0);  // Y se intercambian los resultados tambien
            Top3.add(0, Top3.get(1));
            Top3.add(1, resAux);
        }
        if (res2 < res3) {  // Si el segundo equipo tiene peores resultados que el tercero, se intercambian
            Equipo resAux = Top3.get(1);
            Top3.add(1, Top3.get(2));
            Top3.add(2, resAux);
            if (res1 < res2) {  // Si el segundo y el tercer equipo se han intercambiado, se compara el primero con el segundo otra vez
                Equipo resAux2 = Top3.get(0);  // Y se intercambian los resultados tambien
                Top3.add(0, Top3.get(1));
                Top3.add(1, resAux2);
            }
        }
        return Top3;
    }

    // Metodo privado para calcular los 3 mejores equipos de la temporada
    private List<Equipo> RankingEquipos(main.ConexionBD BD) {
        List<Equipo> Top3 = new ArrayList<>();  // Lista con los 3 mejores equipos
        List<Equipo> Equipos;  // Lista con todos los equipos de la temporada
        List<Partidos> Partidos; // Lista con todos los partidos de un equipo
        Equipos = BD.getEquipos();
        int n = 0, resultadoTotal;/*i = 0, res1 = 0, res2 = 0, res3 = 0*/
        while (Equipos.size() > n) {  // Recorre todos los equipos de la lista
            resultadoTotal = Equipos.get(n).getPuntos();
            /*resultadoTotal = 0;  // Goles totales de todos los partidos del equipo
            Partidos = BD.getPartidosDeEquipo(Equipos.get(n));  // Cogemos de la BD todos los partidos del equipo que este en el bucle en este momento
            while (Partidos.size() > i) {  // Recorre todos los partidos de la lista
                if (Equipos.get(n).equals(Partidos.get(i).getEquipoLocal())) {  // Si el equipo es el local, se coge el primer caracter de resultados, y se pasa a int
                    resultadoTotal = resultadoTotal + Character.getNumericValue(Partidos.get(i).getResultado().charAt(0));
                } else
                    resultadoTotal = resultadoTotal + Character.getNumericValue(Partidos.get(i).getResultado().charAt(2)); // Si el equipo es visitante, se coge el tercer caracter de resultados
                i++;
            }*/
            if (n < 3) { // Si la lista todavia no tiene 3 elementos, mete el equipo sin hacer comprobaciones
                Top3.add(Equipos.get(n));
                if (n == 2) { // Cuando tenga los 3 primeros equipos, la lista se ordena de mayor a menor
                    Top3 = ordenaLista(Top3);
                }
                //Cuando haya 3 o más equipos, como la lista está ordenada, solo necesita comparar con el que está en 3º puesto
            } else if (resultadoTotal > Top3.get(2).getPuntos()) {  // Si hay 3 o mas equipos en la lista, compara los resultados
                Top3.remove(2);  // Si el resultado del equipo de la lista es menor que el del equipo del bucle actual, se sustituye
                Top3.add(Equipos.get(n));
                Top3 = ordenaLista(Top3);
            }
            n++;
        }
        return Top3;
    }

    public JList<Partidos> ListToJlist(List<Partidos> lista) {
        JList<Partidos> nuevo = new JList();
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < lista.size(); i++) {
            modelo.addElement(lista.get(i));
        }
        nuevo.setModel(modelo);
        return nuevo;
    }

    public void controlador(ActionListener ctr) {
        //boton partidos
        botonPartidos.addActionListener(ctr);
        botonPartidos.setActionCommand("BOTON PAR:PARTIDOS");
        //boton equipos
        botonEquipos.addActionListener(ctr);
        botonEquipos.setActionCommand("BOTON PAR:EQUIPOS");
        //boton Foros
        botonForos.addActionListener(ctr);
        botonForos.setActionCommand("BOTON PAR:FOROS");
        //boton prensa--goleadores
        botonPrensa.addActionListener(ctr);
        botonPrensa.setActionCommand("BOTON PAR:PRENSA");

    }

    public void jlistEvent(ListSelectionEvent e) {
        if(!lista.getValueIsAdjusting()) {
            System.out.println(lista.getSelectedIndex());
            LanzarEstadísticasPartido(lista.getSelectedIndex());
        }
    }

    public void LanzarEstadísticasPartido(int indx){
        if(indx<6){
            partido=listaPartidos.get(indx);
            CardLayout layout = (CardLayout) framePrincipal.getContentPane().getLayout();
            layout.show(framePrincipal.getContentPane(), "EstadisticasPartido");
        }

        System.out.println("Se ha pulsado el Partido" + "Abrir GUI_EstadisticasPartido");
    }

    public Partidos getPartido() {
        return partido;
    }

    public void LanzarPartidos() {
        System.out.println("Se ha pulsado el boton Partidos "
                + "Abrir GUI_Partidos");
    }

    public void LanzarEquipos() {
        /*
        GUI_Inicial gui = new GUI_Inicial();
        Controlador ctr = new Controlador(gui);
        gui.controlador(ctr);
        removeAll();
        add(gui);
        //framePartidos.dispose();
        //dispose();
        */

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
        CardLayout layout = (CardLayout) framePrincipal.getContentPane().getLayout();
        layout.show(framePrincipal.getContentPane(), "Prensa");

        System.out.println("Se ha pulsado el boton Prensa "
                + "Abrir GUI_Prensa");
    }
}