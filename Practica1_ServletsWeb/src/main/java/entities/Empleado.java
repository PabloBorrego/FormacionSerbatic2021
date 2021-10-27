package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "codigo")
	private int codEmpleado;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido1", nullable = false)
	private String primerApellido;
	
	@Column(name = "apellido2", nullable = false)
	private String segundoApellido;
	
	@Column(name = "lugar_nacimiento")
	private String lugarNacimiento;
	
	@Column(name = "fecha_nacimiento")
	private char fecha;
	
	@Column(name = "direccion")
	private String direccion;
  
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "cod_departamento")
	private int codDepartamento;

	public Empleado(int codEmpleado, String nombre, String primerApellido, String segundoApellido,
			String lugarNacimiento, char fecha, String direccion, String telefono, int codDepartamento) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.lugarNacimiento = lugarNacimiento;
		this.fecha = fecha;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codDepartamento = codDepartamento;
	}
	
	

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public char getFecha() {
		return fecha;
	}

	public void setFecha(char fecha) {
		this.fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	@Override
	public String toString() {
		return "Empleado [codEmpleado=" + codEmpleado + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", lugarNacimiento=" + lugarNacimiento + ", fecha=" + fecha
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", codDepartamento=" + codDepartamento + "]";
	}
	
	
	
	

}
