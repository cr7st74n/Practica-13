package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;


import modelo.Medico;

public class ModelInscripcionMed extends AbstractTableModel {
	

	
	public String[] columnas = {"Nombre Medico", "Numero Turno","Hora Turno","Nombre Paciente","Edad "};
	public Class[] columnasTipos = {String.class, String.class,String.class,String.class,String.class};
	
	private List<Medico> datos;
	
	public ModelInscripcionMed() {
		super();
		datos = new ArrayList<Medico>();
	}
	
	public ModelInscripcionMed(List<Medico> datos) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Medico>();
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
		
		Medico dato = (Medico) (datos.get(row));
		
		switch(col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getConsultas().getNumeroTur();
		case 2:
			return dato.getConsultas().getHora();
		case 3:
			return dato.getConsultas().getPacientes().getNombre();
		case 4:
			return  dato.getConsultas().getPacientes().getEdad();
		default:
			break;
		}
		return new String();
	}

	
}
