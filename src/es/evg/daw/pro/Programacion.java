package es.evg.daw.pro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import es.evg.daw.bd.Conexion;
import es.evg.daw.bd.SqlBizum;
import es.evg.daw.pojo.Usuarios;
import es.evg.daw.visual.Visual;

/**
 * Clase orientada en toda la programacion del programa
 */
public class Programacion implements ActionListener {

	Usuarios usuario = new Usuarios();
	Scanner teclado = new Scanner(System.in);
	Conexion objConexion = new Conexion();
	SqlBizum bizum = new SqlBizum(objConexion);
	Visual objVisual = new Visual();
	
	int idUsuario = 0;
	
	// CONSTRUCTOR
	
	public Programacion() {
		escuchadorLogin();
		objVisual.jfrFormularioLogin.setVisible(true);
	}
	
	/**
	 * Este metodo comprueba si el Login introducido es correcto o no (true, false)
	 * @return
	 */
	public boolean comprobarLogin() {
		
		String nombreUsuario = "";
		String contrasenia = "";
		
		
		try {
			objConexion.resultado = objConexion.sentencia.executeQuery("SELECT id, usuario, contrasenia FROM usuarios WHERE usuario ='"+usuario.getUsuario()+"'");
			if (objConexion.resultado.next()) { // si devuelve una fila te posicionas en la primera fila
				nombreUsuario = objConexion.resultado.getNString("usuario");
				contrasenia = objConexion.resultado.getNString("contrasenia");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (nombreUsuario.equals(usuario.getUsuario()) && contrasenia.equals(usuario.getContrasenia())) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * Este metodo sirve para enviarBizum de un usuario a otro
	 * @param idEmisor - Identificador del Emisor del Bizum
	 */
	public void enviarBizum(int idEmisor) {
		
		int dineroEnviar;
		String concepto = "";

		dineroEnviar = Integer.parseInt(objVisual.jtfCantidad.getText());
		
		if (bizum.sacarSaldo(idEmisor) < dineroEnviar) {
			JOptionPane.showConfirmDialog(objVisual.jfrFormularioEnviar, "No tienes cantidad suficiente para enviar",
	                "ERROR", JOptionPane.CLOSED_OPTION,
	                JOptionPane.ERROR_MESSAGE);
			return;
		}
			
		usuario.setTelefono(objVisual.jtfTelefono.getText());
		
		if (!verificarTelefono(usuario.getTelefono()))  {
			JOptionPane.showConfirmDialog(objVisual.jfrFormularioEnviar, "Este teléfono no existe",
	                "ERROR", JOptionPane.CLOSED_OPTION,
	                JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		concepto = objVisual.jtaConcepto.getText();
		
		int respuesta;
		if (concepto.compareTo("") == 0)  {
			respuesta = JOptionPane.showConfirmDialog(objVisual.jfrFormularioEnviar, "Falta el concepto, ¿Está seguro de enviar?",
	                "ADVERTENCIA", JOptionPane.YES_NO_OPTION,
	                JOptionPane.INFORMATION_MESSAGE);
			switch (respuesta) {
				case 0:
					bizum.comprobarBizum(usuario.getContrasenia(), usuario.getTelefono(), dineroEnviar, concepto);
					break;
			}
		}
		else
			bizum.comprobarBizum(usuario.getContrasenia(), usuario.getTelefono(), dineroEnviar, concepto);
		
	}
	
	/**
	 * Este metodo sirve para verificar si el telefono que se le pasa como parametro
	 * existe dentro de la base de datos
	 * @param telefono - Telefono para buscar en la base de datos
	 * @return
	 */
	public boolean verificarTelefono(String telefono) {
		
		String consulta = "SELECT * FROM usuarios WHERE telefono ="+telefono+"";
		
		try {
			objConexion.resultado = objConexion.sentencia.executeQuery(consulta);
			if (objConexion.resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	/**
	 * Este metodo sirve para cargar en la variable global idUsuario el id del Usuario que ha iniciado sesion
	 */
	public void obtenerId() {
		
		try {
			objConexion.resultado = objConexion.sentencia.executeQuery("SELECT id FROM usuarios WHERE usuario = '"+usuario.getUsuario()+"'");
			if (objConexion.resultado.next()) {
				idUsuario = objConexion.resultado.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//////// ESCUCHADORES
	
	/**
	 * Escuchador del visual de ventana Login
	 */
	public void escuchadorLogin() {
		objVisual.jbtIniciar.addActionListener(this);
		objVisual.jbtRegistrar.addActionListener(this);
	}
	
	/**
	 * Escuchador del visual de ventana Registro
	 */
	public void escuchadorRegistro() {
		objVisual.jbtVolver4.addActionListener(this);
	}
	 
	/**
	 * Escuchadores del visual de ventana Inicio
	 */
	public void escuchadorInicio() {
		objVisual.jbtConsultar.addActionListener(this);
		objVisual.jbtEnviar.addActionListener(this);
		objVisual.jbtTransacciones.addActionListener(this);
		objVisual.jbtIniciar.addActionListener(this);
		objVisual.jbtVolver.addActionListener(this);
	}
	
	/**
	 * Escuchadores del visual de ventana Enviar
	 */
	public void escuchadorEnviar() {
		objVisual.jbtEBizum.addActionListener(this);
		objVisual.jbtVolver2.addActionListener(this);
	}
	
	/**
	 * Escuchadores del visual de ventana Transacciones
	 */
	public void escuchadorTransacciones() {
		objVisual.jbtVolver3.addActionListener(this);
	}

	
	/**
	 * Este metodo sirve para darle funcionalidad al programa visual.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// LOGIN
		if (objVisual.jbtIniciar == e.getSource()) {
			
			if (objVisual.jtfUsuario.getText().compareTo("") == 0|| new String(objVisual.jtfContrasenia.getPassword()).compareTo("") == 0) {
				JOptionPane.showConfirmDialog(objVisual.jfrFormularioLogin, "Campos vacíos. Rellene los datos",
		                "ERROR", JOptionPane.CLOSED_OPTION,
		                JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			usuario.setUsuario(objVisual.jtfUsuario.getText());
			usuario.setContrasenia(new String(objVisual.jtfContrasenia.getPassword()));
			
			if (comprobarLogin()) {
				obtenerId();
				objVisual.jfrFormularioLogin.dispose();
				objVisual.disenioInicio();
				objVisual.cargarInicio();
				escuchadorInicio();
				objVisual.jfrFormularioInicio.setVisible(true);
			}
			else {
				JOptionPane.showConfirmDialog(objVisual.jfrFormularioLogin, "Datos no existentes. Inténtalo de nuevo",
		                "ERROR", JOptionPane.CLOSED_OPTION,
		                JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (objVisual.jbtRegistrar == e.getSource()) {
			
			objVisual.jfrFormularioLogin.dispose();
			objVisual.disenioRegistro();
			objVisual.cargarRegistro();
			escuchadorRegistro();
			objVisual.jfrFormularioReg.setVisible(true);
			
		}
		
		// REGISTRO 
		

		
		// CONSULTAR
		if (objVisual.jbtConsultar == e.getSource()) {
			bizum.consultarSaldo(idUsuario);
		}
		
		// ENVIAR
		if (objVisual.jbtEnviar == e.getSource()) {
			objVisual.jfrFormularioInicio.dispose();
			objVisual.disenioEnviar();
			objVisual.cargarEnviar();
			escuchadorEnviar();
			objVisual.jfrFormularioEnviar.setVisible(true);
		}
		
		if (objVisual.jbtEBizum == e.getSource()) {
			if (objVisual.jtfCantidad.getText().compareTo("") == 0 || objVisual.jtfTelefono.getText().compareTo("") == 0) {
				JOptionPane.showConfirmDialog(objVisual.jfrFormularioEnviar, "Campos vacíos. Rellene los datos",
		                "ERROR", JOptionPane.CLOSED_OPTION,
		                JOptionPane.ERROR_MESSAGE);
				return;
			}
			enviarBizum(idUsuario);
			objVisual.jfrFormularioEnviar.dispose();
			objVisual.disenioInicio();
			objVisual.cargarInicio();
			escuchadorInicio();
			objVisual.jfrFormularioInicio.setVisible(true);
		}
		
		// VOLVER
		if (objVisual.jbtVolver == e.getSource()) {
			objVisual.jfrFormularioInicio.dispose();
			objVisual.disenioLogin();
			objVisual.cargarLogin();
			escuchadorLogin();
			objVisual.jfrFormularioLogin.setVisible(true);
			JOptionPane.showMessageDialog(objVisual.jfrFormularioInicio, "Se ha cerrado la sesión. ¡Que tenga buen día!");
		}
		
		if (objVisual.jbtVolver2 == e.getSource()) {
			objVisual.jfrFormularioEnviar.dispose();
			objVisual.disenioInicio();
			objVisual.cargarInicio();
			escuchadorInicio();  
			objVisual.jfrFormularioInicio.setVisible(true);
		}
		
		if (objVisual.jbtVolver3 == e.getSource()) {
			
			objVisual.jfrFormularioTransac.dispose();
			objVisual.disenioLogin();
			objVisual.cargarLogin();
			escuchadorLogin();
			objVisual.jfrFormularioInicio.setVisible(true);
			
		}

		if (objVisual.jbtVolver4 == e.getSource()) {
			
			objVisual.jfrFormularioReg.dispose();
			objVisual.disenioLogin();
			objVisual.cargarLogin();
			escuchadorLogin();
			objVisual.jfrFormularioLogin.setVisible(true);
			
		}
		
		// TRANSACCIONES
		if (objVisual.jbtTransacciones == e.getSource()) {
			objVisual.jfrFormularioInicio.dispose();
			objVisual.disenioTransacciones();
			objVisual.cargarTransacciones();
			escuchadorTransacciones();
			objVisual.jfrFormularioTransac.setVisible(true);
			String transacciones = bizum.consultarTransacciones(idUsuario);
			objVisual.jtaTransacciones.append(transacciones);
			
		}
		
		if (objVisual.jbtVolver3 == e.getSource()) {
			objVisual.jfrFormularioTransac.dispose();
			objVisual.disenioInicio();
			objVisual.cargarInicio();
			escuchadorInicio();
			objVisual.jfrFormularioInicio.setVisible(true);
		}
		
		
	}
	
}
