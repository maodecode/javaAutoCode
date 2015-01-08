package com.xy.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;

import com.xy.common.BeanService;
import com.xy.common.SpringContextUtil;
import com.xy.common.TemFactory;
import com.xy.domain.BeanModel;

import freemarker.template.Template;

public class MainTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("main方法开始。。。。。。");
		//BeanService bs =  (BeanService) SpringContextUtil.getInstance().getBean("beanServiceImpl");
		BeanService bs=(BeanService) SpringContextUtil.getBean("beanServiceImpl");
//		BeanModel bm = bs.getBeanModel("lixiang_detail");
		String[] table = {
//				"LIXIANG_XT_MUBIAO",
//				"LIXIANG_XM_MUBIAO"
//				"LIXIANG_PINGWEI",
//				"LIXIANG_FEIY_MINGXI",
//				"LIXIANG_FANW",
//				"LIXIANG_DETAIL",
//				"system_shijian_zhakou",
//				"LIXIANG_CHANCHU",
//				"lixiang_chanchu",
//				"lixiang_pingwei",
//				"lixiang_pingwei_option",
//				"lixiang_yingyxit",
//				"pool_lix_pingwei",
//				"pool_jiagou_pinggu",
//				"pool_xiangm_jingli",
//				"lixiang_pingweipsh",
//				"system_shenpi_role",
//				"pool_tuandui"
//				"lixiang_tuandui"
//				"pool_lix_pingwei",
//				"lixiang_pingwei"
//				"pool_yusuan_shenpi"
//				"pool_jiagou_pinggu"
//				"SYSTEM_BIANMA"
//				"sys_option_admin"
//				"POOL_CAN_SHOW_USER"
//				"hetong_detail",
//				"hetong_rentbaoj",
//				"hetong_fuklchb", 
//				"hetong_feiyjt"
				
//				"POOL_LINGYU_JIBIE",
//				"POOL_GONGSI_baojia",
//				"POOL_gongsi_lyjsjib"
//				"ALM_SUPPLIER_INFO"
//				"hetong_rentbj"
//				"alm_hetong_jiafang"
//				"HETONG_DETAIL"
//				"hetong_yunwei_rentbj"
				
//				"project_lchb_yanshou"
//				"project_fukuan"
//				
//				"hetong_gys_lianxfs",
//				"alm_hetong_yifang"
//				"alm_oversea_supplier"
				"project_yusuan"
				
				};
		for(int i = 0;i<table.length;i++){
			if(StringUtils.isNotBlank(table[i])){
				BeanModel bm = bs.getBeanModel(table[i]);
				bm.setMuKuai("project");
	//			实体类
				Template t = TemFactory.getTem("BeanModel.ftl");
				File file1 = TemFactory.createFile(bm, "domain_");
				FileOutputStream fos = new FileOutputStream(file1);
				Writer out = new OutputStreamWriter(fos);
				t.process(bm, out);
				out.flush();
	//			dao
				t = TemFactory.getTem("DaoModel.ftl");
				file1 = TemFactory.createFile(bm, "dao_");
				fos = new FileOutputStream(file1);
				out = new OutputStreamWriter(fos);
				t.process(bm, out);
				out.flush();
	//			mapper
				t = TemFactory.getTem("DaoMapperModel.ftl");
				file1 = TemFactory.createFile(bm, bm.getLeiName()+"Mapper");
				fos = new FileOutputStream(file1);
				out = new OutputStreamWriter(fos);
				t.process(bm, out);
				out.flush();
	//			service
				t = TemFactory.getTem("ServiceModel.ftl");
				file1 = TemFactory.createFile(bm, "service_");
				fos = new FileOutputStream(file1);
				out = new OutputStreamWriter(fos);
				t.process(bm, out);
				out.flush();
	//			serviceimpl
				t = TemFactory.getTem("ServiceImplModel.ftl");
				file1 = TemFactory.createFile(bm, "serviceImpl_");
				fos = new FileOutputStream(file1);
				out = new OutputStreamWriter(fos);
				t.process(bm, out);
				out.flush();
	//			action
				t = TemFactory.getTem("ActionModel.ftl");
				file1 = TemFactory.createFile(bm, "action_");
				fos = new FileOutputStream(file1);
				out = new OutputStreamWriter(fos);
				t.process(bm, out);
				out.flush();
	//			xml
				t = TemFactory.getTem("XmlModel.ftl");
				file1 = TemFactory.createFile(bm, "xml_");
				fos = new FileOutputStream(file1);
				out = new OutputStreamWriter(fos);
				t.process(bm, out);
				out.flush();
			}
		}
	
		System.out.println("main方法结束。。。。。");
	}
	
	

}
