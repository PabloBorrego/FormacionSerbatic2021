package controller;

import Hibernate_Practicas.Practica_Hibernate1.App;
import clasesDAO.EmpleadoDAO;
import services.Servicios;
import vista.Vista;

public class ControladorEmpleado {

	public EmpleadoDAO eDAO = new EmpleadoDAO(App.sesion);
	public Vista vista = new Vista();

	
	
	public ControladorEmpleado() {
		super();
	}



	public void accionesDepartameto(String tabla){
		
		int seleccion = 9;
		
		do {
			seleccion =vista.mostrarMenuConSeleccion(tabla);
		switch (seleccion) {
		
		//Create
			case 1:
				eDAO.create(vista.nuevoEmpleado());
				break;
		//Read	
			case 2: 
				Servicios.CriteriaEmpeladoDepartamentos(vista.seleccionCodigoBuscarDepartamento());
				break;
		//Update
			case 3: 
				eDAO.update(vista.seleccionCodigoBuscarEmpleado());
				break;
		//Delete
			case 4: 
				eDAO.delete(vista.seleccionCodigoBuscarDepartamento());
				break;
			case 0:
				System.out.println("ADIOS");
				break;
				
		}
		}while(seleccion  != 0);
	}
		
}
