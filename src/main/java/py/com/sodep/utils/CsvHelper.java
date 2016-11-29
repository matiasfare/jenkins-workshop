package py.com.sodep.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CsvHelper {

	public static void convertToCsv(ResultSet rs, String fileName) throws SQLException, FileNotFoundException {
		PrintWriter csvWriter = new PrintWriter(new File(fileName));
		ResultSetMetaData meta = rs.getMetaData();
		int numberOfColumns = meta.getColumnCount();
		String dataHeaders = "\"" + meta.getColumnName(1) + "\"";
		for (int i = 2; i < numberOfColumns + 1; i++) {
			dataHeaders += ",\"" + meta.getColumnName(i) + "\"";
		}
		csvWriter.println(dataHeaders);
		while (rs.next()) {
			String row = "\"" + rs.getString(1) + "\"";
			for (int i = 2; i < numberOfColumns + 1; i++) {
				row += ",\"" + rs.getString(i) + "\"";
			}
			csvWriter.println(row);
		}
		csvWriter.close();
    }
}
