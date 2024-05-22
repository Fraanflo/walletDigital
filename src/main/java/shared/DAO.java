package shared;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/** 
 * clase DAO: proporciona métodos para conectar y gestionar acceso a una base de datos mYSQL
 */
public class DAO {
	protected Connection conn;
	protected ResultSet resultSet;
	protected Statement stmt;
	
	/**
	 * método para conectar a una base de datos, incluye parámetros de conexión
	 */
	protected void conectarDb() {
		try {
			if(conn==null || conn.isClosed()) {
				
				Class.forName("com.mysql.jdbc.Driver");
				String stringConection="jdbc:mysql://localhost:3306/alke_wallet";
				String user="Fraanflo";
				String pass="odin1234";
				conn = DriverManager.getConnection(stringConection,user,pass);
				System.out.println("Conectado a la Base de Datos");
			}
			
		}catch(ClassNotFoundException ex) {
			System.out.println("Error:Driver no encontrado");
		}catch(SQLException ex) {
			System.out.println("Fallo:");
			System.out.println("SQLException:"+ ex.getMessage());
			System.out.println("SQLState:"+ ex.getSQLState());
			System.out.println("VendorError:"+ ex.getErrorCode());
		}
	}
	/**
	 * método que ejecuta consulta SQL
	 * @param sql la consulta sql a ejecutar
	 * @return resultSet con resultado de la consulta, de salir erronea arroja null con una excepción
	 */
	protected ResultSet consultar(String sql) {
		try {
			conectarDb();
			this.stmt= conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			
			return resultSet;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	/**
     * ejecuta consulta SQL usando un PreparedStatement con parametro de correo
     * 
     * @param sql    la consulta SQL a ejecutar
     * @param correo el correo a establecer en el PreparedStatement
     * @return un ResultSet con los resultados de la consulta
     */
		protected ResultSet consultarPorCorreo(String sql, String correo) {
			 try {
			        conectarDb();
			        PreparedStatement stmt = conn.prepareStatement(sql);
			        stmt.setString(1, correo); 
			        ResultSet resultSet = stmt.executeQuery();
			        
			        return resultSet;
			    } catch (SQLException e) {
			        System.out.print(e.getMessage());
			        return null;
			    }
			}
		
		  /**
	     * Ejecuta una sentencia SQL de actualización (INSERT, UPDATE, DELETE)
	     * 
	     * @param sql la sentencia SQL a ejecutar
	     * @return el numero de filas afectadas por la ejecución de la sentencia. si ocurre un error arroja 0 con una excepción
	     */
	
	protected int ejecutarSql(String sql) {
		try {
			conectarDb();
			this.stmt= conn.createStatement();
			int regModificados = stmt.executeUpdate(sql);
			
			
			return regModificados;
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return 0;
		}
	}

	/**
     * cierra los recursos de la base de datos
     * se asegura de que cada recurso se cierra correctamente y manejar las excepciones
     */

	protected void CerrarBD() {		
		try {
         
            if(conn != null) {
                conn.close();
                conn=null;

            }
        } catch (SQLException e) {
            System.out.print("Error Cerrando: " + e.getMessage());
        }
    }
}
	