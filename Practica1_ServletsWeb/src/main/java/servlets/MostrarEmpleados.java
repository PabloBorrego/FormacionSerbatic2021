package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hibernate_Practicas.Practica_Hibernate1.App;
import clasesDAO.DepartamentoDAO;
import clasesDAO.EmpleadoDAO;
import entities.Empleado;
import entities.Empleado;
import jdbc.DepartamentosJDBC;
import jdbc.EmpleadosJDBC;

/**
 * Servlet implementation class MostrarEmpleados
 */
@WebServlet("/MostrarEmpleados")
public class MostrarEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArrayList<Empleado> lEmp;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter pw = response.getWriter();
		try {
			lEmp = EmpleadosJDBC.recuperaEmp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(lEmp != null) {
			App.logger.info("La lista de departamentos tiene valores");
			pw.println("<html>");
			pw.println("<head>");
				pw.println("<title>Listado de departamentos</title>");
			pw.println("</head>");
			pw.println("<body>");
				pw.println("<table border= \"2\">");
					pw.println("<tr>");
						pw.println("<th>Código del empleado</th>");
						pw.println("<th>Código del departamento</th>");
						pw.println("<th>Dirección</th>");
						pw.println("<th>Fecha de nacimiento</th>");
						pw.println("<th>Lugar de nacimiento</th>");
						pw.println("<th>Nombre</th>");
						pw.println("<th>Primer apellido</th>");
						pw.println("<th>Segundo apellido</th>");
						pw.println("<th>Teléfono</th>");
						
					pw.println("</tr>");
					for(Empleado e: lEmp) {
						pw.println("<tr>");
							pw.println("<td>"+e.getCodEmpleado()+"</td>");
							pw.println("<td>"+e.getCodDepartamento()+"</td>");
							pw.println("<td>"+e.getDireccion()+"</td>");
							pw.println("<td>"+e.getFecha()+"</td>");
							pw.println("<td>"+e.getLugarNacimiento()+"</td>");
							pw.println("<td>"+e.getNombre()+"</td>");
							pw.println("<td>"+e.getPrimerApellido()+"</td>");
							pw.println("<td>"+e.getSegundoApellido()+"</td>");
							pw.println("<td>"+e.getTelefono()+"</td>");
						pw.println("</tr>");
					}
				pw.println("</table>");
			pw.println("</body>");
		pw.println("</html>");
		pw.close();
		}else {
			App.logger.info("La lista de departamentos está vacía");
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
