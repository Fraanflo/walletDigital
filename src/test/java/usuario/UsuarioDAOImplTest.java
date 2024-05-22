package usuario;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidad.Usuario;
/**
 * Clase de pruebas unitarias para la clase UsuarioDAOImpl.
 */
class UsuarioDAOImplTest {
private UsuarioDAOImpl usuarioDAO;

	    @BeforeEach
	    void setUp() {
	    usuarioDAO = new UsuarioDAOImpl();
	    }
	    /**
	     * Prueba para obtener un listado de usuarios
	     */
	    @Test
	    void testGetListado() {
	        List<Usuario> listado = usuarioDAO.getListado();
	        assertNotNull(listado);
	        assertFalse(listado.isEmpty());
	    }
	    /**
	     * Prueba para obtener un usuario por su id
	     */
	    @Test
	    void testObtenerPorId() {
	        int user_id = 3;
	        Usuario usuario = usuarioDAO.obtenerPorId(user_id);
	        assertNotNull(usuario);
	        assertEquals(user_id, usuario.getUser_id());
	    }
	    /**
	     * Prueba para crear un usuario
	     */
	    @Test
	    void testCrearUsuario() {
	        Usuario usuario = new Usuario("Jeannete Fuentes", "jfuentes@mail.com", "123456", 200000, new Timestamp(System.currentTimeMillis()));
	        boolean creado = usuarioDAO.crearUsuario(usuario);
	        assertTrue(creado);
	    }
	    /**
	     * Prueba para editar los datos de un usuario
	     */
	    @Test
	    void testEditarUsuario() {
	        int user_id = 4;
	        Usuario usuario = usuarioDAO.obtenerPorId(user_id);
	        usuario.setNombre("Anabelle Rodriguez");
	        int registrosAfectados = usuarioDAO.editarUsuario(usuario);
	        assertEquals(1, registrosAfectados);
	    }
	    /**
	     * Prueba para probar el metodo EliminarUsuario segun su id
	     */
	    @Test
	    void testEliminarUsuario() {
	        int user_id = 47;
	        int registrosAfectados = usuarioDAO.eliminarUsuario(user_id);
	        assertEquals(1, registrosAfectados);
	    }
	    /**
	     * Prueba para consultar el saldo de un usuario mediante su correo 
	     */
	    @Test
	    void testConsultarSaldoUsuario() {
	        String correo = "fran@mail.com";
	        int saldo = usuarioDAO.consultarSaldoUsuario(correo);
	        assertTrue(saldo > 0);
	    }
	    /**
	     * Prueba para consultar nombre de un usuario mediante su correo
	     */
	    @Test
	    void testConsultarNombre() {
	        String correo = "fran@mail.com";
	        String nombre = usuarioDAO.consultarNombre(correo);
	        assertNotNull(nombre);
	    }
	    /**
	     * Prueba del metodo ActualizarSaldo para actualizar el saldo de un usuario
	     */
	    @Test
	    void testActualizarSaldo() {
	        String correo = "fran@mail.com";
	        int nuevoSaldo = 5000000;
	        boolean actualizado = usuarioDAO.actualizarSaldo(correo, nuevoSaldo);
	        assertTrue(actualizado);
	    }
	}