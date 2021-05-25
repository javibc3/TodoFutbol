package main;

public class Jugador {
    private int id;
    private String nombre;
    private String nacionalidad;
    private String posicion;
    private int edad;
    private int idEquipo;
    private int dorsal;

    public Jugador(int id, String nom, String nac, String pos, int ed, int idEq, int dorsal){
        this.id = id;
        nombre = nom;
        nacionalidad = nac;
        posicion = pos;
        edad = ed;
        idEquipo = idEq;
        this.dorsal=dorsal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}
