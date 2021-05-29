package main;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Implementa el apartado de Partidos del submenu de Equipos
 * @see GUI_Equipos
 */
public class GUI_EquiposPartido extends JPanel {

    private JList<String> listaPartidos;
    private JScrollPane listaConScrollbar;

    // TODO Falta toda la parte de formatear cada partido y mostrarlo en la lista, se podria hacer un una funcion a parte
    //TODO Ademas se necesitaria otro metodo para cambiar los partidos

    public GUI_EquiposPartido(List<String> partidos){
        super(new GridLayout(1,1));

        //String de prueba
        String[] partidosArray = {"Partido1" , "Partido2" , "Partido3"};
        listaPartidos = new JList<String>(partidosArray);
        listaPartidos.setFixedCellHeight(-1);
        listaConScrollbar = new JScrollPane(listaPartidos);

        add(listaPartidos);
    }

}
