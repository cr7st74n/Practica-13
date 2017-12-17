package modelo;

public class Empresa {
private String nombre;
private String ruc;
private String presidente;
private Departamento departamentos;

public Empresa(){
	
}

public Empresa(String nombre, String ruc, String presidente, Departamento departamentos) {
	super();
	this.nombre = nombre;
	this.ruc = ruc;
	this.presidente = presidente;
	this.departamentos = departamentos;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getRuc() {
	return ruc;
}

public void setRuc(String ruc) {
	this.ruc = ruc;
}

public String getPresidente() {
	return presidente;
}

public void setPresidente(String presidente) {
	this.presidente = presidente;
}

public Departamento getDepartamentos() {
	return departamentos;
}

public void setDepartamentos(Departamento departamentos) {
	this.departamentos = departamentos;
}

@Override
public String toString() {
	return "Empresa [nombre=" + nombre + ", ruc=" + ruc + ", presidente=" + presidente + ", departamentos="
			+ departamentos + "]";
}


}
