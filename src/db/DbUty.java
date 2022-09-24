package db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DbUty {
	public static Connection getConnection() throws NamingException,SQLException{
		String jndi_url = "java:comp/env/jdbc/sample";
		Context ctx = new javax.naming.InitialContext();
		DataSource ds = (javax.sql.DataSource)ctx.lookup(jndi_url);
		Connection conn = ds.getConnection();
		return conn;
	}
}
