package py.com.sodep;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		getUsers(conn);
	}

	public void getUsers(Connection dbConnection) throws SQLException, FileNotFoundException {
		
		// TODO Escribir el query
		String query = "escribir acá el query";
		
		Statement stmt = dbConnection.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		// TODO Convertir el resultado a un CSV
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		SpringApplication.run(SqlApplication.class, args);

	}

	
}
