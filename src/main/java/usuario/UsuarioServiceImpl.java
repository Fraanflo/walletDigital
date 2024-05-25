package usuario;


import java.util.List;

import entidad.Usuario;
/**
 * Clase implementación de UsuarioService, en ella contiene los métodos que son la lógica del negocio
 */
public class UsuarioServiceImpl implements UsuarioService {
	private UsuarioDAO usuarioDao;

	public UsuarioServiceImpl(UsuarioDAO usuarioDao) {
		super();
		this.usuarioDao = usuarioDao;
	}
/**
 * método que retorna el listado de usuarios registrados en la BD
 */
	@Override
	public List<Usuario> getListado() {
		return usuarioDao.getListado();
	}
/**
 * método boolean que dictamina si se crea o no el usuario, returna true (y se crea el usuario) o false(no se crea)
 */
	@Override
	public boolean crearUsuario(Usuario usuario) {
		if (usuario != null && !usuario.getNombre().isBlank() && !usuario.getCorreo().isBlank()
				&& !usuario.getClave().isBlank() ) {
			return usuarioDao.crearUsuario(usuario);
		} else {
			return false;
		}
	}
/**
 * método iniciar sesión que retorna un usuario si las credenciales son correctas.
 */
	@Override
	public Usuario iniciarSesion(String correo, String clave) {
		// obtener todos los usuarios
		List<Usuario> listadoUsuarios = usuarioDao.getListado();

		for (Usuario usuario : listadoUsuarios) {
			if (usuario.getCorreo().equals(correo)) {
				if (clave.equals(usuario.getClave())) {
					return usuario; // usuario autenticado :D
				} else {
					System.out.println("clave incorrecta");
					return null;// clave incorrecta :(
				}
			}
		}
		System.out.println("usuario no encontrado");
		return null; // usuario no encontrado ?_?
	}
/**
 * método que retorna un nombre de usuario segun su correo.
 */
	@Override
	public String obtenerNombreUsuario(String correo) {
		// TODO Auto-generated method stub
		return usuarioDao.consultarNombre(correo);
	}
/**
 * método que retorna el saldo del usuario según correo electronico)
 */
	@Override
	public int obtenerSaldoUsuario(String correo) {
		// TODO Auto-generated method stub
		return usuarioDao.consultarSaldoUsuario(correo);
	}

}
