package modelo;

public class Equipo {
private String nombre;
private String capitan;
private Jugador jugadores;

public  Equipo () {
	
}

public Equipo(String nombre, String capitan, Jugador jugadores) {
	super();
	this.nombre = nombre;
	this.capitan = capitan;
	this.jugadores = jugadores;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCapitan() {
	return capitan;
}
public void setCapitan(String capitan) {
	this.capitan = capitan;
}
public Jugador getJugadores() {
	return jugadores;
}
public void setJugadores(Jugador jugadores) {
	this.jugadores = jugadores;
}

@Override
public String toString() {
	return "Equipo [nombre=" + nombre + ", capitan=" + capitan + ", jugadores=" + jugadores + "]";
}


}
