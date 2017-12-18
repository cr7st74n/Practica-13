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
import modelo.Jugador;
import modelo.Equipo;
import modelo.FichaInscripcion;

public class GestionDatosFich {
	private List<FichaInscripcion> fichas;
	private List<Equipo> equipos;
	private List<Jugador> jugadores;
private String pathPersona="Datos/Ficha Inscripcion.dat";
	

public GestionDatosFich(List<FichaInscripcion> fichas, List<Equipo> equipos, List<Jugador> jugadores,
		String pathPersona) {
	super();
	this.fichas = fichas;
	this.equipos = equipos;
	this.jugadores = jugadores;
	this.pathPersona = pathPersona;
}


public GestionDatosFich() {
	fichas = new ArrayList<FichaInscripcion>();
	equipos = new ArrayList<Equipo>();
	jugadores = new ArrayList<Jugador>();
}


public void newFicha(String nombreR,String idioma,String titulo,String nombreAu,String apellidoAu) throws IOException {
	
	FichaInscripcion re=new FichaInscripcion();
	re.setCosto(nombreR);
	fichas.add(re);
	
	Equipo au=new Equipo();
    au.setNombre(idioma);
    au.setCapitan(titulo);
    equipos.add(au);
	re.setEquipos(au);
	
	Jugador ar=new Jugador();
	ar.setNombre(nombreAu);
	ar.setApellido(apellidoAu);
	jugadores.add(ar);
	au.setJugadores(ar);	
	
	
	
	try{
		  FileOutputStream file =  new FileOutputStream (pathPersona, true);
		  DataOutputStream escritura = new DataOutputStream (file);

		  escritura.writeUTF(nombreR);
		  escritura.writeUTF(idioma);
		  escritura.writeUTF(titulo);
		  escritura.writeUTF(nombreAu);
		  escritura.writeUTF(apellidoAu+".");
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
public int buscarFicha(String nombreE){
	
	for (int i = 0; i < equipos.size(); i++) {
		Equipo car = equipos.get(i);
		if (car.getNombre().equals(nombreE)) {
					return 0;
		}
	}
	return 1;
}
public String buscarCapitan(String nombreC){
	String h=".";
	for (int i = 0; i < equipos.size(); i++) {
		Equipo car = equipos.get(i);
		if (car.getNombre().equals(nombreC)) {
					 h=null;
		}
	}
	return h;
}

public List<FichaInscripcion> getFichas(){
	return fichas;
	
}
}
