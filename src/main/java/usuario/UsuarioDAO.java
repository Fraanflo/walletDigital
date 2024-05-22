package usuario;

import java.sql.ResultSet;
import java.util.List;

import entidad.Usuario;

public interface UsuarioDAO {
	// listado usuarios
	List<Usuario> getListado();

	// obtener un usuario por id
	Usuario obtenerPorId(int user_id);

	// agregar un nuevo usuario
	boolean crearUsuario(Usuario usuario);


	// Método para actualizar un usuario existente en la bd
	int editarUsuario(Usuario usuario);

	// eliminar un usuario por su id
	int eliminarUsuario(int user_id);
	//obtener usuario por nombre

//	public String obtenerNombreUsuario(String correo);
	
	//consultarNombre
	public String consultarNombre(String correo);
	//public String consultarNombre(String sql, String correo);
	
	//consulta de saldo
	public int consultarSaldoUsuario(String correo);
	//public int consultarSaldoUsuario(String sql,String correo);
	
	//obtener saldo de usuario

//	public int obtenerSaldoUsuario(String correo);

public boolean actualizarSaldo(String correo, int nuevoSaldo);

	
	

}
