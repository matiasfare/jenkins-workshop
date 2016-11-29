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
		getUsers(conn);
	}

	public void getUsers(Connection dbConnection) throws SQLException, FileNotFoundException {
		
		String query = "select * from LIBPAGOS_USERS";
		Statement stmt = dbConnection.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		// Convierte el resultset a un CSV
		CsvHelper.convertToCsv(rs, "users.csv");
		
		System.out.println("Archivo generado con éxito");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		SpringApplication.run(SqlApplication.class, args);

	}

	
}
