package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Paciente;
import modelo.Medico;
import modelo.Consulta;
import modelo.Consulta;

public class GestionDatosMedi {
	private List<Medico> medicos;
	private List<Consulta> consultas;
	private List<Paciente> pacientes;
private String pathPersona="TrabajoGrupal/Datos/Medico.txt";

public GestionDatosMedi(List<Medico> medicos, List<Consulta> consultas, List<Paciente> pacientes, String pathPersona) {
	super();
	this.medicos = medicos;
	this.consultas = consultas;
	this.pacientes = pacientes;
	this.pathPersona = pathPersona;
}

public GestionDatosMedi() {
	medicos = new ArrayList<Medico>();
	consultas = new ArrayList<Consulta>();
	pacientes = new ArrayList<Paciente>();
}

public void newMedico(String nombreMed,String turno,String hora,String nombrePa,String apellidoPa) throws IOException{
	Medico re=new Medico();
    re.setNombre(nombreMed);
		
	Consulta ar=new Consulta();
	ar.setNumeroTur(turno);
	ar.setHora(hora);
	consultas.add(ar);
	re.setConsultas(ar);

    Paciente au=new Paciente();
  au.setNombre(nombrePa);
  au.setEdad(apellidoPa);
    pacientes.add(au);
	ar.setPacientes(au);
	
	medicos.add(re);
	
try{
		
		FileWriter file=new FileWriter(pathPersona,true);
		BufferedWriter out=new BufferedWriter(file);
		String registro=nombreMed+" ; "+turno+" ; "+hora+" ; "+nombrePa+" ; "+apellidoPa+" | ";
		
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

public List<Medico> getMedicos(){
	return medicos;
	
}
public int buscarConsulta(String numeroTurn,String hora){
	
	for (int i = 0; i < consultas.size(); i++) {
		Consulta car = consultas.get(i);
		if (car.getNumeroTur().equals(numeroTurn) || car.getHora().equals(hora)) {
			
					return 0;
		}
	}
	return 1;
}
public String buscarPaciente(String nombreP){
	String g =" ";
	for (int i = 0; i < pacientes.size(); i++) {
		Paciente car = pacientes.get(i);
		if (car.getNombre().equals(nombreP)) {
			
				g= null;
		}
	}
	return g;
}
}
