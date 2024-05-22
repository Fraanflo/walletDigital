package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.http.HttpClient;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import usuario.UsuarioDAO;
import usuario.UsuarioService;

class DepositarControllerTest {
	private RequestDispatcher dispatcher;
	private DepositarController servlet;
	private HttpSession session;
	private HttpServletRequest request;
	private HttpServletResponse response;

	private UsuarioDAO usuarioDao;
	private UsuarioService usuarioService;

	@BeforeEach
	void inicializar() {
		usuarioDao = mock(UsuarioDAO.class);
		usuarioService = mock(UsuarioService.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		servlet = new DepositarController(usuarioDao, usuarioService);
		dispatcher = mock(RequestDispatcher.class);
		request = mock(HttpServletRequest.class);
		

		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("/confirmacion-deposito.jsp")).thenReturn(dispatcher);
	}

	@Test
	void testDepositoVálido() throws ServletException, IOException {
		// datos de configuracion
		int monto = 1000;
		String correo = "fran@mail.com";
		int saldoActual = 5000;

		// Configurar el comportamiento simulado
		when(request.getParameter("monto")).thenReturn(Integer.toString(monto));
		when(session.getAttribute("saldo")).thenReturn(saldoActual);
		when(session.getAttribute("correo")).thenReturn(correo);
		when(usuarioService.obtenerNombreUsuario(eq(correo))).thenReturn("Francisca Flores");
		when(usuarioDao.actualizarSaldo(eq(correo), anyInt())).thenReturn(true);
		

		// Ejecutar el método bajo prueba
		servlet.doPost(request, response);

		// Verificar el comportamiento simulado
		verify(session).setAttribute("saldo", 6000);
		verify(session).setAttribute("nombre", "Francisca Flores");
		verify(session).setAttribute("correo", "fran@mail.com");
		verify(dispatcher).forward(request, response);
	}

	@Test
	void testSaldoInsuficiente() throws ServletException, IOException {
		// datos de prueba
		int monto = 10000;
		String correo = "fran@mail.com";
		int saldoActual = 5000;

		// Configurar el comportamiento simulado
		when(request.getParameter("monto")).thenReturn(Integer.toString(monto));
		when(session.getAttribute("saldo")).thenReturn(saldoActual);
		when(session.getAttribute("correo")).thenReturn(correo);
		

		// ejecutar el método 
		servlet.doPost(request, response);

		// Verificar el resultado
		verify(response).sendRedirect("error-deposito.jsp");
	}

	@Test
	void testDepositoMontoNegativo() throws ServletException, IOException {
		// datos de prueba
		int monto = -10;
		String correo = "fran@mail.com";
		int saldoActual = 5000;

		// Configurar el comportamiento
		when(request.getParameter("monto")).thenReturn(Integer.toString(monto));
		when(session.getAttribute("saldo")).thenReturn(saldoActual);
		when(session.getAttribute("correo")).thenReturn(correo);

		// Ejecutar el metodo
		servlet.doPost(request, response);

		// Verificar el comportamiento y los resultados
		verify(response).sendRedirect("error-deposito.jsp");
	}
}
