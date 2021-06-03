package GUI;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/*
 *  Implementa el menu de estadísticas de un partido, el cual entra en acción cuando se hace doble-click en un
 *  partido de la lista que está en el GUI_EquiposPartido y GUI_Partidos
 */
public class GUI_EstadisticasPartido extends JPanel {

    JPanel panelContenedor;
    private final JFrame framePrincipal;

    private final JPanel panelArriba;
    private final JPanel subpanelTitulo;
    private final JPanel subpanelEnBlanco1;

    private final JPanel panelEstTotal;
    private final JPanel panelEstEqLocal;
    private final JPanel panelEstEqVisitante;

    private final JPanel panelAbajo;
    private final JPanel subpanelEnBlanco2;
    private final JPanel subpanelMenu;

    private final JLabel labelTitulo;
    private final JLabel lblEquipoVi;
    private final JLabel lblEquipoLo;
    //private final JLabel lbClasif1;
    //private final JLabel lbClasif2;

    private final JButton botonEquipos;
    private final JButton botonPartidos;
    private final JButton botonForos;
    private final JButton botonPrensa;

    private JList<String> listaEstadisticas;
    private JScrollPane EstadisticasConScrollbar;

    public GUI_EstadisticasPartido(int Id_Partido, int Id_Equipo, JFrame frame){

        framePrincipal = frame;
        main.ConexionBD BD = main.ConexionBD.getInstance();

        panelContenedor = new JPanel(new GridLayout(3, 2));

        //Parte de arriba
        panelArriba = new JPanel(new GridLayout(2, 1));
        subpanelTitulo = new JPanel(new GridLayout(1, 1));
        subpanelEnBlanco1 = new JPanel(new GridLayout(1, 1));

        //Parte de en medio
        panelEstTotal = new JPanel(new GridLayout(1, 2));
        panelEstEqLocal = new JPanel(new GridLayout(1, 1));
        panelEstEqVisitante = new JPanel(new GridLayout(1, 1));

        //Parte de abajo
        panelAbajo = new JPanel(new GridLayout(2, 1));
        subpanelEnBlanco2 = new JPanel(new GridLayout(1, 1));
        subpanelMenu = new JPanel(new GridLayout(1, 4));


        //Título
        labelTitulo = new JLabel("TodoFútbol");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
        labelTitulo.setFont(new Font("Serif", Font.PLAIN, 50));

        subpanelTitulo.add(labelTitulo);
        panelArriba.add(subpanelTitulo);

        //Título de las dos columnas
        lblEquipoLo = new JLabel("Equipo Local: Nombre");
        lblEquipoLo.setHorizontalAlignment(SwingConstants.CENTER);
        subpanelEnBlanco1.add(lblEquipoLo);

        lblEquipoVi = new JLabel("Equipo visitante: Nombre");
        lblEquipoVi.setHorizontalAlignment(SwingConstants.CENTER);
        subpanelEnBlanco1.add(lblEquipoVi);

        panelArriba.add(subpanelEnBlanco1);

        //Columna equipo Local
        List<Estadisticas_Partidos> EstEqLocal = BD.getEstadisticasPartidos(Id_Partido, Id_Equipo);
        /*
        lbClasif1 = new JLabel("Por ahora no hay nada");
        lbClasif1.setHorizontalAlignment(SwingConstants.CENTER);
        panelEstEqLocal.add(lbClasif1);*/

        panelEstEqLocal.add(EstadisticaListaConScroll(EstEqLocal));

        //Columna equipo Visitante
        List<Estadisticas_Partidos> EstEqVisitante = BD.getEstadisticasPartidos(Id_Partido, Id_Equipo);
        /*
        lbClasif2 = new JLabel("Por ahora no hay nada");
        lbClasif2.setHorizontalAlignment(SwingConstants.CENTER);
        panelEstEqVisitante.add(lbClasif2);*/

        panelEstEqVisitante.add(EstadisticaListaConScroll(EstEqVisitante));

        panelEstTotal.add(panelEstEqLocal);
        panelEstTotal.add(panelEstEqVisitante);

        //Botones
        setVisible(true);
        setMinimumSize(new Dimension(400, 400));
        botonEquipos = new JButton("Equipos");
        botonPartidos = new JButton("Partidos");
        botonForos = new JButton("Foros");
        botonPrensa = new JButton("Prensa");

        subpanelMenu.add(botonEquipos);
        subpanelMenu.add(botonPartidos);
        subpanelMenu.add(botonForos);
        subpanelMenu.add(botonPrensa);

        panelAbajo.add(subpanelEnBlanco2);
        panelAbajo.add(subpanelMenu);

        panelContenedor.add(panelArriba);
        panelContenedor.add(panelEstTotal);
        panelContenedor.add(panelAbajo);

        add(panelContenedor);
    }

    public Component EstadisticaListaConScroll(List<Estadisticas_Partidos> EstEq) {

        String Estadisticas;
        listaEstadisticas = new JList<>();

        if (EstEq == null) {
            Estadisticas = "";
        } else {
            Estadisticas = EstEq.toString();
        }

        listaEstadisticas = ListToJlist(Estadisticas);
        EstadisticasConScrollbar = new JScrollPane(listaEstadisticas);

        add(EstadisticasConScrollbar);
        return null;
    }

    public JList ListToJlist(String est) {
        JList nuevo = new JList();
        DefaultListModel modelo = new DefaultListModel();
        modelo.addElement(est);
        nuevo.setModel(modelo);
        return nuevo;
    }

    public void ControladorEstadisticas(ActionListener ctr) {
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

    public void LanzarPartidos() {
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

