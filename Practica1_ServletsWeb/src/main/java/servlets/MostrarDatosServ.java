package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hibernate_Practicas.Practica_Hibernate1.App;

/**
 * Servlet implementation class MostrarDatosServ
 */
@WebServlet("/MostrarDatos")
public class MostrarDatosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDatosServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String param = request.getParameter("table");
		
			if(param.equals("departamento")) {
				request.getRequestDispatcher("MostrarDepartamentos").forward(request, response);
				App.logger.info("Se selecciono mostrar departamentos");
			
			}else
				if(param.equals("empleado")){
				request.getRequestDispatcher("MostrarEmpelados").forward(request, response);
				App.logger.info("Se selecciono mostrar empleados");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
