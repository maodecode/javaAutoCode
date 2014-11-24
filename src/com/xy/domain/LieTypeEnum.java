package com.xy.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *	列类型
 *
 */
public enum LieTypeEnum {
	//java类型
	IntegerType(1,"Long"),
	StringType(2,"String"),
	FloatType(3,"Float"),
	DateType(4,"java.util.Date"),
	DoubleType(6,"Double"),
	LongType(5,"Long");
	
	
	private Integer id;
	private String bianma;
	
	private LieTypeEnum(Integer id, String bianma) {
		this.id = id;
		this.bianma = bianma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBianma() {
		return bianma;
	}

	public void setBianma(String bianma) {
		this.bianma = bianma;
	}
	
	
	private static final Map<Integer, LieTypeEnum> CACHE = new HashMap<Integer, LieTypeEnum>(){
		{
			for(LieTypeEnum enu : LieTypeEnum.values()){
				put(enu.getId(), enu);
			}
		}
	};
	public static LieTypeEnum toEnum(Integer id){
		return CACHE.get(id);
	}
}
