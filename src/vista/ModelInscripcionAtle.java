package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;


import modelo.Atleta;

public class ModelInscripcionAtle extends AbstractTableModel {
	

	
	public String[] columnas = {"Nombre Atleta", "Apellido Atleta","edad ","Numero Competencia","Resultado"};
	public Class[] columnasTipos = {String.class, String.class,String.class,String.class,String.class};
	
	private List<Atleta> datos;
	
	public ModelInscripcionAtle() {
		super();
		datos = new ArrayList<Atleta>();
	}
	
	public ModelInscripcionAtle(List<Atleta> datos) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Atleta>();
		else
			this.datos = datos;
	}
	
	public int getColumnCount() {
		return columnas.length;
	}

	
	public int getRowCount() {
		return datos.size();
	}

	public String getColumnName(int col) {
		return columnas[col];
	}
	
	public Class getColumnClass(int col) {
		return columnasTipos[col];
	}
	
	public Object getValueAt(int row, int col) {
		
		Atleta dato = (Atleta) (datos.get(row));
		
		switch(col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getApellido();
		case 2:
			return dato.getEdad();
		case 3:
			return dato.getCompetencias().getNumero();
		case 4:
			return dato.getCompetencias().getResultados().getPrimerLug();
		default:
			break;
		}
		return new String();
	}

	
}
