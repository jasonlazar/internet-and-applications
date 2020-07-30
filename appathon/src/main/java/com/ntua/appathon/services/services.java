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

import com.ntua.appathon.models.Distribution;

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
	
	public Distribution getTotalDist(String district) {
		return jdbcTemplate.queryForObject("select SUM(M.men) as men, SUM(M.women) as women"
				+ " from District as D, Municipality as M"
				+ " where D.name=? and D.id = M.district_id",
				new Object[] {district},
				(rs, rowNum) -> new Distribution(rs.getInt("men"), rs.getInt("women"))
		);
	}
	
	public Distribution getDist(String district, String municipality) {
		return jdbcTemplate.queryForObject("select M.men as men, M.women as women"
				+ " from District as D, Municipality as M"
				+ " where D.name=? and D.id = M.district_id and M.name=?",
				new Object[] {district, municipality},
				(rs, rowNum) -> new Distribution(rs.getInt("men"), rs.getInt("women"))
		);
	}
}