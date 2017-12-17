package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
private String pathPersona="TrabajoGrupal/Datos/Revistas.txt";
	

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