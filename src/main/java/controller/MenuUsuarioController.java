package controller;

import java.io.IOException;

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
 * Servlet que maneja las solicitudes de un menú de usuario tiene la
 * funcionalidad de mostrar nombre de usuario, saldo y además redirigir a
 * páginas de deposito y retiro
 */
@WebServlet("/menu-usuario")
public class MenuUsuarioController extends HttpServlet {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService;
	private UsuarioDAO usuarioDao;

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public MenuUsuarioController(UsuarioService usuarioService, UsuarioDAO usuarioDao) {
		super();
		this.usuarioService = usuarioService;
		this.usuarioDao = usuarioDao;
	}

	public MenuUsuarioController() {
		super();
	}

	/**
	 * Inicializa el servlet y prepara el entorno de ejecución
	 * 
	 * @param config que contiene la configuracion del servlet
	 * @throws ServletException si ocurre un error al inicializar
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// Inicializar usuarioDao antes de pasar su referencia a usuarioService
		usuarioDao = new UsuarioDAOImpl();

		// Inicializar usuarioService con usuarioDao
		usuarioService = new UsuarioServiceImpl(usuarioDao);
	}

	/**
	 * maneja las solicitudes post del menú Obtiene el correo del usuario de la
	 * sesión, recupera su saldo y nombre, y redirige a las páginas de deposito y
	 * retiro saldo
	 * 
	 * @param req  HttpServletRequest que contiene la solicitud del cliente
	 * @param resp HttpServletResponse que contiene la respuesta del servlet
	 * @throws ServletException si ocurre un error en el servlet
	 * @throws IOException      si ocurre un error de entrada/salida
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String correo = (String) session.getAttribute("correo"); // Obtener el correo de la sesión

		if (correo != null) {

			int saldo = usuarioService.obtenerSaldoUsuario(correo);
			String nombre1 = usuarioService.obtenerNombreUsuario(correo);
			session.setAttribute("saldo", saldo);
			session.setAttribute("nombre", nombre1);
			String accion = req.getParameter("accion");

			if (accion != null) {
				if (accion.equals("depositar")) {
					resp.sendRedirect("depositar.jsp");
				} else if (accion.equals("retirar")) {
					resp.sendRedirect("retirar.jsp");
				} else {
					// cualquier otra accion
					resp.sendRedirect("inicio_sesion.jsp");
				}
			}
		} else {
			resp.sendRedirect("inicio_sesion.jsp"); // si el correo es null...
		}
	}

}
