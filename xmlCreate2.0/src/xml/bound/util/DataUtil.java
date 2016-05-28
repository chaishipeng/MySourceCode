package xml.bound.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import xml.bound.create.element.Element;

public class DataUtil {

	public static Object getCurrentData(Object data,String key){
		
		if(key==null){
			return data;
		}
		
		if(data instanceof Map){
			return ((Map)data).get(key);
		}else if(data instanceof List){
			
			return data;
			
		}else{
			
			Field[] fields = data.getClass().getDeclaredFields();
			for(Field field:fields){
				field.setAccessible(true);
				String filedName = field.getName();
				if(filedName.equals(key)){
					
					try {
						return field.get(data);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
			}
			
			
		}
		
		return data;
	}
	
	
	public static Element getIncludeElement(String key){
		return includeElementTL.get().get(key);
	}
	
	public static ThreadLocal<Map<String,Element>> includeElementTL = new ThreadLocal<Map<String,Element>>();
	
	public static void setIncludeElementMap(Map<String,Element> map){
		includeElementTL.set(map);
	}
	
}
