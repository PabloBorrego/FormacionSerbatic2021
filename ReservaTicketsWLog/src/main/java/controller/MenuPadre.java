package controller;

public class MenuPadre {
	
	public String[] opciones;
	
	
	public MenuPadre( String[] opciones) {
		super();
		this.opciones = opciones;
	}
	
	public MenuPadre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void muestraOpciones() {
		
		for (int i = 0; i < opciones.length; i++) {
			System.out.println(i+1+"-: "+opciones[i]);
		}
		
		
	}
	

}
