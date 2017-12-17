package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.FichaInscripcion;


public class ModelInscripcionFich extends AbstractTableModel {
	

	
	public String[] columnas = {"Costo", "Nombre Equipo","Nombre Capitan ","Nombre Jugador","Apellido Jugador"};
	public Class[] columnasTipos = {String.class, String.class,String.class,String.class,String.class};
	
	private List<FichaInscripcion> datosFicha;
	
	public ModelInscripcionFich() {
		super();
		datosFicha = new ArrayList<FichaInscripcion>();
	}
	
	public ModelInscripcionFich(List<FichaInscripcion> datos) {
		super();
		if (datos == null)
			this.datosFicha = new ArrayList<FichaInscripcion>();
		else
			this.datosFicha = datos;
	}
	
	public int getColumnCount() {
		return columnas.length;
	}

	
	public int getRowCount() {
		return datosFicha.size();
	}

	public String getColumnName(int col) {
		return columnas[col];
	}
	
	public Class getColumnClass(int col) {
		return columnasTipos[col];
	}
	
	public Object getValueAt(int row, int col) {
		
		FichaInscripcion datof = (FichaInscripcion) (datosFicha.get(row));
		
		switch(col) {
		case 0:
			return datof.getCosto();
		case 1:
			return datof.getEquipos().getNombre();
		case 2:
			return datof.getEquipos().getCapitan();
		case 3:
			return datof.getEquipos().getJugadores().getNombre();
		case 4:
			return datof.getEquipos().getJugadores().getApellido();
		default:
			break;
		}
		return new String();
	}

	
}
