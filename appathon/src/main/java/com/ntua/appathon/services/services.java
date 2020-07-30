package com.ntua.appathon.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class services {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public List<String> getDistricts(){
		return jdbcTemplate.query("select name from District order by name",
				(rs, rowNum) ->
					rs.getString("name")
		);
	}
	
	public List<String> getMunicipalities(String district){
		return jdbcTemplate.query("select M.name from District as D, Municipality as M"
				+ " where D.name=? and D.id = M.district_id order by M.name",
				new Object[] {district},
				(rs, rowNum) -> rs.getString("M.name")
		);
	}
}