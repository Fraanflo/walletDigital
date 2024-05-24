package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidad.Usuario;
/**
 * Esta clase contiene pruebas unitarias para la clase implementación de UsuarioService
 */
class UsuarioServiceImplTest {
	private UsuarioServiceImpl usuarioService;
	private UsuarioDAO usuarioDao;
	 /**
     * configura los objetos necesarios para las pruebas antes de cada método
     */
	@BeforeEach
	void setUp() {

		usuarioDao = new UsuarioDAOImpl();
		usuarioService = new UsuarioServiceImpl(usuarioDao);
	}

    /**
     * Prueba el método getListado de UsuarioServiceImpl.
     */

	@Test
	void testGetListado() {
		// Ejecutar el método que se está probando
		List<Usuario> resultado = usuarioService.getListado();

		// Verificar el resultado
		assertNotNull(resultado);
		assertEquals(24, resultado.size());// igual varia en la cantidad de usuarios

	}

    /**
     * Prueba el método CrearUsuario que permite crear un usuario nuevo
     */
	@Test
	void testCrearUsuario() {
		// Crear un nuevo usuario
		Usuario usuario = new Usuario("Hector Salazar", "hsalazar@mail.com", "hola123", 10000,
	    new Timestamp(System.currentTimeMillis()));

		// Ejecutar el método que se está probando
		boolean resultado = usuarioService.crearUsuario(usuario);

		// Verificar el resultado
		assertTrue(resultado);
	}

    /**
     * Prueba el método IniciarSesion donde ingresamos una de las credenciales existentes de la BD
     */
	@Test
	void testIniciarSesionConCredencialesExistentes() {
		// datos de la prueba
		String correo = "fran@mail.com";
		String clave = "1234";

		Usuario resultado = usuarioService.iniciarSesion(correo, clave);

		// Verifico el resultado
		assertNotNull(resultado);
		assertEquals(correo, resultado.getCorreo());
	}

    /**
     * Prueba el método ObtenerNombreUsuario que obtiene un nombre usuario a través de su correo
     */
	@Test
	void TestObtenerNombreUsuario() {
		String nombre = "Francisca Flores";
		String correo = "fran@mail.com";

		String resultado1 = usuarioService.obtenerNombreUsuario(correo);
		String resultado2 = usuarioDao.consultarNombre(correo);

		assertEquals(nombre, resultado2);
		assertEquals(nombre, resultado1);
	}

	 /**
     * Prueba el método ObtenerSaldoUsuario que obtiene el saldo usuario a través de su correo
     */
	@Test
	void TestObtenerSaldoUsuario() {
		int saldo = 5000000;
		String correo = "fran@mail.com";

		int resultado1 = usuarioService.obtenerSaldoUsuario(correo);
		int resultado2 = usuarioDao.consultarSaldoUsuario(correo);

		assertEquals(saldo, resultado2);
		assertEquals(saldo, resultado1);

	}
}
