package py.com.sodep;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import py.com.sodep.utils.CsvHelper;

@SpringBootApplication
public class SqlApplication implements CommandLineRunner {

	@Autowired
	private JdbcProperties props;

	@Override
	public void run(String... arg0) throws Exception {
		Connection conn;
		
		Class.forName(props.getDriverClass());
		
		conn = DriverManager.getConnection(props.getUrl(), props.getUser(), props.getPassword());
		
		System.out.println("Connection was successfull");	
		
		getUsers(conn, arg0);
	}

	public void getUsers(Connection conn, String[] args) throws SQLException, FileNotFoundException {
		
		// TODO Escribir el query
		// concatenando la columna con el argumento
		// que corresponde al nombre de la columna.
		// Utilizar ? como placeholder para los valores de la columna
		String query = "";
		
		PreparedStatement ps = conn.prepareStatement(query);
	    // TODO Setear el valor por el cual se quiere buscar,
		// usando el segundo argumento de la consola
		
	    
		ResultSet rs = ps.executeQuery();
		
		// TODO Convertir el resultado a un CSV
		// El nombre del archivo CSV generado tiene que ser mi nombre
		// Ejemplo; rvillalba.csv
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		SpringApplication.run(SqlApplication.class, args);

	}

	
}
