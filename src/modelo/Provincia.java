package modelo;

public class Provincia {
private String nombre;
private String gobernante;
private Canton canton;

public  Provincia(){
	
}

public Provincia(String nombre, String gobernante, Canton canton) {
	super();
	this.nombre = nombre;
	this.gobernante = gobernante;
	this.canton = canton;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getGobernante() {
	return gobernante;
}

public void setGobernante(String gobernante) {
	this.gobernante = gobernante;
}

public Canton getCanton() {
	return canton;
}

public void setCanton(Canton canton) {
	this.canton = canton;
}

@Override
public String toString() {
	return "Provincia [nombre=" + nombre + ", gobernante=" + gobernante + ", canton=" + canton + "]";
}


}
