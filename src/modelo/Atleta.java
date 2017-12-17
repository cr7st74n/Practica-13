package modelo;

public class Atleta {
private String nombre;
private String apellido;
private String edad;
private Competencia competencias;

public  Atleta(){
	
}

public Atleta(String nombre, String apellido, String edad, Competencia competencias) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.edad = edad;
	this.competencias = competencias;
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

public String getEdad() {
	return edad;
}

public void setEdad(String edad) {
	this.edad = edad;
}

public Competencia getCompetencias() {
	return competencias;
}

public void setCompetencias(Competencia competencias) {
	this.competencias = competencias;
}

@Override
public String toString() {
	return "Atleta [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", competencias=" + competencias
			+ "]";
}



}
