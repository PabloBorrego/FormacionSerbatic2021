package controller;

import vista.Vista;

public class ControlMenu {
	
	Vista v = new Vista();

	public ControlMenu() {
		super();
		
	}
	
	public void elegirControl() {
		
		String selec =""; 
		selec = v.menuTabla();
		
		switch(selec) {
		
		case "EMPLEADOS":
				ControladorEmpleado cEmp = new ControladorEmpleado();
					cEmp.accionesDepartameto(selec);
				break;
				
		case "DEPARTAMENTOS": 
				ControladorDepartamento cDep = new ControladorDepartamento();
					cDep.accionesDepartameto(selec);
			break;
		
		}
		
	}

}
