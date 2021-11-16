import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbreConexao {

	
	public static Connection abrirConexao() {
		
		try {
			final  String url = "jdbc:mysql://localhost:3306/curso_java?verifyServerCertificate=false&useSSL=true";
			final  String user = "root";
			final  String senha = "****";
			
			return DriverManager.getConnection(url, user, senha);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
