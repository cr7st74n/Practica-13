package modelo;

public class Articulo {
private String titulo;
private String numeroP;
private Autor autores;

public  Articulo(){
	
}

public Articulo(String titulo, String numeroP, Autor autores) {
	super();
	this.titulo = titulo;
	this.numeroP = numeroP;
	this.autores = autores;
}


public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getNumeroP() {
	return numeroP;
}

public void setNumeroP(String numeroP) {
	this.numeroP = numeroP;
}

public Autor getAutores() {
	return autores;
}

public void setAutores(Autor autores) {
	this.autores = autores;
}


@Override
public String toString() {
	return "Articulo [titulo=" + titulo + ", numeroP=" + numeroP + ", autores=" + autores + "]";
}



}
