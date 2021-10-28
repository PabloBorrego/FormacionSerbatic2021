package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.Query;

import entities.Departamento;
import entities.Empleado;

public class EmpleadosJDBC {
	
	private static Connection c = Conexion.getConexion();
	private Empleado dep;
	
	
	
	public EmpleadosJDBC() {
		super();
		// TODO Auto-generated constructor stub
	}



	public static ArrayList<Empleado> recuperaEmp() throws SQLException{
		
		ArrayList<Empleado> listEmp = new ArrayList<>();
		
		Statement q = c.createStatement();
		String query = "SELECT * FROM empleado";
		
		ResultSet rs = q.executeQuery(query);
		
		while(rs.next()) {
			
			Empleado e = new Empleado();
			e.setCodEmpleado(rs.getInt(1));
			e.setCodDepartamento(rs.getInt(2));
			e.setDireccion(rs.getString(3));
			e.setFecha(rs.getString(4).charAt(0));
			e.setLugarNacimiento(rs.getString(5));
			e.setNombre(rs.getString(6));
			e.setPrimerApellido(rs.getString(7));
			e.setSegundoApellido(rs.getString(8));
			e.setTelefono(rs.getString(9));
			
			listEmp.add(e);
		}
		
		if(listEmp!=null) {
			
			return listEmp;			
		}
		
		return null;
		
		
	}
	
}
