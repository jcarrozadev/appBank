package es.evg.daw.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import es.evg.daw.interfaz.Interfaz;

/**
 * Clase Visual del programa de Bizums con una Interfaz implementada 
 */
public class Visual implements Interfaz {
	
	int wLogo = 380;
	int hLogo = 250;
	ImageIcon logo = new ImageIcon(new ImageIcon("imagenes/logo.jpeg").getImage().getScaledInstance(wLogo, hLogo, Image.SCALE_DEFAULT));
	
	// LOGIN
	public JFrame jfrFormularioLogin = null;
	public JPanel jpnLoginPrincipal = null;
	public JLabel jlbLogo = null;
	public JPanel jpnLogin = null;
	public JLabel jlbUsuario = null; JLabel jlbContrasenia = null;
	public JTextField jtfUsuario = null; public JPasswordField jtfContrasenia = null;
	public JButton jbtIniciar = null;
	public JButton jbtRegistrar = null;
	
	// REGISTRO
	
	public JFrame jfrFormularioReg = null;
	public JPanel jpnRegPrincipal = null;
	public JPanel jpnReg = null;
	public JLabel jlbRegNombre = null; public JTextField jtfRegNombre = null;
	public JLabel jlbRegTelefono = null; public JTextField jtfRegTelefono = null;
	public JLabel jlbRegEmail = null; public JTextField jtfRegEmail = null;
	public JLabel jlbRegUsuario = null; public JTextField jtfRegUsuario = null;
	public JLabel jlbRegContrasenia = null; public JPasswordField jtfRegContrasenia = null;
	public JButton jbtRegistrarBD = null;
	public JButton jbtVolver4 = null;
	
	// INICIO
	public JFrame jfrFormularioInicio = null;
	public JPanel jpnInicioPrincipal = null;
	public JPanel jpnInicio = null;
	public JButton jbtConsultar = null;
	public JButton jbtEnviar = null;
	public JButton jbtTransacciones = null;
	public JButton jbtVolver = null;
	
	// ENVIAR
	public JFrame jfrFormularioEnviar = null;
	public JPanel jpnEnviarPrincipal = null;
	public JPanel jpnEnviar = null;
	public JLabel jlbCantidad = null; public JLabel jlbTelefono = null; public JLabel jlbConcepto = null;
	public JTextField jtfCantidad = null; public JTextField jtfTelefono = null; public JTextArea jtaConcepto = null;
	public JButton jbtEBizum = null;
	public JButton jbtVolver2 = null;
	
	// TRANSACCIONES
	public JFrame jfrFormularioTransac = null;
	public JPanel jpnTransacPrincipal = null;
	public JPanel jpnTransac = null;
	public JLabel jlbTituTransac = null;
	public JButton jbtVolver3 = null;
	public JTextArea jtaTransacciones = null;
	public JScrollPane scrollTrans = null;

	public Visual() {
		disenioLogin();
		cargarLogin();
	}
	
	/////////////////////////////////////// DISEÑO PRINCIPAL ////////////////////////////////////////////
	
	public void disenioLogin() {
		
		jfrFormularioLogin = new JFrame("Imagine | Bizum");
		jfrFormularioLogin.setSize(1000,700);
		jfrFormularioLogin.setLocationRelativeTo(null);
		jfrFormularioLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrFormularioLogin.setResizable(false);
		
		jpnLoginPrincipal = new JPanel();
		jpnLoginPrincipal.setBackground(colorfondo);
		jpnLoginPrincipal.setLayout(null);
		
		jlbLogo = new JLabel();
		jlbLogo.setIcon(logo);
		jlbLogo.setBounds(300, 0, wLogo, hLogo);
		
		jpnLogin = new JPanel();
		jpnLogin.setBounds(145, 250, 700, 350);
		jpnLogin.setBackground(Color.white);
		jpnLogin.setLayout(null);
		jpnLogin.setBorder(imaginBorde);
		
		jlbUsuario = new JLabel("Usuario");
		jlbUsuario.setForeground(Color.black);
		jlbUsuario.setFont(imaginFuente);
		jlbUsuario.setBounds(10,0,200,200);
		
		jlbContrasenia = new JLabel("Contraseña");
		jlbContrasenia.setForeground(Color.black);
		jlbContrasenia.setFont(imaginFuente);
		jlbContrasenia.setBounds(10,100,200,200);
		
		jtfUsuario = new JTextField(9);
		jtfUsuario.setBounds(180,85,505,30);
		jtfUsuario.setFont(imaginFuente2);
		
		jtfContrasenia = new JPasswordField(9);
		jtfContrasenia.setBounds(180,185,505,30);
		jtfContrasenia.setFont(imaginFuente2);
		
		jbtIniciar = new JButton("Entrar");
		jbtIniciar.setBackground(colorfondo);
		jbtIniciar.setFont(imaginFuente);
		jbtIniciar.setBounds(250, 280, 200, 40);
		
		jbtRegistrar = new JButton("¿No tienes cuenta de Imagine? Registraté pulsando aquí");
		jbtRegistrar.setBounds(325, 620, 340, 20);
		jbtRegistrar.setBackground(colorfondo);
		jbtRegistrar.setBorder(new LineBorder(colorfondo));
		
		
	}
	
