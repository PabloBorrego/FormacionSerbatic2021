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
import entities.Departamento;
import jdbc.DepartamentosJDBC;

/**
 * Servlet implementation class MostrarDepartamentosServ
 */
@WebServlet("/MostrarDepartamentos")
public class MostrarDepartamentosServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DepartamentoDAO dao = new DepartamentoDAO(Hibernate_Practicas.Practica_Hibernate1.App.sesion);
	ArrayList<Departamento> lDep;

	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDepartamentosServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		try {
			lDep = DepartamentosJDBC.recuperaDep();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(lDep != null) {
			App.logger.info("La lista de departamentos tiene valores");
			pw.println("<html>");
			pw.println("<head>");
				pw.println("<title>Listado de departamentos</title>");
			pw.println("</head>");
			pw.println("<body>");
				pw.println("<table border= \"2\">");
					pw.println("<tr>");
						pw.println("<th>Código del departamento</th>");
						pw.println("<th>Nombre del departamento</th>");
						pw.println("<th>Codigo del responsable del departamento</th>");
					pw.println("</tr>");
					for(Departamento d: lDep) {
						pw.println("<tr>");
							pw.println("<td>"+d.getCodDepartamento()+"</td>");
							pw.println("<td>"+d.getNombre()+"</td>");
							pw.println("<td>"+d.getCodResponsable()+"</td>");
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
