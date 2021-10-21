package controller;

import java.util.Scanner;

import model.Vagon;

public class MenuReservaTickets extends MenuPadre{

	public MenuReservaTickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuReservaTickets(String[] opciones) {
		super(opciones);
		
	}
	
	
	
	public void menuPerformer(Vagon vagon) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean salir = false;
		
		do {
			
			System.out.println("Reserva para el vagon: "+ vagon.getNombreVagon());
			super.muestraOpciones();
			
			int seleccion = -1;
			seleccion = sc.nextInt();
			
			switch(seleccion) {
				case 1:
					vagon.pideLugar();
					break;
				case 2:
					System.out.println("Plazas disponibles: "+vagon.numLibres());
					break;
				case 3:
					vagon.muestraVagon();
					break;
				case 4:
					System.out.println("Hasta pronto");
					salir = true;
					break;
				
			}
		}while(salir == false);
		
		sc.close();
		
	}
	

}
