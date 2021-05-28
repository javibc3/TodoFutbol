package tests;

import main.ControladorGuiInicial;
import main.GUI_Equipos;
import main.GUI_Inicial;

import java.util.ArrayList;
import java.util.List;

public class MainPruebaGUI {
    public static void main(String[] args) {
        GUI_Inicial gui = new GUI_Inicial();
        ControladorGuiInicial ctr = new ControladorGuiInicial(gui);
        gui.controlador(ctr);
    }
}
