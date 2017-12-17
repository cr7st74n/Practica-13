package modelo;

public class Revista {
private String numeroE;
private String tema;
private String idioma;
private String nombre;
private Articulo articulos;

public  Revista(){
	
}

public Revista(String numeroE, String tema, String idioma, String nombre, Articulo articulos) {
	super();
	this.numeroE = numeroE;
	this.tema = tema;
	this.idioma = idioma;
	this.nombre = nombre;
	this.articulos = articulos;
}

public String getNumeroE() {
	return numeroE;
}

public void setNumeroE(String numeroE) {
	this.numeroE = numeroE;
}

public String getTema() {
	return tema;
}

public void setTema(String tema) {
	this.tema = tema;
}

public String getIdioma() {
	return idioma;
}

public void setIdioma(String idioma) {
	this.idioma = idioma;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Articulo getArticulos() {
	return articulos;
}

public void setArticulos(Articulo articulos) {
	this.articulos = articulos;
}

@Override
public String toString() {
	return "Revista [numeroE=" + numeroE + ", tema=" + tema + ", idioma=" + idioma + ", nombre=" + nombre
			+ ", articulos=" + articulos + "]";
}



}
