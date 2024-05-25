package shared;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias de la clase DAO.
 */
class DAOTest {
	private DAO dao;

	/**
	 * método que se ejecuta antes de cada prueba para inicializar el objeto DAO y
	 * establecer la conexión a la BD.
	 * 
	 */
	@BeforeEach
	void inicializar() throws SQLException {
		dao = new DAO();
		dao.conectarDb();
	}

	/**
	 * Prueba para verificar que se establezca la conexión a la bas de datos
	 */
	@Test
	protected void testConectarDb() {
		try {

			Connection conn = dao.conn;
			assertNotNull(conn);
			assertFalse(conn.isClosed());
		} catch (SQLException e) {
			fail("error al conectar a la base de datos: " + e.getMessage());
		}
	}

	/**
	 * Prueba para consultar datos de la BD
	 */
	@Test
	void testConsultar() {

		assertNotNull(dao.conn);

		String sql = "select user_id, nombre from usuario where user_id = '1'";

		// Realizar la consulta SQL
		ResultSet rs = dao.consultar(sql);
		assertNotNull(rs);

		try {

			assertTrue(rs.next());

			int user_id = rs.getInt("user_id");
			String nombre = rs.getString("nombre");

			assertEquals(1, user_id);
			assertEquals("Juanita Pérez", nombre);

		} catch (SQLException e) {
			fail("Excepción SQL: " + e.getMessage());
		}
	}

	/**
	 * prueba para consultar datos de la base de datos por el correo.
	 */
	@Test
	protected void testConsultarPorCorreo() {

		String correo = "jperez@gmail.com";
		String sql = "select * from usuario where correo = ?";
		assertNotNull(dao.consultarPorCorreo(sql, correo));
	}

	/**
	 * prueba para ejecutar consultas de inserción en la BD
	 */
	@Test
	protected void testEjecutarSql() {
		// definir la consulta
		String sql = "insert into usuario (nombre, correo, clave, saldo, fecha_de_creacion) values "
				+ "('Hugo López', 'hlopez@mail.com', 'hola123', 100000, NOW())";

		// ejecuta la consulta y obtiene el num de registros afectados
		int registrosAfectados = dao.ejecutarSql(sql);

		// Verificar que se haya insertado correctamente el registro
		assertEquals(1, registrosAfectados);
	}

	@Test
	protected void testCerrarBD() throws SQLException {
		dao.CerrarBD();
		assertNull(dao.conn);

	}
}
