package modelo;

public class Resultado {
private String primerLug;
private String segundoLug;

public Resultado(){
	
}

public Resultado(String primerLug, String segundoLug) {
	super();
	this.primerLug = primerLug;
	this.segundoLug = segundoLug;
}

public String getPrimerLug() {
	return primerLug;
}

public void setPrimerLug(String primerLug) {
	this.primerLug = primerLug;
}

public String getSegundoLug() {
	return segundoLug;
}

public void setSegundoLug(String segundoLug) {
	this.segundoLug = segundoLug;
}

@Override
public String toString() {
	return "Resultado [primerLug=" + primerLug + ", segundoLug=" + segundoLug + "]";
}



}
