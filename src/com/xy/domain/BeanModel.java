package com.xy.domain;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.xy.common.CharUpperLowerUtil;

public class BeanModel {
	
//	表名
	private String tableName;
//	列信息
	private List<LieModel> liemodel;
	
	protected String muKuai;//模块名
	protected String leiName;//类名
	protected String fuperLeiName;//首字母小写类名
	protected String leiQuanName;//类全名
	protected String leiPackage;
	protected String leiSearchPackage;
	protected String idName;//主键名
	
	protected String allLie;
	protected String allLieFlag;
	protected String updateLieFlag;
	
	
	protected String firstCharStr;
	
	public List<LieModel> getLiemodel() {
		return liemodel;
	}
	public void setLiemodel(List<LieModel> liemodel) {
		this.liemodel = liemodel;
	}
	
	public String getMuKuai() {
		return muKuai;
	}
	public void setMuKuai(String muKuai) {
		this.muKuai = muKuai;
	}
	public String getLeiName() {
		
		String cn = tableName.trim().toLowerCase();
		String temp = null;
		if(cn.startsWith("t_")){
			cn = cn.replaceFirst("t_", "");
		}
		
		String[] cns = cn.split("_");
		for(String c:cns){
			temp =(temp==null?"":temp) + CharUpperLowerUtil.toUpperCaseFirstOne(c);
		}
		return temp;
	}
	public void setLeiName(String leiName) {
		this.leiName = leiName;
	}
	public String getFuperLeiName() {
		return CharUpperLowerUtil.toLowerCaseFirstOne(this.getLeiName());
	}
	public void setFuperLeiName(String fuperLeiName) {
		this.fuperLeiName = fuperLeiName;
	}
	public String getLeiQuanName() {
		return "com.haier.openplatform.alm."+this.getMuKuai()+".domain."+this.getLeiName();
	}
	
	public String getLeiPackage() {
		return "com.haier.openplatform.alm."+this.getMuKuai()+".domain";
	}
	
	public String getLeiSearchPackage() {
		return "com.haier.openplatform.alm."+this.getMuKuai()+".model";
	}
	
	public void setLeiQuanName(String leiQuanName) {
		this.leiQuanName = leiQuanName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
	public String getAllLie() {
		List<LieModel> lm = this.getLiemodel();
		StringBuffer sbuf = new StringBuffer();
		for(LieModel m:lm){
			sbuf=sbuf.append(m.getLiename()).append(",");
		}
		sbuf.deleteCharAt(sbuf.length()-1);
		return sbuf.toString();
	}
	public String getAllLieFlag() {
		List<LieModel> lm = this.getLiemodel();
		StringBuffer sbuf = new StringBuffer();
		for(LieModel m:lm){
			sbuf=sbuf.append("#{").append("model.").append(m.getLieJaveName()).append("}").append(",");
		}
		sbuf.deleteCharAt(sbuf.length()-1);
		return sbuf.toString();
	}
	public String getUpdateLieFlag() {
		List<LieModel> lm = this.getLiemodel();
		StringBuffer sbuf = new StringBuffer();
		for(LieModel m:lm){
			sbuf=sbuf.append(m.getLiename()).append(" = ").append("#{").append("model.").append(m.getLieJaveName()).append("}").append(",");
		}
		sbuf.deleteCharAt(sbuf.length()-1);
		return sbuf.toString();
	}
	/**
	 * @return
	 * 得到一个类的首字母字符串
	 */
	public String getFirstCharStr() {
		String cn = tableName.trim().toLowerCase();
		String temp ="";
		if(cn.startsWith("t_")){
			cn = cn.replaceFirst("t_", "");
		}
		
		String[] cns = cn.split("_");
		for(String c:cns){
			if(StringUtils.isNotBlank(c)){
				temp =(temp==null?"":temp) + StringUtils.substring(c, 0, 1);
			}
		}
		temp = "t"+temp;
		while(temp.length()<3){
			temp = temp+"t";
		}
		return temp;
	}
	
}
