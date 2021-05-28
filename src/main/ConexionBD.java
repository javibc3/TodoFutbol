package main;

import java.sql.*;
import java.sql.Date;
import java.util.*;


/**
 * Esta clase main.ConexionBD es la encargada de conectarse con la base de datos e implementa algunos metodos para acceder
 * a los diferentes datos que requiere la aplicacion (p.ej el metodo getEquipos() devuelve una lista con todos los equipos
 * que se encuentran en la base de datos)
 */
public class ConexionBD {

    private static final String URL ="jdbc:mysql://iis2021.cobadwnzalab.eu-central-1.rds.amazonaws.com";
    private static final String SCHEMA = "grupoD";
    private static final String USER = "usuarioD";
    private static final String PASS = "bonillaciborro";

    private Connection connection;

    private static ConexionBD instanciaConexion = null;

    private ConexionBD(){
        try{
            connection = DriverManager.getConnection(URL + "/" + SCHEMA, USER, PASS);
        }catch (SQLException e){
            System.err.println("SQL exception: "+e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ConexionBD getInstance(){
        if (instanciaConexion == null){
            instanciaConexion = new ConexionBD();
        }
        return instanciaConexion;
    }

    /**
     * Devuelve una lista con los equipos que hay presentes en la base de datos
     * @return Los equipos presentes en la base de datos o {@code null} si no hay ningun equipo
     */
    public List<Equipo> getEquipos(){
        List<Equipo> listaEquipos = null;

        try {
            Statement sentencia = connection.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM EQUIPOS");
            if(rs.isBeforeFirst()){
                listaEquipos = new ArrayList<>();
                while(rs.next()){
                    int id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String escudo = rs.getString(3);
                    Equipo eq = new Equipo(id,nombre,escudo);
                    listaEquipos.add(eq);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaEquipos;
    }

    /**
     * Devuelve una lista de jugadores que pertenecen a un equipo especifico
     * @param equipo El equipo del cual se quieren obtener los jugadores
     * @return Una {@code List} con los jugadores o {@code null} si ese equipo no existe
     */
    public List<Jugador> getJugadoresDeEquipo(Equipo equipo){
        List<Jugador> listaJugadores = null;

        try {
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM JUGADORES WHERE IDEQUIPO = ?");
            sentencia.setInt(1,equipo.getId());
            ResultSet rs = sentencia.executeQuery("SELECT * FROM JUGADORES WHERE IDEQUIPO = ?");
            if(rs.isBeforeFirst()){
                listaJugadores = new ArrayList<>();
                while(rs.next()){
                    int id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String nacion = rs.getString(3);
                    String pos = rs.getString(4);
                    int edad = rs.getInt(5);
                    int ideq = rs.getInt(6);
                    int dorsal = rs.getInt(7);
                    Jugador jug = new Jugador(id,nombre,nacion,pos,edad,ideq,dorsal);
                    listaJugadores.add(jug);
                }
            }

        } catch (SQLException throwables) {
            System.err.println("SQL exception:"+throwables.getMessage());
            throwables.printStackTrace();
        }
        return listaJugadores;

    }

    /**
     * Obtiene los jugadores de un Equipo mediante su identificador numerico
     * @param id El identificador unico del equipo
     * @return Una {@code List} de los jugadores del Equipo o {@code null} si {@code id} no se corresponde a ningun equipo
     */
    public List<Jugador> getJugadoresDeEquipo(int id){
        List<Jugador> listaJugadores = null;

        try {
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM JUGADORES WHERE IDEQUIPO = ?");
            sentencia.setInt(1,id);
            ResultSet rs = sentencia.executeQuery();
            if(rs.isBeforeFirst()){
                listaJugadores = new ArrayList<>();
                while(rs.next()){
                    int idjug = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String nacion = rs.getString(3);
                    String pos = rs.getString(4);
                    int edad = rs.getInt(5);
                    int ideq = rs.getInt(6);
                    int dorsal = rs.getInt(7);
                    Jugador jug = new Jugador(idjug,nombre,nacion,pos,edad,ideq,dorsal);
                    listaJugadores.add(jug);
                }
            }

        } catch (SQLException throwables) {
            System.err.println("SQL exception:"+throwables.getMessage());
            throwables.printStackTrace();
        }
        return listaJugadores;

    }

    /**
     * Obtenemos de la base de datos el estadio correspondiente un equipo
     * @param equipo main.Equipo del cual queremos obtener el estadio
     * @return El estadio perteneciente al equipo introducido por parametro o {@code null} si ese equipo no existe
     */
    public Estadio getEstadioDeEquipo(Equipo equipo){
        Estadio estadio = null;

        try {
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM ESTADIO WHERE IDEQUIPO = ?");
            sentencia.setInt(1,equipo.getId());
            ResultSet rs = sentencia.executeQuery();
            if(rs.isBeforeFirst()){
                rs.next();
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                int aforo = rs.getInt(3);
                int tam = rs.getInt(4);
                int fecha= rs.getInt(5);
                String ciudad = rs.getString(6);
                int ideq = rs.getInt(7);
                estadio = new Estadio(id,nombre,aforo,tam,fecha,ciudad,ideq);
            }
        } catch (SQLException throwables) {
            System.err.println("SQL Exception: "+throwables.getMessage());
            throwables.printStackTrace();
        }
        return estadio;
    }

    /**
     * Obtenenos de la base de datos las estadisticas de un jugador que entra por parametro
     * @param jugador main.Jugador del cual queremos obtener sus estadisticas
     * @return La estadistica del jugador como un objeto main.Estadistica o null si ese jugador no existe
     */
    public Estadistica getEstadisticaDeJugador(Jugador jugador){
        Estadistica est = null;
        PreparedStatement sentencia;

        try {
            sentencia = connection.prepareStatement("SELECT * FROM ESTADISTICAS WHERE IDJUGADOR = ?");
            sentencia.setInt(1,jugador.getId());
            ResultSet rs = sentencia.executeQuery();
            if(rs.isBeforeFirst()){
                rs.next();
                int idJugador = rs.getInt(1);
                int partidosJugados = rs.getInt(2);
                int numGoles = rs.getInt(3);
                int distRec = rs.getInt(4);
                int asistencias = rs.getInt(5);
                int tarjetasAmarillas = rs.getInt(6);
                int paradas = rs.getInt(7);
                int faltas = rs.getInt(8);
                int tarjetasRojas = rs.getInt(9);
                est = new Estadistica(idJugador,partidosJugados,numGoles,distRec,asistencias,tarjetasAmarillas,paradas,faltas,tarjetasRojas);
            }
        } catch (SQLException throwables) {
            System.err.println("SQL Exception: "+throwables.getMessage());
            throwables.printStackTrace();
        }
        return est;
    }

    /**
     * Obtenemos de la base de datos los partidos de la temporada del equipo introducido por parametro
     * @param equipo - main.Equipo del cual queremos obtener sus partidos
     * @return Un List<> de partidos o null si ese equipo no existe
     */
    public List<Partidos> getPartidosDeEquipo(Equipo equipo){
        List<Partidos> listaPartidos = null;

        try {
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM PARTIDOS WHERE EQUIPOLOCAL = ? OR EQUIPOVISITANTE = ?");
            sentencia.setInt(1,equipo.getId());
            sentencia.setInt(2,equipo.getId());
            ResultSet rs = sentencia.executeQuery();
            if(rs.isBeforeFirst()){
                listaPartidos = new ArrayList<>();
                while(rs.next()) {
                    int id = rs.getInt(1);
                    Equipo equipoLocal = getEquipoDeID(rs.getInt(2));
                    Equipo equipoVisitante = getEquipoDeID(rs.getInt(3));
                    String colegiados = rs.getString(4);
                    Date fecha = rs.getDate(5);
                    String resultado = rs.getString(6);
                    listaPartidos.add(new Partidos(id, equipoLocal, equipoVisitante, colegiados, fecha, resultado));
                }
            }
        } catch (SQLException throwables) {
            System.err.println("SQL Exception: "+throwables.getMessage());
            throwables.printStackTrace();
        }
        return listaPartidos;
    }

    /**
     * Obtiene todos los partidos de de todos los equipos de la temporada
     * @return Una {@code List} con todos los partidos de la temporada
     */
    public List<Partidos> getPartidos(){
        List<Partidos> listaPartidos = null;

        try {
            Statement sentencia = connection.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM PARTIDOS");
            if(rs.isBeforeFirst()){
                listaPartidos = new ArrayList<>();
                while(rs.next()) {
                    int id = rs.getInt(1);
                    Equipo equipoLocal = getEquipoDeID(rs.getInt(2));
                    Equipo equipoVisitante = getEquipoDeID(rs.getInt(3));
                    String colegiados = rs.getString(4);
                    Date fecha = rs.getDate(5);
                    String resultado = rs.getString(6);
                    listaPartidos.add(new Partidos(id, equipoLocal, equipoVisitante, colegiados, fecha, resultado));
                }
            }
        } catch (SQLException throwables) {
            System.err.println("SQL Exception: "+throwables.getMessage());
            throwables.printStackTrace();
        }
        return listaPartidos;
    }

    /**
     * Obetener de la base de datos el equipo asociado al id especificado por parametro
     * @param ideq Identificador del equipo que queremos buscar
     * @return Un {@code Equipo} con el equipo con el identificador ideq o {@code null} si ese identificador no esta asociado a ningun equipo
     */
    private Equipo getEquipoDeID(int ideq){
        Equipo equipo = null;

        try {
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM EQUIPOS WHERE ID = ?");
            sentencia.setInt(1,ideq);
            ResultSet rs = sentencia.executeQuery();
            if(rs.isBeforeFirst()){
                rs.next();
                String nombre = rs.getString(2);
                String escudo = rs.getString(3);
                equipo = new Equipo(ideq,nombre,escudo);
            }
        } catch (SQLException throwables) {
            System.err.println("SQL Exception: "+throwables.getMessage());
            throwables.printStackTrace();
        }

        return equipo;
    }
    public SortedMap<String, Integer> getGoleadores(){
        SortedMap<String, Integer> goleadores = null;

        try {
            PreparedStatement sentencia = connection.prepareStatement("SELECT J.NOMBRE, E.NUMGOLES\n" +
                    "FROM JUGADORES J JOIN ESTADISTICAS E ON (J.ID = E.IDJUGADOR)\n" +
                    "WHERE POSICION != 'POR'\n"
                    );
           // sentencia.setInt(1,equipo.getId());
            ResultSet rs = sentencia.executeQuery();
            if(rs.isBeforeFirst()){
                goleadores = new TreeMap<>();
                while(rs.next()) {
                    goleadores.put(rs.getString(1), rs.getInt(2));
                }
            }
        } catch (SQLException throwables) {
            System.err.println("SQL Exception: "+throwables.getMessage());
            throwables.printStackTrace();
        }
        return goleadores;
    }


}
