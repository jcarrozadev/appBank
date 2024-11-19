package es.evg.daw.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase de conexion a la base de datos de Bizum
 */
public class Conexion {
	
	public Connection conexion = null;
	public java.sql.Statement sentencia = null;
	public ResultSet resultado = null;
	public ResultSet resultado2 = null;

	// CONSTRUCTOR
	
	public Conexion() {
		conexionBD();
	}
	
	/**
	 * Metodo para conectar con la base de datos
	 */
	public void conexionBD() {
		
		String urlConexion = "jdbc:mysql://localhost:3306/bdbizum";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion = DriverManager.getConnection(urlConexion, "root", "");
			
			sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);			
			
		} catch (ClassNotFoundException e) {
			System.out.println("El driver no ha funcionado "+e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error con la base de datos "+e.getMessage());
			e.printStackTrace();
		}
		
	}	
	
	/**
	 * Metodo para cerrar la conexion de la Base de Datos
	 */
	public void cerrarConexionBD() {
		try {
			if (resultado != null) 
				resultado.close();
			if (sentencia != null) 
				sentencia.close();
			if (conexion != null) 
				conexion.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
