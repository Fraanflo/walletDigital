package entidad;

import java.sql.Timestamp;
/**
 * clase que representa a la entidad usuario con sus atributos
 */
public class Usuario {
/**
 * 
 */
	private int user_id;
	private String nombre;
	private String correo;
	private String clave;
	private int saldo;
	private Timestamp fecha_de_creacion;
/**
 * constructor usuario con todos sus atributos
 * @param user_id id usuario
 * @param nombre nombre usuario
 * @param correo correo usuario
 * @param clave clave usuario
 * @param saldo saldo usuario
 * @param fecha_de_creacion fecha de creacion del usuario en la bd
 */
	public Usuario(int user_id, String nombre, String correo, String clave, int saldo, Timestamp fecha_de_creacion) {
	    super();
	    this.user_id = user_id;
	    this.nombre = nombre;
	    this.correo = correo;
	    this.clave = clave;
	    this.saldo = saldo;
	    this.fecha_de_creacion = fecha_de_creacion;
	}
/**
 * constructor de la clase usuario sin el id
 * @param nombre nombre usuario
 * @param correo correo usuario
 * @param clave clave usuario
 * @param saldo saldo usuario
 * @param fecha_de_creacion fecha de creacion usuario en la bd
 */
	public Usuario( String nombre, String correo, String clave, int saldo, Timestamp fecha_de_creacion) {
		super();
		
		this.nombre = nombre;
		this.correo = correo;
		this.clave = clave;
		this.saldo = saldo;
		this.fecha_de_creacion = fecha_de_creacion;
	}
/**
 * constructor clase usuario por defcto
 * @param string parametro tipo string
 * @param int1 parametro tipo int
 */
	public Usuario(String string, int int1) {
		// TODO Auto-generated constructor stub
	}

	/**
     * Obtiene el user_id  del usuario.
     * 
     * @return el user_id del usuario
     */
	public int getUser_id() {
		return user_id;
	}

	 /**
     * Establece el id del usuario.
     * 
     * @param user_id el nuevo id del usuario
     */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	 /**
     * Obtiene el nombre  del usuario.
     * 
     * @return el nombre del usuario
     */
	public String getNombre() {
		return nombre;
	}
	 /**
     * Establece el nombre del usuario.
     * 
     * @param nombre el nuevo nombre del usuario
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 /**
     * Obtiene el correo  del usuario.
     * 
     * @return el correo del usuario
     */
	public String getCorreo() {
		return correo;
	}
	 /**
     * Establece el correo del usuario.
     * 
     * @param correo el nuevo correo del usuario
     */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	 /**
     * Obtiene la clave  del usuario.
     * 
     * @return la clave del usuario
     */
	public String getClave() {
		return clave;
	}
	 /**
     * Establece clave del usuario.
     * 
     * @param clave  id del usuario
     */
	public void setClave(String clave) {
		this.clave = clave;
	}
	 /**
     * Obtiene el saldo  del usuario.
     * 
     * @return el saldo del usuario
     */
	public int getSaldo() {
		return saldo;
	}
	 /**
     * Establece el saldo del usuario.
     * 
     * @param saldo el nuevo saldo del usuario
     */
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	 /**
     * Obtiene la fecha de creacion  del usuario.
     * 
     * @return la fecha de creacion del usuario
     */
	public Timestamp getFecha_de_creacion() {
		return fecha_de_creacion;
	}
	 /**
     * Establece fecha de creacion del usuario.
     * 
     * @param fecha_de_creacion nueva fecha de creacion del usuario
     */
	public void setFecha_de_creacion(Timestamp fecha_de_creacion) {
		this.fecha_de_creacion = fecha_de_creacion;
	}

}
