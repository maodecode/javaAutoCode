package com.xy.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Administrator
 *	直接获取spring中配置的bean，或者注解的bean
 */
public class SpringContextUtil {
	
	private static ApplicationContext context = null;
	private SpringContextUtil(){
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
	}
	private static SpringContextUtil instance = new SpringContextUtil();
	public static SpringContextUtil getInstance(){
		return instance;
	}
	public static Object getBean(String id){
		return context.getBean(id);
	}
	
}