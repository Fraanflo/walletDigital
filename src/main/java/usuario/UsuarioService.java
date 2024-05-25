package usuario;

import java.util.List;

import entidad.Usuario;
/**
 * Interface UsuarioService que contiene las cabeceras de los métodos que contienen la lógica de negocio 
 */
public interface UsuarioService {

	boolean crearUsuario(Usuario usuario);

	public Usuario iniciarSesion(String correo, String clave);

	public List<Usuario> getListado();

	

	public String obtenerNombreUsuario(String correo);

	public int obtenerSaldoUsuario(String correo);

}
