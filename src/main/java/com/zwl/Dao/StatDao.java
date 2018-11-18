package com.zwl.Dao;

import java.util.Collection;
import java.util.Map;

import com.zwl.Entity.Stat;

public interface StatDao {

	//Collection<Stat> getAllStats();

	String getStatHigh();
	
	String getStatLow();
	
	String getStatAvg();

	Map<String, Integer> getStatLevels();
	
}