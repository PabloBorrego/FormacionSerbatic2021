package main.java.Tablero;

public class Tablero {
	
	private char[][] tablero = new char[3][3];

	
	
	//Rellena el tablero con huecos vacíos
	public Tablero() {
		
		for(int i = 0; i< tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				this.tablero[i][j] = '-';
			}
		}
	}

	//G&S
	public char[][] getTablero() {
		return tablero;
	}
	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}




	//Muestra el estado del tablero
	public void muestraTablero() {
		for(int i = 0; i< tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(this.tablero[i][j]+" ");
			}
			
			System.out.println();
		}
		
	}
	
	
	public boolean casillaLibre(int fila, int columna){
		if(this.tablero[fila][columna] == '-') {
			return true;
			
		}else {
			return false;
		}
	}
	
	
	
}
