package controller;

import java.io.IOException;

import entidad.Usuario;
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
 * Servlet que maneja las solicitudes de un login de usuario tiene la
 * funcionalidad de autenticar a un usuario y de gestionar la sesión
 */
@WebServlet("/InicioSesion")
public class InicioSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService;
	private UsuarioDAO usuarioDao;

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public InicioSesionController(UsuarioService usuarioService, UsuarioDAO usuarioDao) {
		super();
		this.usuarioService = usuarioService;
		this.usuarioDao = usuarioDao;
	}

	public InicioSesionController() {
		super();
	}

	/**
	 * Inicializa el servlet y prepara el entorno de ejecución
	 * 
	 * @param config ServletConfig que contiene configuracionn del servlet
	 * @throws ServletException si ocurre un error al inicializar
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarioDao = new UsuarioDAOImpl();
		usuarioService = new UsuarioServiceImpl(usuarioDao);
	}

	/**
	 * maneja las solicitudes post para el login de un usuario. autentica al usuario
	 * utilizando su correo y clave. si la autenticacion es exitosa, establece la
	 * sesión del usuario y redirige al menú principal. Si la autenticación falla,
	 * redirige a la pagina de inicio de sesión con msj de error
	 * 
	 * @param req  HttpServletRequest que contiene solicitud del cliente
	 * @param resp HttpServletResponse que contiene la respuesta del servlet
	 * @throws ServletException si ocurre un error en el servlet
	 * @throws IOException      si ocurre un error de entrada/salida
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String correo = req.getParameter("correo");
		String clave = req.getParameter("clave");
		// int saldo = usuarioDao.obtenerSaldoUsuario(correo);

		Usuario autenticar = usuarioService.iniciarSesion(correo, clave);
		if (autenticar != null) {
			HttpSession session = req.getSession();

			session.setAttribute("correo", correo);
			// Obtener el saldo del usuario
			int saldo = usuarioService.obtenerSaldoUsuario(correo);
			// obtener nombre usuario
			String nombre = usuarioService.obtenerNombreUsuario(correo);
			session.setAttribute("saldo", saldo);
			session.setAttribute("nombre", nombre);

			resp.sendRedirect("menu.jsp");
		} else {
			resp.sendRedirect("inicio_sesion.jsp?error=true");
		}
	}

}
