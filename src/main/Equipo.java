package main;

public class Equipo {
    private int id;
    private String nombre;
    private String escudo;

    public Equipo(int id, String nom, String Esc){
        this.id = id;
        nombre = nom;
        escudo = Esc;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }
/* toString de prueba para la clase test.PruebaConexionBD
    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", escudo='" + escudo + '\'' +
                '}';
    }
 */
}