	public void cargarLogin() {
		
		jfrFormularioLogin.add(jpnLoginPrincipal);
		jpnLoginPrincipal.add(jlbLogo);
		jpnLoginPrincipal.add(jpnLogin);
		jpnLogin.add(jlbUsuario);
		jpnLogin.add(jlbContrasenia);
		jpnLogin.add(jtfUsuario);
		jpnLogin.add(jtfContrasenia);
		jpnLogin.add(jbtIniciar);
		jpnLoginPrincipal.add(jbtRegistrar);
		
	}
	
	public void disenioRegistro() {
		
		jfrFormularioReg = new JFrame("Imagine | Registro");
		jfrFormularioReg.setSize(1000,700);
		jfrFormularioReg.setLocationRelativeTo(null);
		jfrFormularioReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrFormularioReg.setResizable(false);
		
		jlbLogo.setBounds(300, 0, wLogo, hLogo);
		
		jpnRegPrincipal = new JPanel();
		jpnRegPrincipal.setBackground(colorfondo);
		jpnRegPrincipal.setLayout(null);
		
		jpnReg = new JPanel();
		jpnReg.setBounds(145, 250, 700, 350);
		jpnReg.setBackground(Color.white);
		jpnReg.setLayout(null);
		jpnReg.setBorder(imaginBorde);
		
		jlbRegUsuario = new JLabel("Usuario");
		jlbRegUsuario.setForeground(Color.black);
		jlbRegUsuario.setFont(imaginFuente);
		jlbRegUsuario.setBounds(10,-70,200,200);
		
		jlbRegContrasenia = new JLabel("Contraseña");
		jlbRegContrasenia.setForeground(Color.black);
		jlbRegContrasenia.setFont(imaginFuente);
		jlbRegContrasenia.setBounds(10,-30,200,200);
		
		jlbRegNombre = new JLabel("Nombre");
		jlbRegNombre.setForeground(Color.black);
		jlbRegNombre.setFont(imaginFuente);
		jlbRegNombre.setBounds(10,10,200,200);
		
		jlbRegTelefono = new JLabel("Telefono");
		jlbRegTelefono.setForeground(Color.black);
		jlbRegTelefono.setFont(imaginFuente);
		jlbRegTelefono.setBounds(10,50,200,200);
		
		jlbRegEmail = new JLabel("Email");
		jlbRegEmail.setForeground(Color.black);
		jlbRegEmail.setFont(imaginFuente);
		jlbRegEmail.setBounds(10,90,200,200);
		
		jtfRegUsuario = new JTextField(9);
		jtfRegUsuario.setBounds(180,15,505,30);
		jtfRegUsuario.setFont(imaginFuente2);
		
		jtfRegContrasenia = new JPasswordField(9);
		jtfRegContrasenia.setBounds(180,55,505,30);
		jtfRegContrasenia.setFont(imaginFuente2);
		
		jtfRegNombre = new JTextField(9);
		jtfRegNombre.setBounds(180,95,505,30);
		jtfRegNombre.setFont(imaginFuente2);
		
		jtfRegTelefono = new JTextField(9);
		jtfRegTelefono.setBounds(180,105,505,30);
		jtfRegTelefono.setFont(imaginFuente2);
		
		jtfRegTelefono = new JTextField(9);
		jtfRegTelefono.setBounds(180,135,505,30);
		jtfRegTelefono.setFont(imaginFuente2);
		
		jtfRegEmail = new JTextField(9);
		jtfRegEmail.setBounds(180,175,505,30);
		jtfRegEmail.setFont(imaginFuente2);
		
		jbtRegistrarBD = new JButton("Registrarse");
		jbtRegistrarBD.setBackground(colorfondo);
		jbtRegistrarBD.setFont(imaginFuente);
		jbtRegistrarBD.setBounds(250, 280, 200, 40);
		
		jbtVolver4 = new JButton("←");
		jbtVolver4.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtVolver4.setBorder(imaginBorde);
		jbtVolver4.setBackground(Color.white);
		jbtVolver4.setBounds(25,600,50,40);
		
	}
	
