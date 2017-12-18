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
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import modelo.Empleado;
import modelo.Empresa;
import modelo.Provincia;
import modelo.Competencia;
import modelo.Departamento;

public class GestionDatosEmpr {
	private List<Empresa> empresas;
	private List<Departamento> departamentos;
	private List<Empleado> empleados;
private String pathPersona="Datos/Empresa.dat";
private int cont;

public GestionDatosEmpr(List<Empresa> empresas, List<Departamento> departamentos, List<Empleado> empleados, String pathPersona) {
	super();
	this.empresas = empresas;
	this.departamentos = departamentos;
	this.empleados = empleados;
	this.pathPersona = pathPersona;
}

public GestionDatosEmpr() {
	empresas = new ArrayList<Empresa>();
	departamentos = new ArrayList<Departamento>();
	empleados = new ArrayList<Empleado>();
}

public void newEmpresa(String nombreE,String presidente,String cajera,String nombreEm,String apellidoEm) throws IOException{
	Empresa re=new Empresa();
    re.setNombre(nombreE);
    re.setPresidente(presidente);
	
		
	Departamento ar=new Departamento();
	ar.setCajera(cajera);
	departamentos.add(ar);
    re.setDepartamentos(ar);

    Empleado au=new Empleado();
    au.setNombre(nombreEm);
    au.setApellido(apellidoEm);
    empleados.add(au);
	ar.setEmpleados(au);
	
	empresas.add(re);
	
	try{
		  FileOutputStream file =  new FileOutputStream (pathPersona, true);
		  DataOutputStream escritura = new DataOutputStream (file);

		  escritura.writeUTF(nombreE);
		  escritura.writeUTF(presidente);
		  escritura.writeUTF(cajera);
		  escritura.writeUTF(nombreEm);
		  escritura.writeUTF(apellidoEm+".");
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
	    	
	    	String nom5=entrada.readUTF();
	    	String nom6=entrada.readUTF();
	    	String nom7=entrada.readUTF();
	    	String nom8=entrada.readUTF();
	    	String nom9=entrada.readUTF();
	    	
	    	System.out.print(nom);
	    	System.out.print(nom1);
	    	System.out.print(nom2);
	    	System.out.print(nom3);
	    	System.out.print(nom4);
	    	
	    	System.out.print(nom5);
	    	System.out.print(nom6);
	    	System.out.print(nom7);
	    	System.out.print(nom8);
	    	System.out.print(nom9);
	    	
//	    	//return entrada.readUTF();
	    	String imp= nom+ " ; "+nom1+" ; "+nom2+" ; "+nom3+" ; "+nom4;
	    	imp.split(";");
	    	String imp1= nom5+ " ; "+nom6+" ; "+nom7+" ; "+nom8+" ; "+nom9;
	    	return imp+"\n"+imp1;
	   }
	}catch(Exception e1){
	    e1.printStackTrace();
	}finally{
	    entrada.close();
	}

	return null;
}
public int buscarEmpresa(String nombreEm){
	
	for (int i = 0; i < empresas.size(); i++) {
		Empresa car = empresas.get(i);
		Departamento dep = departamentos.get(i);
		if (car.getNombre().equals(nombreEm)) {
			
					return 0;
	}
	}
	return 1;
}
public String buscarEmpleado(String nombre,String apellido) {
String valorC="tRue";
		for (int i = 0; i < empleados.size(); i++) {
			Empleado car = empleados.get(i);
			if (car.getNombre().equals(nombre)&&car.getApellido().equals(apellido)) {
				valorC = null;
			}
		}
		return valorC;
	}

public List<Empresa> getEmpresas(){
	return empresas;
	
}
}
