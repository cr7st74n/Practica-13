package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
private String pathPersona="TrabajoGrupal/Datos/Atleta.txt";
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
		
		FileWriter file=new FileWriter(pathPersona,true);
		BufferedWriter out=new BufferedWriter(file);
		String registro=nombreA+" ; "+apellidoA+" ; "+edad+" ; "+numeroCo+" ; "+lugarPos+" | ";
		
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
