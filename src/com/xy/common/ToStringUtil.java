package com.xy.common;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 *	打印一个对象的所有属性的内容
 */
public class ToStringUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	public static String getString(Object o) {  
		StringBuffer sb = new StringBuffer();  
		try{
			sb.append("Bean:");  
			Field[] farr = o.getClass().getDeclaredFields();  
			for (Field field : farr) {  
				try {  
					field.setAccessible(true);  
					sb.append(field.getName());  
					sb.append("=");  
					if (field.get(o) instanceof Date) {  
						// 日期的处理  
						sb.append(sdf.format(field.get(o)));  
					} else {  
						sb.append(field.get(o));  
					}  
					sb.append(" | ");  
				} catch (Exception e) {  
					e.printStackTrace();  
				}  
			}  
		}catch (Exception e) {
			// TODO: handle exception
		}
	    return sb.toString();  
	}
}

