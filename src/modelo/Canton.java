package modelo;

public class Canton {
private String nombre;
private String alcalde;

public Canton (){
	
}

public Canton(String nombre, String alcalde) {
	super();
	this.nombre = nombre;
	this.alcalde = alcalde;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getAlcalde() {
	return alcalde;
}

public void setAlcalde(String alcalde) {
	this.alcalde = alcalde;
}

@Override
public String toString() {
	return "Canton [nombre=" + nombre + ", alcalde=" + alcalde + "]";
}


}
