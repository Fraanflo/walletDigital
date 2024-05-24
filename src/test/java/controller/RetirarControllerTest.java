package controller;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import usuario.UsuarioDAO;
import usuario.UsuarioService;

class RetirarControllerTest {
	private RequestDispatcher dispatcher;
	private RetirarController servlet;
	private HttpSession session;
	private HttpServletRequest request;
	private HttpServletResponse response;

	private UsuarioDAO usuarioDao;
	private UsuarioService usuarioService;

	/**
	 * Este método se ejecuta antes de cada prueba y se encarga de preparar el
	 * entorno para las pruebas.
	 */
	@BeforeEach
	void inicializar() {
		usuarioDao = mock(UsuarioDAO.class);
		usuarioService = mock(UsuarioService.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		servlet = new RetirarController(usuarioService, usuarioDao);
		dispatcher = mock(RequestDispatcher.class);
		request = mock(HttpServletRequest.class);

		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("/confirmacion-retiro.jsp")).thenReturn(dispatcher);
	}

	/**
	 * Simulación en la cual se intenta realizar un retiro con saldo y monto válido
	 * 
	 * @throws ServletException si ocurre un error en el servlet
	 * @throws IOException      si ocurre un error de E/S
	 */
	@Test
	void testRetiroVálido() throws ServletException, IOException {
		// datos de configuracion
		int monto = 2000;
		String correo = "fran@mail.com";
		int saldoActual = 10000;

		// Configurar el comportamiento simulado
		when(request.getParameter("monto")).thenReturn(Integer.toString(monto));
		when(session.getAttribute("saldo")).thenReturn(saldoActual);
		when(session.getAttribute("correo")).thenReturn(correo);
		when(usuarioService.obtenerNombreUsuario(eq(correo))).thenReturn("Francisca Flores");
		when(usuarioDao.actualizarSaldo(eq(correo), anyInt())).thenReturn(true);

		// Ejecutar el método bajo prueba
		servlet.doPost(request, response);

		// Verificar el comportamiento simulado
		verify(session).setAttribute("saldo", 8000);
		verify(session).setAttribute("nombre", "Francisca Flores");
		verify(session).setAttribute("correo", "fran@mail.com");
		verify(dispatcher).forward(request, response);
	}

	/**
	 * Simulación en la cual se intenta realizar un retiro con saldo insuficiente
	 * 
	 * @throws ServletException si ocurre un error en el servlet
	 * @throws IOException      si ocurre un error de E/S
	 */
	@Test
	void testSaldoInsuficienteParaRetiro() throws ServletException, IOException {
		// datos de prueba
		int monto = 10000;
		String correo = "fran@mail.com";
		int saldoActual = 6;

		// Configurar el comportamiento simulado
		when(request.getParameter("monto")).thenReturn(Integer.toString(monto));
		when(session.getAttribute("saldo")).thenReturn(saldoActual);
		when(session.getAttribute("correo")).thenReturn(correo);

		// ejecutar el método
		servlet.doPost(request, response);

		// Verificar el resultado
		verify(response).sendRedirect("error-retiro.jsp");
	}

	/**
	 * Simulación en la cual se intenta realizar un retiro de monto negativo
	 * 
	 * @throws ServletException si ocurre un error en el servlet
	 * @throws IOException      si ocurre un error de E/S
	 */
	@Test
	void testRetiroMontoNegativo() throws ServletException, IOException {
		// datos de prueba
		int monto = -1;
		String correo = "fran@mail.com";
		int saldoActual = 10000;

		// Configurar el comportamiento
		when(request.getParameter("monto")).thenReturn(Integer.toString(monto));
		when(session.getAttribute("saldo")).thenReturn(saldoActual);
		when(session.getAttribute("correo")).thenReturn(correo);

		// Ejecutar el metodo
		servlet.doPost(request, response);

		// Verificar el comportamiento y los resultados
		verify(response).sendRedirect("error-retiro.jsp");
	}
}
