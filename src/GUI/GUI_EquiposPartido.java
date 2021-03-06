package GUI;

import main.Partidos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementa el apartado de Partidos del submenu de Equipos
 *
 * @see GUI_Equipos
 */
public class GUI_EquiposPartido extends JPanel {

    private JList<String> listaPartidos;
    private final JScrollPane listaConScrollbar;

    // TODO Falta toda la parte de formatear cada partido y mostrarlo en la lista, se podria hacer en una funcion a parte
    // Creo que el TO-DO de arriba esta ya hecho en el toString de Partidos
    //TODO Ademas se necesitaria otro metodo para cambiar los partidos

    public GUI_EquiposPartido(List<Partidos> partidos) {
        super(new GridLayout(1, 1));

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
        String Partido;
        ArrayList partidosArray = new ArrayList();
        Partidos partido;
        listaPartidos = new JList<>();
        if (partidos == null) {
            partidosArray.add("");

        } else {
            for (int i = 0; i < partidos.size(); i++) {
                partido = partidos.get(i);
                Partido = partido.getEquipoLocal().getNombre() + " " + partido.getResultado() + " " + partido.getEquipoVisitante().getNombre() + "     Fecha: " + partido.getFecha();
                partidosArray.add(Partido);
            }
            listaPartidos = ListToJlist(partidosArray);

            // Para centrar el texto de las entradas de la lista y que quede un poco más legible
            DefaultListCellRenderer renderer =  (DefaultListCellRenderer)listaPartidos.getCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
        }

        listaConScrollbar = new JScrollPane(listaPartidos);



        add(listaConScrollbar);
    }

    public JList ListToJlist(ArrayList partidos) {
        JList nuevo = new JList();
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < partidos.size(); i++) {
            modelo.addElement(partidos.get(i));
        }
        nuevo.setModel(modelo);
        return nuevo;
    }

}
