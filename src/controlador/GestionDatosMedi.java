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

import modelo.Paciente;
import modelo.Medico;
import modelo.Consulta;
import modelo.Consulta;

public class GestionDatosMedi {
	private List<Medico> medicos;
	private List<Consulta> consultas;
	private List<Paciente> pacientes;
private String pathPersona="Datos/Medico.dat";

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
		  FileOutputStream file =  new FileOutputStream (pathPersona, true);
		  DataOutputStream escritura = new DataOutputStream (file);

		  escritura.writeUTF(nombreMed);
		  escritura.writeUTF(turno);
		  escritura.writeUTF(hora);
		  escritura.writeUTF(nombrePa);
		  escritura.writeUTF(apellidoPa+".");
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
