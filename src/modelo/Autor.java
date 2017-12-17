package modelo;

public class Autor {
private String nombre;
private String apellido;

public  Autor(){
	
}

public Autor(String nombre, String apellido) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

@Override
public String toString() {
	return "Autor [nombre=" + nombre + ", apellido=" + apellido + "]";
}


}
