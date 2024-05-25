package usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Usuario;
import shared.DAO;

/**
 * Clase implementación usuarioDAO que interactúa con la base de datos
 */
public class UsuarioDAOImpl extends DAO implements UsuarioDAO {
	/**
	 * método para obtener listado de usuarios
	 */
	@Override
	public List<Usuario> getListado() {
		List<Usuario> listado = new ArrayList<>();
		try {
			String sql = "select user_id, nombre, correo, clave, saldo, fecha_de_creacion from usuario";
			ResultSet rsl = this.consultar(sql);
			while (rsl.next()) {
				Usuario usuario = new Usuario(rsl.getString("nombre"), rsl.getString("correo"), rsl.getString("clave"),
						rsl.getInt("saldo"), rsl.getTimestamp("fecha_de_creacion"));
				listado.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listado;
	}

	/**
	 * método para obtener usuario por id
	 */
	@Override
	public Usuario obtenerPorId(int user_id) {
		try {
			String sql = "select user_id, nombre,correo,clave,saldo,fecha_de_creacion from usuario where user_id = "
					+ user_id;
			ResultSet rsl = this.consultar(sql);
			Usuario usuario = null;
			while (rsl.next()) {
				usuario = new Usuario(rsl.getInt("user_id"), rsl.getString("nombre"), rsl.getString("correo"),
						rsl.getString("clave"), rsl.getInt("saldo"), rsl.getTimestamp("fecha_de_creacion"));
			}
			return usuario;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;

		}
	}

	/**
	 * método para crear un usuario en la base de datos
	 */
	@Override
	public boolean crearUsuario(Usuario usuario) {
		String sql = "insert into usuario (nombre, correo, clave, saldo, fecha_de_creacion) values ('";
		sql += usuario.getNombre() + "', '";
		sql += usuario.getCorreo() + "', '";
		sql += usuario.getClave() + "', ";
		sql += usuario.getSaldo() + ", '";
		sql += usuario.getFecha_de_creacion() + "')";

		int registrosAfectados = ejecutarSql(sql);
		boolean resultado = (registrosAfectados > 0);
		return resultado;
	}

	@Override
	public int consultarSaldoUsuario(String correo) {
		try {
			String sqlConsulta = "select saldo from usuario where correo = ?";
			ResultSet rs = consultarPorCorreo(sqlConsulta, correo);

			int saldo = 0;
			if (rs.next()) {
				saldo = rs.getInt("saldo");
			}

			return saldo;
		} catch (SQLException e) {
			System.out.println("Error al consultar el saldo del usuario: " + e.getMessage());
			return 0;
		}
	}

	public String consultarNombre(String correo) {
		String sqlConsulta = "select nombre from usuario where correo = ?";
		ResultSet rs = consultarPorCorreo(sqlConsulta, correo);

		try {
			if (rs != null && rs.next()) {
				return rs.getString("nombre");
			}
		} catch (SQLException e) {
			System.out.println("Error en consultar el nombre del usuario: " + e.getMessage());
		} finally {
		}

		return null;
	}

	@Override
	public boolean actualizarSaldo(String correo, int nuevoSaldo) {
		try {
			String sql = "update usuario set saldo = " + nuevoSaldo + " where correo = '" + correo + "'";
			int registrosModificados = ejecutarSql(sql);
			return registrosModificados > 0;
		} catch (Exception e) {
			System.out.println("Error en actualizar el saldo del usuario: " + e.getMessage());
			return false;
		}

	}
}
