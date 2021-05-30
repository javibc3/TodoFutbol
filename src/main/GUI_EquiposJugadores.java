package main;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

/**
 * Implementa el apartado de Jugadores del submenu de Equipos
 * @see GUI_Equipos
 */

public class GUI_EquiposJugadores extends JPanel {
    private JList<String> listaPortero;
    private JList<String> listaDefensa;
    private JList<String> listaCentral;
    private JList<String> listaDelantero;
    private JScrollPane listaPorteroScroll;
    private JScrollPane listaDefensaScroll;
    private JScrollPane listaCentralScroll;
    private JScrollPane listaDelanteroScroll;

    private JLabel labelPortero;
    private JLabel labelDefensa;
    private JLabel labelCentral;
    private JLabel labelDelantero;

    private HashMap<String, List<Jugador>> jugadores;

    //TODO Falta la parte de organizar los jugadores en la distintas lista mediante su posicion.
    //TODO Falta tambien metodos para cambiar los diferentes campos de la interfaz

    public JList ListToJlist(List<Jugador> jugadores){
        JList nuevo = new JList();
        DefaultListModel modelo = new DefaultListModel();
        for(int i=0;i<jugadores.size();i++) {
            modelo.addElement(jugadores.get(i).getNombre());
        }
        nuevo.setModel(modelo);
        return nuevo;
    }

    public GUI_EquiposJugadores(HashMap<String, List<Jugador>> jugadores){
        super(new GridLayout(2,4,5,0));


        listaPortero = new JList<>();
        listaPortero = ListToJlist(jugadores.get("POR"));
        listaDefensa = new JList<>();
        listaDefensa = ListToJlist(jugadores.get("DEF"));
        listaCentral = new JList<>();
        listaCentral = ListToJlist(jugadores.get("CEN"));
        listaDelantero = new JList<>();
        listaDelantero = ListToJlist(jugadores.get("DEL"));

        listaPorteroScroll = new JScrollPane(listaPortero);
        listaDefensaScroll = new JScrollPane(listaDefensa);
        listaCentralScroll = new JScrollPane(listaCentral);
        listaDelanteroScroll = new JScrollPane(listaDelantero);

        labelPortero = new JLabel("Porteros");
        labelDefensa = new JLabel("Defensas");
        labelCentral = new JLabel("Centrales");
        labelDelantero = new JLabel("Delanteros");
        labelDelantero.setHorizontalAlignment(SwingConstants.CENTER);
        labelDefensa.setHorizontalAlignment(SwingConstants.CENTER);
        labelCentral.setHorizontalAlignment(SwingConstants.CENTER);
        labelPortero.setHorizontalAlignment(SwingConstants.CENTER);
        labelPortero.setBorder(new LineBorder(Color.BLACK));
        labelDefensa.setBorder(new LineBorder(Color.BLACK));
        labelCentral.setBorder(new LineBorder(Color.BLACK));
        labelDelantero.setBorder(new LineBorder(Color.BLACK));

        add(labelPortero);
        add(labelDefensa);
        add(labelCentral);
        add(labelDelantero);

        add(listaPorteroScroll);
        add(listaDefensaScroll);
        add(listaCentralScroll);
        add(listaDelanteroScroll);

        this.jugadores = jugadores;
    }


}
