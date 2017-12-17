package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;


import modelo.Revista;

public class ModelInscripcionRe extends AbstractTableModel {
	

	
	public String[] columnas = {"Nombre Revista", "Idioma","Titulo articulo","Nombre autor","Apellido autor"};
	public Class[] columnasTipos = {String.class, String.class,String.class,String.class,String.class};
	
	private List<Revista> datos;
	
	public ModelInscripcionRe() {
		super();
		datos = new ArrayList<Revista>();
	}
	
	public ModelInscripcionRe(List<Revista> datos) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Revista>();
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
		
		Revista dato = (Revista) (datos.get(row));
		
		switch(col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getIdioma();
		case 2:
			return dato.getArticulos().getTitulo();
		case 3:
			return dato.getArticulos().getAutores().getNombre();
		case 4:
			return dato.getArticulos().getAutores().getApellido();
		default:
			break;
		}
		return new String();
	}

	
}
