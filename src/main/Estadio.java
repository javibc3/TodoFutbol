package main;

import java.sql.Date;

public class Estadio {
    private int idestadio;
    private String nombre;
    private int aforo;
    private int capacity;
    private int fechaconstruccion;
    private String ciudad;
    private int idequipo;

    public Estadio(int idestadio, String nombre, int aforo, int capacity, int fechaconstruccion, String ciudad, int idequipo) {
        this.idestadio = idestadio;
        this.nombre = nombre;
        this.aforo = aforo;
        this.capacity = capacity;
        this.fechaconstruccion = fechaconstruccion;
        this.ciudad = ciudad;
        this.idequipo = idequipo;
    }

    public int getIdestadio() {
        return idestadio;
    }

    public void setIdestadio(int idestadio) {
        this.idestadio = idestadio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFechaconstruccion() {
        return fechaconstruccion;
    }

    public void setFechaconstruccion(int fechaconstruccion) {
        this.fechaconstruccion = fechaconstruccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }
}
