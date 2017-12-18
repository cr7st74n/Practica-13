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

import modelo.Articulo;
import modelo.Autor;
import modelo.Pais;
import modelo.Provincia;
import modelo.Revista;

public class GestionDatosRevi {
	private List<Revista> revistas;
	private List<Autor> autores;
	private List<Articulo> articulos;
private String pathPersona="Datos/Revistas.dat";
	

public GestionDatosRevi(List<Revista> revistas, List<Autor> autores, List<Articulo> articulos, String pathPersona) {
	super();
	this.revistas = revistas;
	this.autores = autores;
	this.articulos = articulos;
	this.pathPersona = pathPersona;
}

public GestionDatosRevi() {
	revistas = new ArrayList<Revista>();
	autores = new ArrayList<Autor>();
	articulos = new ArrayList<Articulo>();
}


public void newRevista(String nombreR,String idioma,String titulo,String nombreAu,String apellidoAu) throws IOException{
	Revista re=new Revista();
	re.setNombre(nombreR);
	re.setIdioma(idioma);
	
	
	Articulo ar=new Articulo();
	ar.setTitulo(titulo);
	articulos.add(ar);
    re.setArticulos(ar);

	Autor au=new Autor();
    au.setNombre(nombreAu);
    au.setApellido(apellidoAu);
    autores.add(au);
	ar.setAutores(au);
	
	revistas.add(re);
	
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
public int buscarRevista(String revistaN){
	
	for (int i = 0; i < revistas.size(); i++) {
		Revista car = revistas.get(i);
		if (car.getNombre().equals(revistaN)) {
					return 0;
		}
	}
	return 1;
}
public String buscarArticulo(String nombreAr) {
String valorC="tRue";
		for (int i = 0; i < articulos.size(); i++) {
			Articulo ar = articulos.get(i);
			if (ar.getTitulo().equals(nombreAr)) {
				valorC = null;
			}
		}
		return valorC;
	}
public List<Revista> getRevista(){
	return revistas;
	
}

}