package java_mysql_erp.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.Properties;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection con = null;
		String propPath = "mysql_db.properties";

		Properties props = new Properties();
		try (InputStream is = ClassLoader.getSystemResourceAsStream(propPath);) {
			props.load(is);

			/*
			for (Entry<Object, Object> e : props.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
			*/
			String url = props.getProperty("url");
			con = DriverManager.getConnection(url, props);
//			String user = props.getProperty("user");
//			String password = props.getProperty("password");			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url 혹은 user, password를 확인하세요.");
		}

		return con;
	}
}
