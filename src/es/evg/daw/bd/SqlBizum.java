package es.evg.daw.bd;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import es.evg.daw.pojo.Usuarios;
import es.evg.daw.visual.Visual;

public class SqlBizum {
	
	Usuarios usuario = new Usuarios();
	Conexion objConexion = null;
	Visual objVisual = new Visual();
	
	/////////////// CONSTRUCTORES
	
	public SqlBizum() {
		this.objConexion = null;
	}
	
	public SqlBizum(Conexion objConexion) {
		this.objConexion = objConexion;
	}

	
	/**
	 * Metodo para obtener el nombre,saldo,telefono de un Identificador existente en la base de datos
	 * @param id - Identificador del usuario
	 */
	public void consultarSaldo(int id) {
		try {
			objConexion.resultado = objConexion.sentencia.executeQuery("SELECT nombre, saldo, telefono FROM usuarios WHERE id='"+id+"'");
			if (objConexion.resultado.next()) {
				usuario.setNombre(objConexion.resultado.getNString("nombre"));
				usuario.setSaldo(objConexion.resultado.getInt("saldo"));
				usuario.setTelefono(objConexion.resultado.getNString("telefono"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(objVisual.jfrFormularioInicio, "¡Hola "+usuario.getNombre()+"! Telefono "+usuario.getTelefono()+", tienes un saldo de "+usuario.getSaldo());
	}
	
	/**
	 * Metodo para obtener el saldo de un Identificador existente en la base de datos
	 * @param id - Identificador del usuario
	 * @return
	 */
	public int sacarSaldo(int id) {
		String consulta = "SELECT saldo FROM usuarios WHERE id = '"+id+"'";
		try {
			objConexion.resultado = objConexion.sentencia.executeQuery(consulta);
			if (objConexion.resultado.next()) {
				return objConexion.resultado.getInt("saldo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * Metodo para comprobar que el envío del Bizum es correcto en la base de datos
	 * @param tlfEmisor - Telefono del emisor del bizum
	 * @param tlfReceptor - Telefono del receptor del bizum
	 * @param dineroEnviar - Cantidad de dinero a enviar
	 * @param concepto - Concepto a agregar al bizum
	 */
	public void comprobarBizum(String tlfEmisor, String tlfReceptor, int dineroEnviar, String concepto) {
		
		String consulta = "SELECT id, saldo FROM usuarios WHERE telefono='"+tlfEmisor+"'";
		String consulta2 = "SELECT id, saldo FROM usuarios WHERE telefono='"+tlfReceptor+"'";
		
		try {
			objConexion.resultado = objConexion.sentencia.executeQuery(consulta);
			if (objConexion.resultado.next()) {
				usuario.setId(objConexion.resultado.getInt("id"));
				usuario.setSaldo(objConexion.resultado.getInt("saldo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			objConexion.resultado = objConexion.sentencia.executeQuery(consulta2);
			if (objConexion.resultado.next()) {
				usuario.setIdReceptor(objConexion.resultado.getInt("id"));
				usuario.setSaldoReceptor(objConexion.resultado.getInt("saldo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int nuevoSaldoEmisor = usuario.getSaldo() - dineroEnviar;
		int nuevoSaldoReceptor = usuario.getSaldoReceptor() + dineroEnviar;

		String update = "UPDATE usuarios SET saldo = "+nuevoSaldoEmisor+" WHERE id = "+usuario.getId()+"";
		String update2 = "UPDATE usuarios SET saldo = "+nuevoSaldoReceptor+" WHERE id = "+usuario.getIdReceptor()+"";		
		
		try {
			objConexion.sentencia.executeUpdate(update);
			JOptionPane.showMessageDialog(objVisual.jfrFormularioEnviar, "Enviando dinero...");
			objConexion.sentencia.executeUpdate(update2);
			JOptionPane.showMessageDialog(objVisual.jfrFormularioEnviar, "Recibiendo dinero...");
			registro(dineroEnviar, concepto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(objVisual.jfrFormularioEnviar, "Bizum enviado correctamente");
		
		
	}
	
	/**
	 * Metodo para registrar en la base de datos las transacciones de los bizum
	 * @param cantidad - Dinero enviado/recibido
	 * @param concepto - Concepto enviado
	 */
	public void registro (int cantidad, String concepto) {
		
		String consulta = "INSERT INTO transacciones(idEmisor,idReceptor,cantidad,concepto) VALUES ("+usuario.getId()+","+usuario.getIdReceptor()+","+cantidad+",'"+concepto+"');";
		
		//System.out.println(consulta);
		
		try {
			objConexion.sentencia.executeUpdate(consulta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo que sirve para sacar las Transacciones por Id de Usuario tanto de Envio/Recibo
	 * @param id - Identificador a buscar transacciones
	 * @return - Devuelve el toString del StringBuilder de Transacciones, montandolo en el JTextArea posterior
	 */
	public String consultarTransacciones(int id) {
		
	    String consulta = "SELECT idEmisor, idReceptor, cantidad, fecha, concepto, 'Enviado' AS tipo " +
	                      "FROM transacciones WHERE idEmisor=" + id + " " +
	                      "UNION " +
	                      "SELECT idEmisor, idReceptor, cantidad, fecha, concepto, 'Recibido' AS tipo " +
	                      "FROM transacciones WHERE idReceptor=" + id + " " +
	                      "ORDER BY fecha";
	    StringBuilder transacciones = new StringBuilder(500);
	    
	    try {
	        objConexion.resultado = objConexion.sentencia.executeQuery(consulta);
	        while (objConexion.resultado.next()) {
	            String tipo = objConexion.resultado.getString("tipo");
	            int cantidad = objConexion.resultado.getInt("cantidad");
	            if (tipo.equals("Enviado")) {
	            	transacciones.append("\t            [-] Bizum enviado: -" + cantidad+"\n\n");
	            } else {
	            	transacciones.append("\t            [+] Bizum recibido: +" + cantidad+"\n\n");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return transacciones.toString();
	}

	

	
}
