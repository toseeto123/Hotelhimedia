package com.hotel.util;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class DBManager {

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:/comp/env/jdbc/register");

			conn = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			
		}
		return conn;
	}
	

	// insert, delete, update ?떆 ?궗?슜?븯?뒗 close
	public static void close(Statement stmt, Connection conn) {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// select 援щЦ
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
