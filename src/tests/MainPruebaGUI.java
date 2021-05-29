package tests;

import main.Controlador;
import main.GUI_Inicial;

public class MainPruebaGUI {
    public static void main(String[] args) {
        GUI_Inicial gui = new GUI_Inicial();
        //GUI_Partidos guiPar = new GUI_Partidos();
        Controlador ctr = new Controlador(gui);
        gui.controlador(ctr);
        //guiPar.controlador(ctr);
    }
}
