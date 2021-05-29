package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


public class GUI_Partidos extends  JFrame{

    private JFrame framePartidos;

    JPanel panelContenedor;

    private JPanel panelArriba;
    private JPanel subpanelTitulo;
    private JPanel subpanelEnBlanco1;

    private JPanel panelPartidos;

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
    private JLabel lbPartido1;
    private JLabel lbPartido2;
    private JLabel lbPartido3;
    private JLabel lbClasif1;
    private JLabel lbClasif2;
    private JLabel lbClasif3;

    public GUI_Partidos(){
        framePartidos = new JFrame("TodoFútbol");

        panelContenedor = new JPanel(new GridLayout(3, 1));
        panelArriba = new JPanel(new GridLayout(2, 1));
        subpanelTitulo = new JPanel(new GridLayout(1, 1));
        subpanelEnBlanco1 = new JPanel(new GridLayout(1, 1));
        panelPartidos = new JPanel(new GridLayout(3, 2));
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

        List<Partidos> listaPartidos = new ArrayList<>();
        List<Equipo> listaEquipos = new ArrayList<>();
        lbPartido1 = new JLabel("Partido1");
        lbPartido2 = new JLabel("Partido2");
        lbPartido3 = new JLabel("Partido3");
        lbPartido1.setHorizontalAlignment(SwingConstants.CENTER);
        lbPartido2.setHorizontalAlignment(SwingConstants.CENTER);
        lbPartido3.setHorizontalAlignment(SwingConstants.CENTER);
        /*
        main.ConexionBD BD = main.ConexionBD.getInstance();
        listaPartidos = BD.getPartidos();
        lbPartido1 = new JLabel(listaPartidos.get(0).toString());
        lbPartido2 = new JLabel(listaPartidos.get(1).toString());
        lbPartido3 = new JLabel(listaPartidos.get(2).toString());

        listaEquipos = RankingEquipos(BD);
        lbClasif1 = new JLabel(listaEquipos.get(0).getNombre());
        lbClasif2 = new JLabel(listaEquipos.get(1).getNombre());
        lbClasif3 = new JLabel(listaEquipos.get(2).getNombre());
        */
        lbClasif1 = new JLabel("Placeholder1");
        lbClasif2 = new JLabel("Placeholder2");
        lbClasif3 = new JLabel("Placeholder3");
        lbClasif1.setHorizontalAlignment(SwingConstants.CENTER);
        lbClasif2.setHorizontalAlignment(SwingConstants.CENTER);
        lbClasif3.setHorizontalAlignment(SwingConstants.CENTER);

        panelPartidos.add(lbPartido1);
        panelPartidos.add(lbClasif1);
        panelPartidos.add(lbPartido2);
        panelPartidos.add(lbClasif2);
        panelPartidos.add(lbPartido3);
        panelPartidos.add(lbClasif3);

        panelAbajo.add(subpanelEnBlanco2);
        panelAbajo.add(subpanelMenu);

        panelContenedor.add(panelArriba);
        panelContenedor.add(panelPartidos);
        panelContenedor.add(panelAbajo);

        framePartidos.getContentPane().add(panelContenedor);

        framePartidos.setVisible(true);
        framePartidos.setMinimumSize(new Dimension(400,400));
        framePartidos.pack();
        framePartidos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Metodo privado para calcular los 3 mejores equipos de la temporada
    private List<Equipo> RankingEquipos(main.ConexionBD BD) {
        List<Equipo> Top3 = new ArrayList<>();  // Lista con los 3 mejores equipos
        List<Equipo> Equipos;  // Lista con todos los equipos de la temporada
        List<Partidos> Partidos; // Lista con todos los partidos de un equipo
        Equipos = BD.getEquipos();
        int n = 0, i = 0, resultadoTotal, res1 = 0, res2 = 0, res3 = 0;
        while (Equipos.size() > n) {  // Recorre todos los equipos de la lista
            resultadoTotal = 0;  // Goles totales de todos los partidos del equipo
            Partidos = BD.getPartidosDeEquipo(Equipos.get(n));  // Cogemos de la BD todos los partidos del equipo que este en el bucle en este momento
            while(Partidos.size() > i) {  // Recorre todos los partidos de la lista
                if(Equipos.get(n).equals(Partidos.get(i).getEquipoLocal())){  // Si el equipo es el local, se coge el primer caracter de resultados, y se pasa a int
                    resultadoTotal = resultadoTotal + Character.getNumericValue(Partidos.get(i).getResultado().charAt(0));
                } else resultadoTotal = resultadoTotal + Character.getNumericValue(Partidos.get(i).getResultado().charAt(2)); // Si el equipo es visitante, se coge el tercer caracter de resultados
                i++;
            }
            if(n < 3){ // Si la lista todavia no tiene 3 elementos, mete el equipo sin hacer comprobaciones
                Top3.add(Equipos.get(n));
                if(n == 0){
                    res1 = resultadoTotal;  // res1 es el resultado total del primer equipo del Top3, res2, del segundo, y res3, del tercero
                } else if (n == 1){
                    res2 = resultadoTotal;
                } else res3 = resultadoTotal;
            } else if(resultadoTotal > res1) {  // Si hay 3 o mas equipos en la lista, compara los resultados
                Top3.remove(0);  // Si el resultado del equipo de la lista es menor que el del equipo del bucle actual, se sustituye
                Top3.add(Equipos.get(n));
            } else if(resultadoTotal > res2) {
                Top3.remove(1);
                Top3.add(Equipos.get(n));
            } else if(resultadoTotal > res3) {
                Top3.remove(2);
                Top3.add(Equipos.get(n));
            }
            n++;
        }
        // Finalmente, se ordena la lista
        if(res1 < res2) {  // Si el primer equipo tiene peores resultados que el segundo, se intercambian
            Equipos.add(0, Equipos.get(1));
            int resAux = res1;  // Y se intercambian los resultados tambien
            res1 = res2;
            res2 = resAux;
        }
        if(res2 < res3) {  // Si el segundo equipo tiene peores resultados que el tercero, se intercambian
            Equipos.add(1, Equipos.get(2));
            int resAux = res2;
            res2 = res3;
            res3 = resAux;
            if(res1 < res2) {  // Si el segundo y el tercer equipo se han intercambiado, se compara el primero con el segundo otra vez
                Equipos.add(0, Equipos.get(1));
                resAux = res1;
                res1 = res2;
                res2 = resAux;
            }
        }
        return Top3;
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
    public void LanzarPartidos() {
        System.out.println("Se ha pulsado el boton partidos "
                + "Abrir GUI_partidos");
    }
    public void LanzarEquipos() {
        GUI_Inicial gui = new GUI_Inicial();
        Controlador ctr = new Controlador(gui);
        gui.controlador(ctr);
        gui.setVisible(true);
        framePartidos.dispose();
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