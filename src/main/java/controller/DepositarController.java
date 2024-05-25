package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import usuario.UsuarioDAO;
import usuario.UsuarioDAOImpl;
import usuario.UsuarioService;
import usuario.UsuarioServiceImpl;

/**
 * Servlet que maneja las solicitudes de depósito en cuenta bancaria Proporciona
 * funcionalidad para realizar un depósito y actualizar saldo en la bd
 * 
 */
@WebServlet("/depositar")
public class DepositarController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
	private UsuarioService usuarioService;

	/**
	 * Inicializa el servlet y su entorno de ejecución
	 * 
	 * @param config ServletConfig que contiene la configuración del servlet
	 * @throws ServletException si ocurre un error al inicializar
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Inicializar usuarioDao antes de pasar su referencia a usuarioService

		usuarioDao = new UsuarioDAOImpl();

		// Inicializar usuarioService con usuarioDao
		usuarioService = new UsuarioServiceImpl(usuarioDao);
	}

	public DepositarController(UsuarioDAO usuarioDao, UsuarioService usuarioService) {
		super();
		this.usuarioDao = usuarioDao;
		this.usuarioService = usuarioService;
	}

	// Constructor
	public DepositarController() {
		this(new UsuarioDAOImpl(), new UsuarioServiceImpl(new UsuarioDAOImpl()));
	}

	/**
	 * maneja las solicitudes post para realizar un depósito bancario obtiene el
	 * monto del depósito y el correo del usuario de la sesión, valida un depósito y
	 * actualiza el saldo en la bd
	 * 
	 * @param req  HttpServletRequest que contiene la solicitud del cliente
	 * @param resp HttpServletResponse que contiene la respuesta del servlet
	 * @throws ServletException si ocurre un error en el servlet
	 * @throws IOException      si ocurre un error de entrada/salida
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String montoParam = req.getParameter("monto");
		int monto = Integer.parseInt(montoParam);

		String correo = (String) session.getAttribute("correo");

		if (correo != null) {
			int saldoActual = (int) session.getAttribute("saldo");

			if ( monto > 0) {

				int nuevoSaldo = saldoActual + monto;

				// Actualizar el saldo en la base de datos
				boolean actualizacionExitosa = usuarioDao.actualizarSaldo(correo, nuevoSaldo);
				String nombreActualizado = usuarioService.obtenerNombreUsuario(correo);

				if (actualizacionExitosa) {
					session.setAttribute("saldo", nuevoSaldo);
					session.setAttribute("nombre", nombreActualizado);
					session.setAttribute("correo", correo);

					// redirige a la página de confirmación deposito
					RequestDispatcher dispatcher = req.getRequestDispatcher("/confirmacion-deposito.jsp");
					System.out.println("Dispatcher: " + dispatcher);
					dispatcher.forward(req, resp);

				} else {
					// si falla la actualización en la base de datos, redirige a errorBD.jsp
					resp.sendRedirect("errorBD.jsp");
				}
			} else {
				// si no hay suficiente saldo o monto es menor a 0, redirige a página de error
				// deposito
				resp.sendRedirect("error-deposito.jsp");
			}
		}
	}
}