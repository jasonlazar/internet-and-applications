package com.ntua.appathon.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class services {

	public List<String> getDistricts(){
		String connectionURL = "jdbc:mysql://localhost/Appathon";
		Connection connection = null;
		Statement statement = null;	
		ResultSet rs = null;
		ArrayList<String> districts = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, "appathon", "appathon");
			statement = connection.createStatement();
			rs=statement.executeQuery("select name from District order by name");
			while(rs.next()) {
				districts.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return districts;
	}
	
	public List<String> getMunicipalities(String district){
		String connectionURL = "jdbc:mysql://localhost/Appathon";
		Connection connection = null;
		Statement statement = null;	
		ResultSet rs = null;
		ArrayList<String> municipalities = new ArrayList<>();
		String Query = "select M.name from District as D, Municipality as M"
				+ " where D.name='" + district + "' and D.id = M.district_id order by M.name";
		System.out.println(Query);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, "appathon", "appathon");
			statement = connection.createStatement();
			rs=statement.executeQuery(Query);
			while(rs.next()) {
				municipalities.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return municipalities;
	}
}