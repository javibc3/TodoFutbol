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

    // TODO Falta toda la parte de formatear cada partido y mostrarlo en la lista, se podria hacer en una funcion a parte
    // Creo que el TO-DO de arriba esta ya hecho en el toString de Partidos
    //TODO Ademas se necesitaria otro metodo para cambiar los partidos

    public GUI_EquiposPartido(List<Partidos> partidos){
        super(new GridLayout(1,1));

         /*
        int n = 0;
        String[] partidosArray = new String[20];
        while(partidos.size() > n){
            partidosArray[n] = partidos.get(n).toString();
            n++;
        }
        listaPartidos = new JList<String>(partidosArray);
        listaConScrollbar = new JScrollPane(listaPartidos);
        */

        //String de prueba, si has descomentado la parte anterior, borra estas 3 lineas
        String[] partidosArray = {"Partido1" , "Partido2" , "Partido3" , "Partido4" , "Partido5" , "Partido6" , "Partido7" , "Partido8" , "Partido9" , "Partido10" , "Partido11" , "Partido12"};
        listaPartidos = new JList<>(partidosArray);
        listaConScrollbar = new JScrollPane(listaPartidos);

        add(listaConScrollbar);
    }

}
