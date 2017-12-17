package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
private String pathPersona="TrabajoGrupal/Datos/Pais.txt";

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
		
		FileWriter file=new FileWriter(pathPersona,true);
		BufferedWriter out=new BufferedWriter(file);
		String registro=pais+" ; "+idioma+" ; "+provincia+" ; "+canton+" ; "+alcalde+" | ";
		
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
