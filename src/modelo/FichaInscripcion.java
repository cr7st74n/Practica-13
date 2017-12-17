package modelo;

public class FichaInscripcion {
private String costo;
private String fecha;
private Equipo equipos;

public FichaInscripcion(){
	
}

public FichaInscripcion(String costo, String fecha, Equipo equipos) {
	super();
	this.costo = costo;
	this.fecha = fecha;
	this.equipos = equipos;
}

public String getCosto() {
	return costo;
}

public void setCosto(String costo) {
	this.costo = costo;
}

public String getFecha() {
	return fecha;
}

public void setFecha(String fecha) {
	this.fecha = fecha;
}

public Equipo getEquipos() {
	return equipos;
}

public void setEquipos(Equipo equipos) {
	this.equipos = equipos;
}

@Override
public String toString() {
	return "FichaInscripcion [costo=" + costo + ", fecha=" + fecha + ", equipos=" + equipos + "]";
}


}
