package Controladores;

import GUI.GUI_Prensa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrensa implements ActionListener {
    private final GUI_Prensa prensa;

    public ControladorPrensa(GUI_Prensa prensa) {
        this.prensa = prensa;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "BOTON PARTIDOS": prensa.LanzarPartidos(); break;
            case "BOTON EQUIPOS": prensa.LanzarEquipos();break;
            case "BOTON PRENSA": prensa.LanzarPrensa();break;
            case "BOTON FOROS": prensa.LanzarForos();break;
            case "BOTON AS": prensa.openWebpage("https://as.com/");break;
            case "BOTON MARCA": prensa.openWebpage("https://www.marca.com/");break;
            case "BOTON MD": prensa.openWebpage("https://www.mundodeportivo.com/");break;
        }
    }

}
