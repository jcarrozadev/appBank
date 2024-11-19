package es.evg.daw.pojo;

/**
 * Pojo principal para la aplicacion de Bizum
 */
public class Usuarios {

	private int id;
	private String nombre;
	private String telefono;
	private String email;
	private String fechaRegistro;
	private int bizumId;
	private int saldo;
	
	// Login
	
	private String usuario;
	private String contrasenia;
	
	// Sent
	
	private int idReceptor;
	private int saldoReceptor;
	private String concepto;
	
	// Constructor
	
	public Usuarios() {
		this.id = 0;
		this.nombre = "";
		this.telefono = "";
		this.email = "";
		this.fechaRegistro = "";
		this.bizumId = 0;
		this.saldo = 0;
		this.contrasenia = "";
		this.idReceptor = 0;
		this.saldoReceptor = 0;
		this.concepto = "";
		this.usuario = "";
	}

	public Usuarios(int id, String nombre, String telefono, String email, String fechaRegistro, int bizumId,
			int saldo, String contrasenia, int idReceptor, int saldoReceptor, String concepto, String usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fechaRegistro = fechaRegistro;
		this.bizumId = bizumId;
		this.saldo = saldo;
		this.contrasenia = contrasenia;
		this.idReceptor = idReceptor;
		this.saldoReceptor = saldoReceptor;
		this.concepto = concepto;
		this.usuario = usuario;
	}
	
	// Getters & Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getBizumId() {
		return bizumId;
	}

	public void setBizumId(int bizumId) {
		this.bizumId = bizumId;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getIdReceptor() {
		return idReceptor;
	}

	public void setIdReceptor(int idReceptor) {
		this.idReceptor = idReceptor;
	}

	public int getSaldoReceptor() {
		return saldoReceptor;
	}

	public void setSaldoReceptor(int saldoReceptor) {
		this.saldoReceptor = saldoReceptor;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
