package controller;

import Hibernate_Practicas.Practica_Hibernate1.App;
import clasesDAO.DepartamentoDAO;
import services.Servicios;
import vista.Vista;

public class ControladorDepartamento {
	
	public DepartamentoDAO dDAO = new DepartamentoDAO(App.sesion);
	public Vista vista = new Vista();
	
	
	
	public ControladorDepartamento() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void accionesDepartameto(String tabla){
		
		
		int seleccion = 9;
		
		do {
			seleccion = vista.mostrarMenuConSeleccion(tabla);
		switch (seleccion) {
		
		//Create
			case 1:
				dDAO.create(vista.nuevoDepartamento());
				break;
		//Read	
			case 2: 
				Servicios.CriteriaEmpeladoDepartamentos(vista.seleccionCodigoBuscarDepartamento());
				break;
		//Update
			case 3: 
				dDAO.update(vista.seleccionCodigoBuscarDepartamento());
				break;
		//Delete
			case 4: 
				dDAO.delete(vista.seleccionCodigoBuscarDepartamento());
				break;
		//CriteriaQuery buscar emp por cod_Departamento
			case 5: 
				Servicios.CriteriaEmpeladoDepartamentos(vista.seleccionCodigoBuscarDepartamento());
				break;
			case 0:
				System.out.println("ADIOS");
				break;
				
		}
		}while(seleccion  != 0);
		
	}
	
}
