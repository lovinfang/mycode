package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBAcess {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/lovin");
			Connection conn = ds.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from emp");
			while(rs.next()){
				System.out.println("ename");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
