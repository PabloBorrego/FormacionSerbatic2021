package vista;

import java.util.Scanner;

import entities.Departamento;
import entities.Empleado;

public class Vista {
	Scanner sc = new Scanner(System.in);
	
	
	public String menuTabla(){
		
		
		String tEmp = "EMPLEADOS";
		String tDep = "DEPARTAMENTOS";
		int selec = 0;
		System.out.println("Introduce sobre que tabla quieres hacer operaciones:");
		System.out.println("1-Empleados");
		System.out.println("2-Departamentos");
		
		selec = sc.nextInt();
		
		if(selec == 1) {
			return tEmp;
		}else {
			if(selec == 2)
				return tDep;
		}
		
		return null;
	}
	
	public int mostrarMenuConSeleccion(String tabla) {
		
		System.out.println("**-"+tabla+"-**");
		System.out.println("1-Create");
		System.out.println("2-Read");
		System.out.println("3-Update");
		System.out.println("4-Delete");
		System.out.println("0-Salir");
		int seleccion = sc.nextInt();
		return seleccion;
		
	}
	

	public Empleado nuevoEmpleado () {
		System.out.println("Codigo Empleado:");
		int codigo = sc.nextInt();
		Empleado e = new Empleado(codigo,"X","X","Y","ZAmora",'c',"x","tlf",9);
		return e;
	}
	
	public Departamento nuevoDepartamento () {
		System.out.println("Codigo Departamento:");
		int codigo = sc.nextInt();
		Departamento d = new Departamento(codigo,"NuevoDep",0);
		return d;
	}
	
	public int seleccionCodigoBuscarEmpleado() {
		System.out.println("Codigo de Empleado:");
		int codigo = sc.nextInt();
		return codigo;
	
	}
	
	public int seleccionCodigoBuscarDepartamento() {
		System.out.println("Codigo de Departamento:");
		int codigo = sc.nextInt();
		return codigo;
		
	}
	
	
	
	
	
}
