package modelo;

public class Pais {
private String nombre;
private String idoma;
private Provincia provincias;

public Pais(){
	
}

public Pais(String nombre, String idoma, Provincia provincias) {
	super();
	this.nombre = nombre;
	this.idoma = idoma;
	this.provincias = provincias;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getIdoma() {
	return idoma;
}

public void setIdoma(String idoma) {
	this.idoma = idoma;
}

public Provincia getProvincias() {
	return provincias;
}

public void setProvincias(Provincia provincias) {
	this.provincias = provincias;
}

@Override
public String toString() {
	return "Pais [nombre=" + nombre + ", idoma=" + idoma + ", provincias=" + provincias + "]";
}



}
