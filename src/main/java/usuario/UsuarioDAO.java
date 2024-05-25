package usuario;

import java.util.List;

import entidad.Usuario;

/**
 * interfaz UsuarioDAO que contiene la cabecera de los métodos para acceder a la
 * BD
 */
public interface UsuarioDAO {
	// listado usuarios
	List<Usuario> getListado();

	// obtener un usuario por id
	Usuario obtenerPorId(int user_id);

	// agregar un nuevo usuario
	boolean crearUsuario(Usuario usuario);

	// cabecera método consultarNombre
	public String consultarNombre(String correo);
	// public String consultarNombre(String sql, String correo);

	// cabecera método consulta de saldo
	public int consultarSaldoUsuario(String correo);

	//cabecera método actualizar saldo
	public boolean actualizarSaldo(String correo, int nuevoSaldo);

}
