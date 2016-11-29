package py.com.sodep;

import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oracle.jdbc.OracleTypes;
import py.com.sodep.utils.CsvHelper;

@SpringBootApplication
public class SqlApplication implements CommandLineRunner {

	@Autowired
	private JdbcProperties props;
	
	private static void callStoredProcedure(Connection conn) throws SQLException {
		CallableStatement ocs = conn.prepareCall("{? = call acpks_stmt_gen.fn_stmt_gen(?,?,?,?,?,?)}");
		ocs.registerOutParameter(1, java.sql.Types.ARRAY);
		ocs.setString(2, "144000014");
		ocs.setString(3, "RET");
		ocs.setString(4, "N");
		ocs.setString(5, "3");
		ocs.setNull(6, java.sql.Types.DATE);
		ocs.setNull(7, java.sql.Types.DATE);

		ocs.executeUpdate();
	}

	@Override
	public void run(String... arg0) throws Exception {
	
		Connection conn;

		Class.forName(props.getDriverClass());
		conn = DriverManager.getConnection(props.getUrl(), props.getUser(), props.getPassword());
		System.out.println("Connection was successfull");	
		getUsers(conn);
	}

	//	SQL> var result refcursor
	//	SQL> execute get_users(:result)
	//
	//	PL/SQL procedure successfully completed.
	//
	//	SQL> print result
	public void getUsers(Connection dbConnection) throws SQLException, FileNotFoundException {
		
		String getDBUSERCursorSql = "{call get_users(?)}";
		CallableStatement callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);
		callableStatement.registerOutParameter(1, OracleTypes.CURSOR);

		// execute getDBUSERCursor store procedure
		callableStatement.executeUpdate();

		// get cursor and cast it to ResultSet
		ResultSet rs = (ResultSet) callableStatement.getObject(1);

		// Convierte el resultset a un CSV
		CsvHelper.convertToCsv(rs, "users.csv");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		SpringApplication.run(SqlApplication.class, args);

	}

	
}