	public void cargarRegistro() {
		
		jfrFormularioReg.add(jpnRegPrincipal);
		jpnRegPrincipal.add(jpnReg);
		jpnRegPrincipal.add(jlbLogo);
		jpnRegPrincipal.add(jbtVolver4);
		jpnReg.add(jlbRegUsuario);
		jpnReg.add(jlbRegContrasenia);
		jpnReg.add(jlbRegNombre);
		jpnReg.add(jlbRegTelefono);
		jpnReg.add(jlbRegEmail);
		jpnReg.add(jtfRegUsuario);
		jpnReg.add(jtfRegContrasenia);
		jpnReg.add(jtfRegNombre);
		jpnReg.add(jtfRegTelefono);
		jpnReg.add(jtfRegEmail);
		jpnReg.add(jbtRegistrarBD);
		
	}
	
	public void disenioInicio() {
		
		jfrFormularioInicio = new JFrame("Imagine | Home");
		jfrFormularioInicio.setSize(1000,500);
		jfrFormularioInicio.setLocationRelativeTo(null);
		jfrFormularioInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrFormularioInicio.setResizable(false);
		
		jpnInicioPrincipal = new JPanel();
		jpnInicioPrincipal.setBackground(colorfondo);
		jpnInicioPrincipal.setLayout(null);

		jpnInicio = new JPanel();
		jpnInicio.setBounds(345, 50, 550, 350);
		jpnInicio.setBackground(Color.white);
		jpnInicio.setLayout(null);
		jpnInicio.setBorder(imaginBorde);
		
		jlbLogo.setBounds(0, 100, wLogo, hLogo);
	
		jbtConsultar = new JButton("Consultar Saldo");
		jbtConsultar.setBackground(colorfondo);
		jbtConsultar.setBorder(imaginBorde);
		jbtConsultar.setFont(imaginFuente);
		jbtConsultar.setBounds(170, 20, 200, 100);
		
		jbtEnviar = new JButton("Enviar Bizum");
		jbtEnviar.setBackground(colorfondo);
		jbtEnviar.setBorder(imaginBorde);
		jbtEnviar.setFont(imaginFuente);
		jbtEnviar.setBounds(170, 125, 200, 100);
		
		jbtVolver = new JButton("←");
		jbtVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtVolver.setBorder(imaginBorde);
		jbtVolver.setBackground(Color.white);
		jbtVolver.setBounds(25,400,50,40);
		
		jbtTransacciones = new JButton("Transacciones");
		jbtTransacciones.setBackground(colorfondo);
		jbtTransacciones.setBorder(imaginBorde);
		jbtTransacciones.setFont(imaginFuente);
		jbtTransacciones.setBounds(170, 230, 200, 100);
		
	}
	
	public void cargarInicio() {
		
		jfrFormularioInicio.add(jpnInicioPrincipal);
		jpnInicioPrincipal.add(jpnInicio);
		jpnInicioPrincipal.add(jbtVolver);
		jpnInicio.add(jbtConsultar);
		jpnInicio.add(jbtEnviar);
		jpnInicio.add(jbtTransacciones);
		jpnInicioPrincipal.add(jlbLogo);
		
	}
	
