package usuario;


import java.util.List;

import entidad.Usuario;

public class UsuarioServiceImpl implements UsuarioService {
	private UsuarioDAO usuarioDao;

	public UsuarioServiceImpl(UsuarioDAO usuarioDao) {
		super();
		this.usuarioDao = usuarioDao;
	}

	@Override
	public List<Usuario> getListado() {
		return usuarioDao.getListado();
	}

	@Override
	public boolean crearUsuario(Usuario usuario) {
		if (usuario != null && !usuario.getNombre().isBlank() && !usuario.getCorreo().isBlank()
				&& !usuario.getClave().isBlank() && usuario.getSaldo() > 0) {
			return usuarioDao.crearUsuario(usuario);
		} else {
			return false;
		}
	}

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

	@Override
	public String obtenerNombreUsuario(String correo) {
		// TODO Auto-generated method stub
		return usuarioDao.consultarNombre(correo);
	}

	@Override
	public int obtenerSaldoUsuario(String correo) {
		// TODO Auto-generated method stub
		return usuarioDao.consultarSaldoUsuario(correo);
	}

}
