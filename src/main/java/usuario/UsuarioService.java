package usuario;

import java.util.List;

import entidad.Usuario;

public interface UsuarioService {

	boolean crearUsuario(Usuario usuario);

	public Usuario iniciarSesion(String correo, String clave);

	public List<Usuario> getListado();

	

	public String obtenerNombreUsuario(String correo);

	public int obtenerSaldoUsuario(String correo);

}
