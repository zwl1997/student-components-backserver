package com.zwl.Entity;

import java.util.*;

public class Stat {
	
	private Map<String, Integer> levels = new HashMap<String, Integer>();
	
	private String high;
	private String low;
	private String avg;
	
	public String L0 = "0-60";
	public String L1 = "60-70";
	public String L2 = "70-80";
	public String L3 = "80-90";
	public String L4 = "90-100";
	
	public Stat (String high,String low,String avg,Map<String, Integer> levels) {
		this.high=high;
		this.low=low;
		this.avg=avg;
		this.levels=levels;
	}
	
 	public Stat (){
 		levels.put(L0, 0);
 		levels.put(L1, 0);
 		levels.put(L2, 0);
 		levels.put(L3, 0);
 		levels.put(L4, 0);
 	}
 	
 	public String getStatHigh() {
 		return high;
 	}
 	
 	public void setStatHigh(String high) {
 		this.high=high;
 	}
 	
 	public String getStatLow() {
 		return low;
 	}
 	
 	public void setStatLow(String low) {
 		this.low=low;
 	}
 	
 	public String getStatAvg() {
 		return avg;
 	}
 	
 	public void setStatAvg(String avg) {
 		this.avg=avg;
 	}
 	
 	public Map<String, Integer> getStatLevels() {
 		
 		Map<String, Integer> map = new TreeMap<>(levels);
 		
 		return map;
 	}
 	
 	public void setStatLevels(String LevelKey) {
 		
 		this.levels.put(LevelKey, this.levels.get(LevelKey)+ 1);
 		
 	}
 	
}