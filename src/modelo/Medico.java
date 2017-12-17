package modelo;

public class Medico {
	private String nombre;
	private String apellido;
	private Consulta consultas;
	
	public  Medico (){
		
	}

	public Medico(String nombre, String apellido, Consulta consultas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.consultas = consultas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Consulta getConsultas() {
		return consultas;
	}

	public void setConsultas(Consulta consultas) {
		this.consultas = consultas;
	}

	@Override
	public String toString() {
		return "Medico [nombre=" + nombre + ", apellido=" + apellido + ", consultas=" + consultas + "]";
	}
	
	
}
