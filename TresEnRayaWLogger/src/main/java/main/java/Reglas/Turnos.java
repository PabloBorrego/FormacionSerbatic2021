package main.java.Reglas;

import java.util.Scanner;

import main.java.Tablero.Tablero;
import main.java.Vista.principal;

public class Turnos {
	
	char simboloj1 = 'X';
	char simboloj2 = 'O';
	Scanner sc = new Scanner(System.in);

	public Turnos() {
		super();
	}
	
	public char getSimboloj1() {
		return simboloj1;
	}
	public void setSimboloj1(char simboloj1) {
		this.simboloj1 = simboloj1;
	}
	public char getSimboloj2() {
		return simboloj2;
	}
	public void setSimboloj2(char simboloj2) {
		this.simboloj2 = simboloj2;
	}

	
	//M�todo que acciona un turno de cada jugador
	public boolean turno (char simbolo,Tablero tab) {
		principal.logger.info("Turno del jugador :"+ simbolo);
		int fila = 0; 
		int columna = 0;
		
		//Se comprueba si hay empate antes de introducir la siguiente
			if(hayEmpate(tab)) {
				
				return true;
			}
		
			pideLugar(tab,fila, columna, simbolo);

			//Se comprueba si hay victoria o empate.
			if(hayVictoria(tab, simbolo) == true) {
				principal.logger.info("Victoria del jugador: "+simbolo);
				return true;
				}else {
					if(hayEmpate(tab) == true) {
						return true;
					}
				}
			
			tab.muestraTablero();
			//Si no hay ni victoria ni empate se sigue jugando
				return false;
			}
	
		
		
	
	
	public void pideLugar(Tablero tab, int fila, int columna, char simbolo) {
		
		//Recoge fila y columna
		do {
				System.out.println("--Turno del jugador con "+ simbolo+"--");
				System.out.println("Introduce la fila : ");
				fila = sc.nextInt();
				System.out.println("Introduce la columna : ");
				columna = sc.nextInt();
				
			}while(tab.casillaLibre(fila, columna) == false);
		
		//Si la casilla est� libre colocamos el simbolo
		tab.getTablero()[fila][columna] = simbolo;
		principal.logger.info("Se ha colocado un simbolo "+simbolo+" en la casilla con coordenadas"+fila+" "+columna);
	}
	
	//Comprueba si alguno de los jugadores ha hecho 3 en raya
	public boolean hayVictoria(Tablero tab, char simbolo){
		
		if(coincideVertical(tab,simbolo) == true) {
			return true;
		}else {
			if(coincideHorizontal(tab,simbolo) == true){
				principal.logger.info("Victoria por linea Horizontal de "+simbolo);
				return true;
			}else {
				//System.err.println("pasa al descendente");
				if(coincideDiagonalDescendente(tab,simbolo) == true){
					principal.logger.info("Victoria por linea diagonal descendente de "+simbolo);
					return true;
				}else {
					//System.err.println("pasa al ascendente");
					if(coincideDiagonalAscendente(tab,simbolo) == true){
						principal.logger.info("Victoria por linea diagonal ascendente de "+simbolo);
						return true;
					}else {			
						return false;
					}
				}
				
			}
		}
	}
	
	
	public boolean hayEmpate(Tablero tab) {
		
		for(int i = 0; i< tab.getTablero().length; i++) {
			for (int j = 0; j < tab.getTablero().length; j++) {
				if(tab.getTablero()[i][j] == '-') {
					return false;
				}
			}
		}
		
		System.out.println("��TABLAS!!");
		principal.logger.info("La partida resultó en empate");
		return true;
		
	}
	
	
	//Comprueba si coinciden en horizontal
	public boolean coincideHorizontal(Tablero tab, char simbolo) {
		
		int coincide = 0;
		
		for(int i = 0; i< tab.getTablero().length; i++) {
			for (int j = 0; j < tab.getTablero().length; j++) {
				
				//Si el simbolo en las �ltimas tres iteraciones no cambia gana
				if(tab.getTablero()[i][j] == simbolo) {
					coincide++;
				}
				
				//Si el s�mbolo coincide tres veces en la misma fila es verdadero y ha ganado
				if(coincide == 3) {	
					System.out.println("Gana el jugador :"+ simbolo+"--");
					return true;
				}	
			}
			coincide = 0;
		}
	
		//Si no lo ha conseguido y ha llegado al final del bucle no ha ganado nadie
		return false;
	}
	
	
	//Comprueba si coinciden en vertical
	public boolean coincideVertical(Tablero tab, char simbolo) {

		int coincide = 0;
		
		for(int i = 0; i< tab.getTablero().length; i++) {
			for (int j = 0; j < tab.getTablero().length; j++) {
				
				if(tab.getTablero()[j][i] == simbolo) {
					coincide++;
				}
				if(coincide == 3) {	
					System.out.println("Gana el jugador :"+ simbolo+"--");
					return true;
				}	
			}
			coincide = 0;
		}
	
		//Si no lo ha conseguido y ha llegado al final del bucle no ha ganado nadie
		
		return false;
	}
	
	
	//Comprueba si coinciden en diagonal descendente
	public boolean coincideDiagonalDescendente(Tablero tab, char simbolo) {
		
		int coincide = 0;
		for(int i = 0; i< tab.getTablero().length; i++) {
			
				
				if(tab.getTablero()[i][i] == simbolo) {
					coincide++;
				}
				if(coincide == 3) {	
					System.out.println("GANA EL JUGADOR :"+ simbolo+"--");
					return true;
				}	
		}
		return false;
	}
	
	
	//Comprueba si coinciden en diagonal ascendente ERROR-- No entra en el bucle
	public boolean coincideDiagonalAscendente(Tablero tab, char simbolo) {
		
		int coincide = 0;
		for(int i = tab.getTablero().length, j = 0; i<0; i--,j++) {
			
				if(tab.getTablero()[i][j] == simbolo) {
					coincide++;
				}
				if(coincide == 3) {	
					System.out.println("GANA EL JUGADOR :"+ simbolo+"--");
					return true;
				}
		}
		
		return false;
	}
	

	
}
