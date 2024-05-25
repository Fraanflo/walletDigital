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
 * Servlet que maneja las solicitudes de retiro de fondos en cuenta bancaria
 * Proporciona funcionalidad para realizar un retiro y actualizar saldo en la bd
 * 
 */
@WebServlet("/retirar")
public class RetirarController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService;
	private UsuarioDAO usuarioDao;
	
	

	public RetirarController() {
		super();
	}
	public RetirarController(UsuarioService usuarioService, UsuarioDAO usuarioDao) {
		super();
		this.usuarioService = usuarioService;
		this.usuarioDao = usuarioDao;
	}
	/**
     * Inicializa el servlet y su entorno de ejecución
     * 
     * @param config ServletConfig que contiene la configuración del servlet
     * @throws ServletException si ocurre un error al inicializar
     */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// inicializar UsuarioDao
		usuarioDao = new UsuarioDAOImpl();

		// inicializar usuarioService y pasar usuarioDao
		usuarioService = new UsuarioServiceImpl(usuarioDao);
	}
	/**
     * maneja las solicitudes post para realizar un retiro de fondos bancario
     * obtiene el monto del retiro y el correo del usuario de la sesión, valida un retiro y actualiza el saldo 
     * en la bd
     * @param req HttpServletRequest que contiene la solicitud del cliente
     * @param resp HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException si ocurre un error en el servlet
     * @throws IOException si ocurre un error de entrada/salida 
     */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String montoParam = req.getParameter("monto");
        int monto = Integer.parseInt(montoParam);
    	
      
        String correo = (String) session.getAttribute("correo");


		if (correo != null) {

			int saldoActual = (int) session.getAttribute("saldo");

			if (saldoActual >= monto && monto > 0) {

				int nuevoSaldo = saldoActual - monto;

				// Actualizar el saldo en la base de datos
				boolean actualizacionExitosa = usuarioDao.actualizarSaldo(correo, nuevoSaldo);
				String nombreActualizado = usuarioService.obtenerNombreUsuario(correo);
				if (actualizacionExitosa) {

					session.setAttribute("saldo", nuevoSaldo); // obtener saldo luego de la transacción
					session.setAttribute("nombre", nombreActualizado); // obtener nombre luego de la transacción
					session.setAttribute("correo", correo);// obtener correo luego de la transacción
                    // redirige a la página de confirmación retiro
 
					 // redirige a la página de confirmación deposito
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/confirmacion-retiro.jsp");
                    System.out.println("Dispatcher: " + dispatcher);
                    dispatcher.forward(req, resp);
				} else {
					// redirigir a una página de error en caso de que no se actualice en la bd
					resp.sendRedirect("errorBD.jsp");
				}
			} else {
				// si no hay suficiente saldo o monto inválido
				resp.sendRedirect("error-retiro.jsp");
			}

		}
	}
}