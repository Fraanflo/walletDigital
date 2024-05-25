package controller;

import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import usuario.UsuarioDAO;
import usuario.UsuarioService;
/**
 * Pruebas unitarias del servlet MenuUsuarioController 
 */
class MenuUsuarioControllerTest {
	private MenuUsuarioController servlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private UsuarioService usuarioService;
	private UsuarioDAO usuarioDao;
	private ServletConfig config;

	/**
	 * preparación entorno de prueba
	 * @throws ServletException  si ocurre un error de ejecucion con el servlet
	 */
	@BeforeEach
	void init() throws ServletException {
		MockitoAnnotations.initMocks(this);

		// Crear mocks para las dependencias
		usuarioDao = mock(UsuarioDAO.class);
		usuarioService = mock(UsuarioService.class);

		servlet = new MenuUsuarioController(usuarioService, usuarioDao);
		config = mock(ServletConfig.class);
		servlet.init(config);

		// Usar el setter para inyectar el UsuarioService mockeado
		servlet.setUsuarioService(usuarioService);

		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
	}

	@Test
	void testMenuDepositar() throws Exception {
		// configurar el comportamiento de la simulación
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("correo")).thenReturn("fran@mail.com");
		when(request.getParameter("accion")).thenReturn("depositar");
		when(usuarioService.obtenerSaldoUsuario("fran@mail.com")).thenReturn(5000000);
		when(usuarioService.obtenerNombreUsuario("fran@mail.com")).thenReturn("Francisca Flores");

		// Ejecutar metodo a prueba
		servlet.doPost(request, response);

		// Verificar resultado
		verify(session).setAttribute("saldo", 5000000);
		verify(session).setAttribute("nombre", "Francisca Flores");
		verify(response).sendRedirect("depositar.jsp");
	}
/**
 * prueba método Retirar del menú
 * @throws Exception si ocurre un error de ejecucion con el servlet
 */
	@Test
	void testMenuRetirar() throws Exception {
		// Configurar el comportamiento simulado
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("correo")).thenReturn("fran@mail.com");
		when(request.getParameter("accion")).thenReturn("retirar");
		when(usuarioService.obtenerSaldoUsuario("fran@mail.com")).thenReturn(5000000);
		when(usuarioService.obtenerNombreUsuario("fran@mail.com")).thenReturn("Francisca Flores");

		// Ejecutar el método bajo prueba
		servlet.doPost(request, response);

		// Verificar el comportamiento y los resultados
		verify(session).setAttribute("saldo", 5000000);
		verify(session).setAttribute("nombre", "Francisca Flores");
		verify(response).sendRedirect("retirar.jsp");
	}
/**
 * prueba método menu si correo es null manda a inicio_sesion.jsp
 * @throws Exception si ocurre un error de ejecucion con el servlet
 */
	@Test
	void testMenuSinCorreoUsuario() throws Exception {
		// Configurar el comportamiento simulado
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("correo")).thenReturn(null);

		// Ejecutar el método bajo prueba
		servlet.doPost(request, response);

		// Verificar que se redirige al usuario a la página de inicio de sesión
		verify(response).sendRedirect("inicio_sesion.jsp");
	}

}
