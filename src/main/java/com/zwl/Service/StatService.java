package com.zwl.Service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zwl.Dao.StatDao;
import com.zwl.Entity.Stat;

@Service
public class StatService {
	
	@Autowired
	@Qualifier("mysqlstat")
	private StatDao statDao;
/*	
	public Collection<Stat> getAllStats(){
		
		return this.statDao.getAllStats();
	}
*/	
	public String getStatHigh() {
		return this.statDao.getStatHigh();
	}
	
	public String getStatLow() {
		return this.statDao.getStatLow();
	}
	
	public String getStatAvg() {
		return this.statDao.getStatAvg();
	}
	
	public Map<String,Integer> getStatLevels() {
		return this.statDao.getStatLevels();
	}
}