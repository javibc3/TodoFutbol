package main;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Implementa el apartado de Estadio del submenu de Equipos
 * @see GUI_Equipos
 */

public class GUI_EquiposEstadio extends JPanel {
    private JLabel nombre;
    private JLabel aforo;
    private JLabel ciudad;
    private JLabel fechaCreacion;

    //Estos son los datos del estadio
    private JLabel nombreEstadio;
    private JLabel aforoEstadio;
    private JLabel ciudadEstadio;
    private JLabel fechaEstadio;

    private JPanel panelIzquierdo;
    private ImageIcon imagen;

    //TODO Habria que crear varios metodos para modificar los diferentes campos de la interfaz (nombre, aforo, imagen, etc)

    public GUI_EquiposEstadio(String imagen){
        super(new GridLayout(1,2));

        nombre = new JLabel("Nombre");
        aforo = new JLabel("Aforo");
        ciudad = new JLabel("Ciudad");
        fechaCreacion = new JLabel("Fecha de construccion");

        nombreEstadio = new JLabel();
        aforoEstadio = new JLabel();
        ciudadEstadio = new JLabel();
        fechaEstadio = new JLabel();

        panelIzquierdo = new JPanel(new GridLayout(4,2));

        panelIzquierdo.add(nombre);
        panelIzquierdo.add(nombreEstadio);
        panelIzquierdo.add(aforo);
        panelIzquierdo.add(aforoEstadio);
        panelIzquierdo.add(ciudad);
        panelIzquierdo.add(ciudadEstadio);
        panelIzquierdo.add(fechaCreacion);
        panelIzquierdo.add(fechaEstadio);

        add(panelIzquierdo);
        Image imagenRescalada;
        try {
            this.imagen = new ImageIcon(new URL(imagen));
             imagenRescalada = this.imagen.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
            this.imagen.setImage(imagenRescalada);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        add(new JLabel(this.imagen));

    }

}
