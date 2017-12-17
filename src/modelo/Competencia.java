package modelo;

public class Competencia {
private String numero; 
private String juez;
private Resultado resultados;

public Competencia(){
	
}

public Competencia(String numero, String juez, Resultado resultados) {
	super();
	this.numero = numero;
	this.juez = juez;
	this.resultados = resultados;
}

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
	this.numero = numero;
}

public String getJuez() {
	return juez;
}

public void setJuez(String juez) {
	this.juez = juez;
}

public Resultado getResultados() {
	return resultados;
}

public void setResultados(Resultado resultados) {
	this.resultados = resultados;
}

@Override
public String toString() {
	return "Competencia [numero=" + numero + ", juez=" + juez + ", resultados=" + resultados + "]";
}


}
