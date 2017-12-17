package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
private String pathPersona="TrabajoGrupal/Datos/Ficha Inscripcion.txt";
	

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


public void newFicha(String nombreR,String idioma,String titulo,String nombreAu,String apellidoAu) {
	
	FichaInscripcion re=new FichaInscripcion();
	re.setCosto(nombreR);
	fichas.add(re);
	
	Equipo au=new Equipo();
    au.setNombre(nombreAu);
    au.setCapitan(titulo);
    equipos.add(au);
	re.setEquipos(au);
	
	Jugador ar=new Jugador();
	ar.setNombre(nombreAu);
	ar.setApellido(apellidoAu);
	jugadores.add(ar);
	au.setJugadores(ar);	
	
	
	
try{
		
		FileWriter file=new FileWriter(pathPersona,true);
		BufferedWriter out=new BufferedWriter(file);
		String registro=nombreR+" ; "+idioma+" ; "+titulo+" ; "+nombreAu+" ; "+apellidoAu+" | ";
		
		out.append(registro);
		out.close();
		file.close();
		
	}catch(IOException e){
		e.printStackTrace();    
	}

}

public String leerArchivos() throws Exception {
	
	FileReader arc = new FileReader(pathPersona);
	BufferedReader lectura = new BufferedReader(arc);
		String linea = "";
		
		while(linea != null) {
			linea = lectura.readLine();
			System.out.println(linea);
			return linea;
		}
		lectura.close();
	
		String dir1 = pathPersona;
		File txt = new File(dir1);
		boolean existencia = txt.exists();
		if (existencia == false) {
			throw new Exception("El archivo no existe");
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
