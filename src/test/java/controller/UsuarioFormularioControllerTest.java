package controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import usuario.UsuarioDAO;
import usuario.UsuarioService;

/**
 * Pruebas unitarias del servlet UsuarioFormularioController
 */
class UsuarioFormularioControllerTest {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UsuarioFormularioController servlet;
	private UsuarioDAO usuarioDao;
	private UsuarioService usuarioService;
	private RequestDispatcher dispatcher;

	/**
	 * inicializa el servlet
	 */
	@BeforeEach
	void init() {

		MockitoAnnotations.initMocks(this);
		usuarioDao = mock(UsuarioDAO.class);
		usuarioService = mock(UsuarioService.class);
		servlet = new UsuarioFormularioController(usuarioService, usuarioDao);
		servlet.setUsuarioService(usuarioService);
		dispatcher = mock(RequestDispatcher.class);
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
	}

	/**
	 * maneja solicitudes post para procesar los datos del formulario de registro de
	 * usuarios.
	 * 
	 * @throws ServletException si ocurre un error en el servlet
	 * @throws IOException      si ocurre un error de entrada/salida
	 */
	@Test
	public void testDelDoPost() throws ServletException, IOException {
		// Configuramos los parámetros de la simulación
		when(request.getParameter("correo")).thenReturn("fran@mail.com");
		when(request.getParameter("clave")).thenReturn("password");
		when(request.getParameter("nombre")).thenReturn("Francisca Flores");

		when(request.getParameter("saldo")).thenReturn("100");

		UsuarioService usuarioService = mock(UsuarioService.class);
		when(usuarioService.crearUsuario(any())).thenReturn(true);
		servlet.setUsuarioService(usuarioService);

		// simulamos la solicitud del post
		servlet.doPost(request, response);

		// Verificamos que se haya redirigido
		verify(response).sendRedirect("registro_exitoso.jsp");

		// verificamos que si hay error al crear usuario redirija a error
		when(usuarioService.crearUsuario(any())).thenReturn(false);
		servlet.doPost(request, response);
		verify(response).sendRedirect("registro_error.jsp");
	}

	/**
	 * Maneja solicitudes get para procesar los datos del formulario de registro de
	 * usuarios.
	 * 
	 * @throws ServletException si ocurre un error en el servlet
	 * @throws IOException      si ocurre un error de entrada/salida
	 */
	@Test
	public void testDelDoGet() throws ServletException, IOException {

		when(request.getRequestDispatcher("/usuario-formulario.jsp")).thenReturn(dispatcher);
		servlet.doGet(request, response);

		verify(dispatcher).forward(request, response);
	}
}
