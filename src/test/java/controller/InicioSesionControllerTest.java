package controller;

import static org.mockito.Mockito.mock; 
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;

import entidad.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import usuario.UsuarioDAO;
import usuario.UsuarioService;
/**
 * Pruebas unitarias del servlet InicioSesionController, donde se prueba la funcionalidad de sus métodos
 *  a través de simulación
 */
class InicioSesionControllerTest {
	private HttpSession session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private InicioSesionController servlet;
	private UsuarioDAO usuarioDao;
	private UsuarioService usuarioService;
/**
 * preparación entorno de las pruebas
 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		usuarioDao = mock(UsuarioDAO.class);
		usuarioService = mock(UsuarioService.class);
		servlet = new InicioSesionController(usuarioService, usuarioDao);
		servlet.setUsuarioService(usuarioService); 

		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
	}
/**
 * prueba donde se simula un inicio de sesión exitoso 
 * @throws Exception si ocurre un error de ejecucion con el servlet
 */
	@Test
	void testInicioSesionExitoso() throws Exception {
		String correo = "fran@mail.com";
		String clave = "1234";
		Usuario usuario = new Usuario("Francisca Flores", correo, clave, 5000002, null);
		// Configurar el comportamiento de la simulacion

		when(request.getParameter("correo")).thenReturn(correo);
		when(request.getParameter("clave")).thenReturn(clave);
		when(usuarioService.iniciarSesion(correo, clave)).thenReturn(usuario);
		when(request.getSession()).thenReturn(session);
		when(usuarioService.obtenerSaldoUsuario(correo)).thenReturn(5000002);
		when(usuarioService.obtenerNombreUsuario(correo)).thenReturn("Francisca Flores");

		// ejecutar el metodo a prueba
		servlet.doPost(request, response);

		// Verificar el resultado del comportamiento
		verify(session).setAttribute("correo", correo);
		verify(session).setAttribute("saldo", 5000002);
		verify(session).setAttribute("nombre", "Francisca Flores");
		verify(response).sendRedirect("menu.jsp");
	}
/**
 * prueba donde se simula un inicio de sesión fallido (se digita una clave incorrecta)
 * @throws Exception si ocurre un error de ejecucion con el servlet
 */
	@Test
	void testInicioSesionFallido() throws Exception {
		// Configurar el comportamiento de la simulacion
		when(request.getParameter("correo")).thenReturn("fran@mail.com");
		when(request.getParameter("clave")).thenReturn("claveincorrecta");

		// Ejecutar el metodo a prueba
		servlet.doPost(request, response);

		// Verificar el resultado del comportamiento
		verify(response).sendRedirect("inicio_sesion.jsp?error=true");
	}
}