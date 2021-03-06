package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Competencia;
import modelo.Resultado;
import modelo.Atleta;

public class GestionDatosAtle {
	private List<Atleta> atletas;
	private List<Competencia> competencias;
	private List<Resultado> resultados;
private String pathPersona="Datos/Atleta.dat";
//estamos ajsja
public GestionDatosAtle(List<Atleta> atletas, List<Competencia> competencias, List<Resultado> resultados, String pathPersona) {
	super();
	this.atletas = atletas;
	this.competencias = competencias;
	this.resultados = resultados;
	this.pathPersona = pathPersona;
}

public GestionDatosAtle() {
	atletas = new ArrayList<Atleta>();
	competencias = new ArrayList<Competencia>();
	resultados = new ArrayList<Resultado>();
}

public void newAtleta(String nombreA,String apellidoA,String edad,String numeroCo,String lugarPos) throws IOException{
	Atleta re=new Atleta();
   re.setNombre(nombreA);
   re.setApellido(apellidoA);
	re.setEdad(edad);
		
	Competencia ar=new Competencia();
	ar.setNumero(numeroCo);
	competencias.add(ar);
    re.setCompetencias(ar);

    Resultado au=new Resultado();
  au.setPrimerLug(lugarPos);
    resultados.add(au);
	ar.setResultados(au);
	
	atletas.add(re);
	
	try{
		  FileOutputStream file =  new FileOutputStream (pathPersona, true);
		  DataOutputStream escritura = new DataOutputStream (file);

		  escritura.writeUTF(nombreA);
		  escritura.writeUTF(apellidoA);
		  escritura.writeUTF(edad);
		  escritura.writeUTF(numeroCo);
		  escritura.writeUTF(lugarPos+".");
		  escritura.close();
		}catch(FileNotFoundException e){
		  e.printStackTrace();
		}

}

public String leerArchivos() throws Exception {
	
	FileInputStream archivoLectura=null;
	DataInputStream entrada=null;
	try{
	    String ruta=pathPersona;
	    archivoLectura=new FileInputStream(ruta);
	    entrada = new DataInputStream(archivoLectura);
	    

	    while(true){
	    	
	    	String nom=entrada.readUTF();
	    	String nom1=entrada.readUTF();
	    	String nom2=entrada.readUTF();
	    	String nom3=entrada.readUTF();
	    	String nom4=entrada.readUTF();

	    	
	    	System.out.print(nom);
	    	System.out.print(nom1);
	    	System.out.print(nom2);
	    	System.out.print(nom3);
	    	System.out.print(nom4);
	    	
	    	String imp= nom+ " ; "+nom1+" ; "+nom2+" ; "+nom3+" ; "+nom4;
	    	imp.split(";");
	    	
	    	return imp;
	   }
	}catch(Exception e1){
	    e1.printStackTrace();
	}finally{
	    entrada.close();
	}
	
	return null;
}
public int buscarAtleta(String numeroJug){
	
		for (int i = 0; i < competencias.size(); i++) {
			Competencia car = competencias.get(i);
			if (car.getNumero().equals(numeroJug)) {
						return 0;
			}
		}
		return 1;
}
public List<Atleta> getAtletas(){
	return atletas;
	
}
}
