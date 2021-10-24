package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "codigo")
	private int codDepartamento;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "cod_responsable")
	private int codResponsable;

	public Departamento(int codDepartamento, String nombre, int codResponsable) {
		super();
		this.codDepartamento = codDepartamento;
		this.nombre = nombre;
		this.codResponsable = codResponsable;
	}

	public int getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodResponsable() {
		return codResponsable;
	}

	public void setCodResponsable(int codResponsable) {
		this.codResponsable = codResponsable;
	}
	
	
}
