package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.Query;

import entities.Departamento;

public class DepartamentosJDBC {
	
	private static Connection c = Conexion.getConexion();
	private Departamento dep;
	
	
	
	public DepartamentosJDBC() {
		super();
		// TODO Auto-generated constructor stub
	}



	public static ArrayList<Departamento> recuperaDep() throws SQLException{
		
		ArrayList<Departamento> listDep = new ArrayList<>();
		
		Statement q = c.createStatement();
		String query = "SELECT * FROM departamento";
		
		ResultSet rs = q.executeQuery(query);
		
		while(rs.next()) {
			Departamento d = new Departamento();
			
			d.setCodDepartamento(rs.getInt(1)); ;
			d.setCodResponsable(rs.getInt(2));
			d.setNombre(rs.getString(3));
			
			listDep.add(d);
		}
		
		if(listDep!=null) {
			
			return listDep;			
		}
		
		return null;
		
		
	}
	
}
