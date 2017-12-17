package modelo;

public class Consulta {
private String numeroTur;
private String hora;
private String fecha;
private Paciente pacientes;

public  Consulta (){
	
}

public Consulta(String numeroTur, String hora, String fecha, Paciente pacientes) {
	super();
	this.numeroTur = numeroTur;
	this.hora = hora;
	this.fecha = fecha;
	this.pacientes = pacientes;
}

public String getNumeroTur() {
	return numeroTur;
}

public void setNumeroTur(String numeroTur) {
	this.numeroTur = numeroTur;
}

public String getHora() {
	return hora;
}

public void setHora(String hora) {
	this.hora = hora;
}

public String getFecha() {
	return fecha;
}

public void setFecha(String fecha) {
	this.fecha = fecha;
}

public Paciente getPacientes() {
	return pacientes;
}

public void setPacientes(Paciente pacientes) {
	this.pacientes = pacientes;
}

@Override
public String toString() {
	return "Consulta [numeroTur=" + numeroTur + ", hora=" + hora + ", fecha=" + fecha + ", pacientes=" + pacientes
			+ "]";
}


}
