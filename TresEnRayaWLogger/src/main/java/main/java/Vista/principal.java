package main.java.Vista;

import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import main.java.Reglas.Turnos;
import main.java.Tablero.Tablero;

public class principal {
	
	public static Logger logger = LogManager.getLogger(principal.class);
	
	public static void main(String[]args) {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);
		System.out.println("Mensaje de texto");
		logger.info("Este es el fichero de configuración: " + url);
		logger.warn("Esto es un aviso");
		
		
		boolean finPartida = false;
		
		Tablero tab = new Tablero();
		tab.muestraTablero();
		Turnos turnos = new Turnos();
		
		while(finPartida != true) {
				finPartida = turnos.turno(turnos.getSimboloj1(), tab);
				finPartida = turnos.turno(turnos.getSimboloj2(), tab);
			}
		System.out.println("Fin de la partida");
		}
			
			
		
		
		
	

}
