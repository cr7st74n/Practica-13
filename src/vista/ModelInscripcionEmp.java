package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;


import modelo.Empresa;

public class ModelInscripcionEmp extends AbstractTableModel {
	

	
	public String[] columnas = {"Nombre Empresa", "Presidente Empresa","Nombre cajera","Nombre trabajador","Apellido trabajador"};
	public Class[] columnasTipos = {String.class, String.class,String.class,String.class,String.class};
	
	private List<Empresa> datos;
	
	public ModelInscripcionEmp() {
		super();
		datos = new ArrayList<Empresa>();
	}
	
	public ModelInscripcionEmp(List<Empresa> datos) {
		super();
		if (datos == null)
			this.datos = new ArrayList<Empresa>();
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
		
		Empresa dato = (Empresa) (datos.get(row));
		
		switch(col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getPresidente();
		case 2:
			return dato.getDepartamentos().getCajera();
		case 3:
			return dato.getDepartamentos().getEmpleados().getNombre();
		case 4:
			return dato.getDepartamentos().getEmpleados().getApellido();
		default:
			break;
		}
		return new String();
	}

	
}