	public void disenioEnviar() {
		
		jfrFormularioEnviar = new JFrame("Imagine | Enviar");
		jfrFormularioEnviar.setSize(1000,700);
		jfrFormularioEnviar.setLocationRelativeTo(null);
		jfrFormularioEnviar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrFormularioEnviar.setResizable(false);
		
		jpnEnviarPrincipal = new JPanel();
		jpnEnviarPrincipal.setBackground(colorfondo);
		jpnEnviarPrincipal.setLayout(null);
		
		jpnEnviar = new JPanel();
		jpnEnviar.setBounds(220, 250, 550, 350);
		jpnEnviar.setBackground(Color.white);
		jpnEnviar.setLayout(null);
		jpnEnviar.setBorder(imaginBorde);
		
		jlbLogo.setBounds(300, 0, wLogo, hLogo);
		
		jlbCantidad = new JLabel("Cantidad");
		jlbCantidad.setForeground(Color.black);
		jlbCantidad.setFont(imaginFuente);
		jlbCantidad.setBounds(20,0,200,200);
		
		jlbTelefono = new JLabel("Teléfono");
		jlbTelefono.setForeground(Color.black);
		jlbTelefono.setFont(imaginFuente);
		jlbTelefono.setBounds(20,50,200,200);
		
		jlbConcepto = new JLabel("Concepto");
		jlbConcepto.setForeground(Color.black);
		jlbConcepto.setFont(imaginFuente);
		jlbConcepto.setBounds(20,100,200,200);
		
		jtfCantidad = new JTextField();
		jtfCantidad.setBounds(180,85,340,30);
		jtfCantidad.setFont(imaginFuente2);
		
		jtfTelefono = new JTextField(9);
		jtfTelefono.setBounds(180,135,340,30);
		jtfTelefono.setFont(imaginFuente2);

		jtaConcepto = new JTextArea();
		jtaConcepto.setBounds(180,185,340,50);
		jtaConcepto.setBorder(new LineBorder(Color.gray));
		jtaConcepto.setFont(imaginFuente2);
		
		jbtVolver2 = new JButton("←");
		jbtVolver2.setFont(imaginFuente);
		jbtVolver2.setBorder(imaginBorde);
		jbtVolver2.setBackground(Color.white);
		jbtVolver2.setBounds(10,600,50,40);
		
		jbtEBizum = new JButton("Enviar Bizum");
		jbtEBizum.setBackground(colorfondo);
		jbtEBizum.setFont(imaginFuente);
		jbtEBizum.setBounds(180, 270, 200, 40);
		
	}
	
	public void cargarEnviar() {
		
		jfrFormularioEnviar.add(jpnEnviarPrincipal);
		jpnEnviarPrincipal.add(jlbLogo);
		jpnEnviarPrincipal.add(jpnEnviar);
		jpnEnviarPrincipal.add(jbtVolver2);
		jpnEnviar.add(jlbCantidad);
		jpnEnviar.add(jlbTelefono);
		jpnEnviar.add(jlbConcepto);
		jpnEnviar.add(jtfCantidad);
		jpnEnviar.add(jtfTelefono);
		jpnEnviar.add(jtaConcepto);
		jpnEnviar.add(jbtEBizum);
		
	}
	
	public void disenioTransacciones() {
	    
	    jfrFormularioTransac = new JFrame("Imagine | Transacciones");
	    jfrFormularioTransac.setSize(1000,500);
	    jfrFormularioTransac.setLocationRelativeTo(null);
	    jfrFormularioTransac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jfrFormularioTransac.setResizable(false);
	    
	    jlbLogo.setBounds(0, 100, wLogo, hLogo);
	    
	    jpnTransacPrincipal = new JPanel();
	    jpnTransacPrincipal.setBackground(colorfondo);
	    jpnTransacPrincipal.setLayout(null);
	    
	    jpnTransac = new JPanel();
	    jpnTransac.setBounds(345, 50, 550, 350);
	    jpnTransac.setBackground(Color.white);
	    jpnTransac.setLayout(null);
	    jpnTransac.setBorder(imaginBorde);
	    
	    jlbTituTransac = new JLabel("TRANSACCIONES");
	    jlbTituTransac.setForeground(Color.black);
	    jlbTituTransac.setFont(imaginFuente);
	    jlbTituTransac.setBounds(190,0,300,30);
	    
	    jbtVolver3 = new JButton("←");
	    jbtVolver3.setFont(imaginFuente);
	    jbtVolver3.setBorder(imaginBorde);
	    jbtVolver3.setBackground(Color.white);
	    jbtVolver3.setBounds(10,400,50,40);
	    
	    jtaTransacciones = new JTextArea();
	    jtaTransacciones.setFont(imaginFuente3);
	    jtaTransacciones.setEditable(false);
	    
	    scrollTrans = new JScrollPane(jtaTransacciones);
	    scrollTrans.setBorder(new LineBorder(Color.white));
	    scrollTrans.setBounds(25, 40, 500, 300);
	    
	}

	public void cargarTransacciones() {
	    
	    jfrFormularioTransac.add(jpnTransacPrincipal);
	    jpnTransacPrincipal.add(jpnTransac);
	    jpnTransacPrincipal.add(jlbLogo);
	    jpnTransac.add(jlbTituTransac);
	    jpnTransacPrincipal.add(jbtVolver3);
	    jpnTransac.add(scrollTrans); 
	    
	}

}
