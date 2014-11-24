package com.xy.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *	列类型
 *
 */
public enum CreateTypeEnum {
	//java类型
	Mappertype(1,"mapper"),
	DaoType(2,"dao"),
	ServiceType(3,"service"),
	ServiceImplType(4,"serviceimpl"),
	ActionType(5,"action"),
	JspType(6,"jsp"),
	BeanType(7,"bean");
	
	
	private Integer id;
	private String bianma;
	
	private CreateTypeEnum(Integer id, String bianma) {
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
	
	
	private static final Map<Integer, CreateTypeEnum> CACHE = new HashMap<Integer, CreateTypeEnum>(){
		{
			for(CreateTypeEnum enu : CreateTypeEnum.values()){
				put(enu.getId(), enu);
			}
		}
	};
	public static CreateTypeEnum toEnum(Integer id){
		return CACHE.get(id);
	}
}
