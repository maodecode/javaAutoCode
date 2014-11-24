package com.xy.common;

import java.io.File;
import java.io.IOException;

import com.xy.domain.BeanModel;
import com.xy.domain.CreateTypeEnum;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class TemFactory {
	public static Template getTem(String ftlname){
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(TemFactory.class, "../templates");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		Template temp = null;
		try {
			temp = cfg.getTemplate(ftlname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static File createFile(BeanModel bmodel,String genType){
		File directory = new File("");//参数为空
		String courseFile = null;
		File file1 = null; 
		try {
			courseFile = directory.getCanonicalPath();
			String filePath = "";
//			如果是生成service
			filePath = courseFile + "\\src\\com\\xy\\gencode\\"+bmodel.getLeiName()+"\\";
			file1 = new File(filePath);
			if(!file1.exists()){
				file1.mkdirs();
			}
			filePath = courseFile + "\\src\\com\\xy\\gencode\\"+bmodel.getLeiName()+"\\"+genType+".txt";
			file1 = new File(filePath);
			if(!file1.exists()){
				file1.createNewFile();
			}
			return file1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file1;
	}
	
}
