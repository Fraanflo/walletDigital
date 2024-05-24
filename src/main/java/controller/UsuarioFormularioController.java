package controller;

import java.io.IOException;

import java.sql.Timestamp;

import entidad.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import usuario.UsuarioDAO;
import usuario.UsuarioDAOImpl;
import usuario.UsuarioService;
import usuario.UsuarioServiceImpl;
/**
 * Servlet que maneja las solicitudes de registro de usuario con el formulario
 * Proporciona funcionalidad para mostrar el formulario de registro y guardar en la bd los datos ingresados por usuario
 */
@WebServlet("/formulario-usuario")
public class UsuarioFormularioController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService;
	private UsuarioDAO usuarioDao;
	
	
	 public UsuarioFormularioController(UsuarioService usuarioService, UsuarioDAO usuarioDao) {
		super();
		this.usuarioService = usuarioService;
		this.usuarioDao = usuarioDao;
	}

	public UsuarioFormularioController() {
		super();
	}

	/**
     * inicializa el servlet 
     * 
     * @param config ServletConfig que contiene la configuración del servlet
     * @throws ServletException si ocurre un error al inicializar
     */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		usuarioDao = new UsuarioDAOImpl();
		usuarioService = new UsuarioServiceImpl(usuarioDao);
	}

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
   


	 /**
     * Maneja las solicitudes get para mostrar el formulario de registro
     * 
     * @param req que contiene la solicitud del cliente
     * @param resp que contiene la respuesta del servlet
     * @throws ServletException si ocurre un error en el servlet
     * @throws IOException si ocurre un error de entrada/salida
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/usuario-formulario.jsp");
		System.out.println("dispatcher: " +dispatcher);
		dispatcher.forward(req, resp);
	}
	 /**
     * maneja solicitudes post para procesar los datos del formulario de registro
     * Crea un nuevo usuario con los datos recibidos y lo guarda en la base de datos.
     * 
     * @param req que contiene la solicitud del cliente
     * @param resp que contiene la respuesta del servlet
     * @throws ServletException si ocurre un error en el servlet
     * @throws IOException si ocurre un error de entrada/salida
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recupera los parámetros del formulario
		String nombre = req.getParameter("nombre");
		String correo = req.getParameter("correo");
		String clave = req.getParameter("clave");
		int saldo = Integer.parseInt(req.getParameter("saldo"));

		Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());
		// Crea un objeto Usuario con los parámetros recibidos
		Usuario usuario = new Usuario(nombre, correo, clave, saldo, fechaCreacion);

		// Guarda el usuario utilizando el servicio de usuario
		boolean exito = usuarioService.crearUsuario(usuario);

		if (exito) {
			// si el usuario se creo correctamente, redirige a página de registro_exitoso.jsp
			resp.sendRedirect("registro_exitoso.jsp");
		} else {
			// si hubo un problema al crear el usuario en la bd redirige a página de registro_error.jsp
			resp.sendRedirect("registro_error.jsp");
		}
	}

	
	}



