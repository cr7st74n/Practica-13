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
import modelo.Canton;

import modelo.Competencia;
import modelo.Pais;
import modelo.Provincia;


public class GestionDatosPais {
	private List<Pais> paises;
	private List<Provincia> provincias;
	private List<Canton> cantones;
private String pathPersona="Datos/Pais.dat";

public GestionDatosPais(List<Pais> paises, List<Provincia> provincias, List<Canton> cantones, String pathPersona) {
	super();
	this.paises = paises;
	this.provincias = provincias;
	this.cantones = cantones;
	this.pathPersona = pathPersona;
}

public GestionDatosPais() {
	paises = new ArrayList<Pais>();
	provincias = new ArrayList<Provincia>();
	cantones = new ArrayList<Canton>();
}

public void newPais(String pais,String idioma,String provincia,String canton,String alcalde) throws IOException{
	Pais re=new Pais();
re.setNombre(pais);
	re.setIdoma(idioma);
		
	Provincia ar=new Provincia();
	ar.setNombre(provincia);;
	provincias.add(ar);
    re.setProvincias(ar);

    Canton au=new Canton();
    au.setNombre(canton);
    au.setAlcalde(alcalde);
    cantones.add(au);
	ar.setCanton(au);
	
	paises.add(re);
	
	try{
		  FileOutputStream file =  new FileOutputStream (pathPersona, true);
		  DataOutputStream escritura = new DataOutputStream (file);

		  escritura.writeUTF(pais);
		  escritura.writeUTF(idioma);
		  escritura.writeUTF(provincia);
		  escritura.writeUTF(canton);
		  escritura.writeUTF(alcalde+".");
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


public int buscarProvincia(String nombrep,String nombre,String nombreC) {
int valorC = 0;
for (int i = 0; i < paises.size(); i++) {
	Pais pais = paises.get(i);
	if (pais.getNombre().equals(nombrep)) {
		for (int i1 = 0; i1 < provincias.size(); i1++) {
			Provincia car = provincias.get(i1);
			if (car.getNombre().equals(nombre)) {
				
				return valorC = 0;
		
				}
		}
   }
}

		return valorC=1;
	}

	public String buscarCanton(String nombrep, String nombre, String nombreC) {
		String valorC = "tRue";
		for (int i1 = 0; i1 < paises.size(); i1++) {
			Pais pais = paises.get(i1);
			
					for (int i = 0; i < cantones.size(); i++) {
						Canton canton = cantones.get(i);
						if (canton.getNombre().equals(nombreC)) {
							valorC = null;
						}
					}
		}
		return valorC;

	}

public List<Pais> getPais(){
	return paises;
	
}
}
