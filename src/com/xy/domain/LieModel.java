package com.xy.domain;

import com.xy.common.CharUpperLowerUtil;

/**
 * @author Administrator
 */
public class LieModel {
	
	private String lietype;
	private String liename;
	private String length;
	private String precision;
	private String scale;
	private String zhushi;
	
	
	
	private String javaType;
	private String lieJaveName;
	
	
	
	public String getLietype() {
		return lietype;
	}
	public void setLietype(String lietype) {
		this.lietype = lietype;
	}
	public String getLiename() {
		return liename;
	}
	public void setLiename(String liename) {
		this.liename = liename;
	}
	
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getLieJaveName() {
		String cn = this.getLiename().trim().toLowerCase();
		String temp = null;
		String[] cns = cn.split("_");
		for(String c:cns){
			temp =(temp==null?"":temp) + CharUpperLowerUtil.toUpperCaseFirstOne(c);
		}
		return CharUpperLowerUtil.toLowerCaseFirstOne(temp);
	}
	public void setLieJaveName(String lieJaveName) {
		this.lieJaveName = lieJaveName;
	}
	public String getJavaType() {
		if(lietype.contains("char")){
			return LieTypeEnum.StringType.getBianma();
		}
		if(lietype.contains("date")||lietype.contains("timestamp")){
			return LieTypeEnum.DateType.getBianma();
		}
		if(lietype.contains("number")){
			if(this.getScale()==null || Integer.valueOf(this.getScale()) == 0){
				return LieTypeEnum.IntegerType.getBianma();
			}else{
				return LieTypeEnum.DoubleType.getBianma();
			}
		}
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public String getZhushi() {
		return zhushi;
	}
	public void setZhushi(String zhushi) {
		this.zhushi = zhushi;
	}
	
	
	
	
}
