package entidad;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias de la clase Usuario.
 */
class UsuarioTest {
	Usuario usuario;

	/**
	 * creamos un objeto Usuario con todos sus atributos
	 */
	@BeforeEach
	void inicializar() {

		usuario = new Usuario(2, "Mario Fuentes", "mf@mail.com", "1234", 10000,
				new Timestamp(System.currentTimeMillis()));
	}

	/**
	 * prueba unitaria para verificar el funcionamiento de los métodos getter de la
	 * clase Usuario.
	 */

	@Test
	void testGetters() {
		// verificar valores
		assertEquals(2, usuario.getUser_id());
		assertEquals("Mario Fuentes", usuario.getNombre());
		assertEquals("mf@mail.com", usuario.getCorreo());
		assertEquals("1234", usuario.getClave());
		assertEquals(10000, usuario.getSaldo());

	}

	/**
	 * prueba unitaria para verificar el funcionamiento del constructor de la clase
	 * Usuario.
	 */

	@Test
	void testConstructor() {
		// Crear un objeto Usuario, utilizando el constructor de la clase Usuario co
		// todos sus atributos
		Usuario usuario = new Usuario("Juan Torres", "juan@mail.cl", "123456", 10000,
				Timestamp.valueOf("2024-05-20 19:00:00"));

		// Verificar los valores
		assertEquals("Juan Torres", usuario.getNombre());
		assertEquals("juan@mail.cl", usuario.getCorreo());
		assertEquals("123456", usuario.getClave());
		assertEquals(10000, usuario.getSaldo());
		assertEquals(Timestamp.valueOf("2024-05-20 19:00:00"), usuario.getFecha_de_creacion());
	}

	/**
	 * prueba unitaria para verificar el funcionamiento de los métodos setter de la
	 * clase Usuario.
	 */

	@Test
	void testSetters() {
		// settear los valores en el objeto usuario
		usuario.setUser_id(2);
		usuario.setNombre("José");
		usuario.setCorreo("jose@mail.com");
		usuario.setClave("1234");
		usuario.setSaldo(100000);
		usuario.setFecha_de_creacion(new Timestamp(System.currentTimeMillis()));

		// verificar que los valores se hayan establecido correctamente
		assertEquals(2, usuario.getUser_id());
		assertEquals("José", usuario.getNombre());
		assertEquals("jose@mail.com", usuario.getCorreo());
		assertEquals("1234", usuario.getClave());
		assertEquals(100000, usuario.getSaldo());
		assertEquals(new Timestamp(System.currentTimeMillis()), usuario.getFecha_de_creacion());
	}
}