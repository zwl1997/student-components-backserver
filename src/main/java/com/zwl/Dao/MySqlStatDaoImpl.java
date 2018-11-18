package com.zwl.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zwl.Entity.Stat;

@Repository("mysqlstat")
public class MySqlStatDaoImpl implements StatDao{
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	


private static class StatRowMapperHigh implements RowMapper<Stat>{
	
	@Override
	public Stat mapRow(ResultSet resultSet,int i) throws SQLException{
	Stat stat=new Stat();
	stat.setStatHigh(resultSet.getString("high"));
	return stat;
  }	

}

private static class StatRowMapperLow implements RowMapper<Stat>{
	
	@Override
	public Stat mapRow(ResultSet resultSet,int i) throws SQLException{
	Stat stat=new Stat();
	stat.setStatLow(resultSet.getString("low"));
	return stat;
  }	
	
}

private static class StatRowMapperAvg implements RowMapper<Stat>{
	
	@Override
	public Stat mapRow(ResultSet resultSet,int i) throws SQLException{
	Stat stat=new Stat();
	stat.setStatAvg(resultSet.getString("avg"));
	return stat;
  }	
	
}
	
private static class StatRowMapperLevels implements RowMapper<Integer>{
	
	
		
	@Override
	public Integer mapRow(ResultSet resultSet,int i) throws SQLException{
	
     int  Alevel;
    
    Alevel=resultSet.getInt("subjectfinal");
    
    return Alevel;
    
  }	
}

	@Override
	public String getStatHigh() {
		//SELECT column_name(s) FROM table_name where column=value
		final String sql="SELECT DISTINCT MAX(Subjectfinal) as high FROM  subject";
		Stat stat=jdbcTemplate.queryForObject(sql, new StatRowMapperHigh());
		return stat.getStatHigh();
	}
	
	@Override
	public String getStatLow() {
		//SELECT column_name(s) FROM table_name where column=value
		final String sql="SELECT DISTINCT MIN(Subjectfinal) as low FROM  subject";
		Stat stat=jdbcTemplate.queryForObject(sql, new StatRowMapperLow());
		return stat.getStatLow();
	}
	
	@Override
	public String getStatAvg() {
		//SELECT column_name(s) FROM table_name where column=value
		final String sql="select cast((SELECT DISTINCT AVG(Subjectfinal) FROM  subject) as decimal(10,2)) as avg";
		Stat stat=jdbcTemplate.queryForObject(sql, new StatRowMapperAvg());
		return stat.getStatAvg();
	}
	
	@Override
	public Map<String, Integer> getStatLevels() {
		//SELECT column_name(s) FROM table_name where column=value
		final String sql="SELECT subjectfinal  FROM  subject";
		List<Integer> Alevel=jdbcTemplate.query(sql, new StatRowMapperLevels());
		
		Stat stat=new Stat();
		
		for(int score : Alevel) {
			if(score>=0&&score<60) {
				
				stat.setStatLevels(stat.L0);
			}
			
			if(score>=60&&score<70) {
				
				stat.setStatLevels(stat.L1);
			}
			
			if(score>=70&&score<80) {
				
				stat.setStatLevels(stat.L2);
			}
			
			if(score>=80&&score<90) {
				
				stat.setStatLevels(stat.L3);
			}
			
			if(score>=90&&score<=100) {
				
				stat.setStatLevels(stat.L4);
			}
		}
		
		return stat.getStatLevels();
	}
	
	
}