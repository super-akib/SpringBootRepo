package com.demo.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBCon {
	
	@Autowired
	private DataSource dataSource;
	
//	@Autowired
//	private DataSourceProperties properties;
	
	
	public void DBConn() {
		try {
			System.out.println("Data SOurce : "+dataSource.getConnection());
//			System.out.println("Database Name  : "+properties.getDbName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
