package modelo;

public class Departamento {
 private String cajera;
 private String secretaria;
 private Empleado empleados;
 
 public Departamento (){
	 
 }

public Departamento(String cajera, String secretaria, Empleado empleados) {
	super();
	this.cajera = cajera;
	this.secretaria = secretaria;
	this.empleados = empleados;
}

public String getCajera() {
	return cajera;
}

public void setCajera(String cajera) {
	this.cajera = cajera;
}

public String getSecretaria() {
	return secretaria;
}

public void setSecretaria(String secretaria) {
	this.secretaria = secretaria;
}

public Empleado getEmpleados() {
	return empleados;
}

public void setEmpleados(Empleado empleados) {
	this.empleados = empleados;
}

@Override
public String toString() {
	return "Departamento [cajera=" + cajera + ", secretaria=" + secretaria + ", empleados=" + empleados + "]";
}
 

}
