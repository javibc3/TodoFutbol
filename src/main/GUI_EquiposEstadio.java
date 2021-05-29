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

    public GUI_EquiposEstadio(String imagen, Estadio estadio){
        super(new GridLayout(1,2));

        nombre = new JLabel("Nombre");
        aforo = new JLabel("Aforo");
        ciudad = new JLabel("Ciudad");
        fechaCreacion = new JLabel("Fecha de construccion");

        if(estadio != null) {
            setNombreEstadio(estadio);
            setAforoEstadio(estadio);
            setCiudadEstadio(estadio);
            setFechaEstadio(estadio);
        } else {
            nombreEstadio = new JLabel("PruebaNombre");
            aforoEstadio = new JLabel("PruebaAforo");
            ciudadEstadio = new JLabel("PruebaCiudad");
            fechaEstadio = new JLabel("PruebaFecha");
        }
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

    private void setNombreEstadio(Estadio est){
        nombreEstadio = new JLabel(est.getNombre());
    }

    private void setAforoEstadio(Estadio est){
        aforoEstadio = new JLabel(Integer.toString(est.getAforo()));
    }

    private void setCiudadEstadio(Estadio est){
        ciudadEstadio = new JLabel(est.getCiudad());
    }

    private void setFechaEstadio(Estadio est){
        fechaEstadio = new JLabel(Integer.toString(est.getFechaconstruccion()));
    }

}
