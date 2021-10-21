package view;

import java.io.IOException;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import controller.MenuReservaTickets;
import model.Vagon;

public class Principal {

	public static Logger logger = LogManager.getLogger(Principal.class);
	
	public static void main(String[]args) throws IOException {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);
		System.out.println("Hola mundou");
		logger.info("Este es el fichero de configuración: " + url);
		logger.warn("Esto es un aviso");
		
		String[] opciones = {"Reserva de tickets","Plazas disponibles","Mostrar vag�n","SALIR"};
		Vagon v1 = new Vagon("Vagon 1");
		MenuReservaTickets menu = new MenuReservaTickets(opciones); 
		
		menu.menuPerformer(v1);
	}
	
	
}
