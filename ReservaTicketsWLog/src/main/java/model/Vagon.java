package model;

import java.security.Principal;
import java.util.Scanner;
import view.*;

public class Vagon {

	private final int FILAS = 10;
	private final int COLUMNAS = 4;
	
	private String nombreVagon = "";
	private char[][] vagon = new char[FILAS][COLUMNAS];
	private char simboloOcupado = 'X';
	
	public Vagon() {
		super();
		
		for(int i = 0; i< FILAS; i++) {
			for (int j = 0; j < COLUMNAS ; j++) {
				this.vagon[i][j] = 'L';
			}
		}
	}
	
	//Construye el vagon con sus plazas libres
	public Vagon(String nombreVagon) {
		super();
		
		this.nombreVagon = nombreVagon;
		
		
		for(int i = 0; i< FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				this.vagon[i][j] = 'L';
			}
		}
		
	}
	
	public char[][] getVagon() {
		return vagon;
	}
	public void setVagon(char[][] vagon) {
		this.vagon = vagon;
	}
	public String getNombreVagon() {
		return nombreVagon;
	}
	public void setNombreVagon(String nombreVagon) {
		this.nombreVagon = nombreVagon;
	}
	public char getSimboloOcupado() {
		return simboloOcupado;
	}
	public void setSimboloOcupado(char simboloOcupado) {
		this.simboloOcupado = simboloOcupado;
	}
	
	
	
	//Muestra el estado del vagon
	public void muestraVagon() {
		for(int i = 0; i< FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				System.out.print(this.vagon[i][j]+" ");
			}
			System.out.println();
		}
		view.Principal.logger.info("El usuario muestra el vagón");
	}
	
	
	public boolean asientoLibre(int fila, int columna){
		if(this.vagon[fila][columna] == 'L') {
			view.Principal.logger.info("Se ha introducido unas correctas, asiento libre: "+fila+columna);
			return true;
		}else {
			view.Principal.logger.info("Se ha introducido unas incorrectas, asiento ocupado: "+fila+columna);
			return false;
		}
	}
	
	//Pide un lugar y si est� libre lo reserva
	public void pideLugar() {
		
		int fila,columna;
		Scanner sc = new Scanner(System.in);
		
		//Recoge fila y columna
		do {
				System.out.println("--Elija el asiento que quiere reservar : ");
				System.out.println("Introduce la fila : ");
				fila = sc.nextInt();
				System.out.println("Introduce la columna : ");
				columna = sc.nextInt();
				
			}while(asientoLibre(fila, columna) == false);
		
		//Si la casilla est� libre colocamos el simbolo
		vagon[fila][columna] = simboloOcupado;
		view.Principal.logger.info("Se ha ocupado el asiento: "+fila+columna);
		
		
	}
	
	public int numLibres() {
		int plazasLibres = 0;
		
		for(int i = 0; i< FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				if(vagon[i][j] == 'L') {
					plazasLibres++;
				}
			}
		}
		
		return plazasLibres;
		
	}
	
}
