package com.chai.xml.parse.element;

import java.lang.reflect.Field;

import com.chai.xml.parse.util.ClassUtil;

public class BeanElement extends AbstractElement{

	public BeanElement(String name, String className) {
		super(name, className);
	}
	public void finishData() {
	
	}
	public void putData(String key, Object data) {
		
		String fieldName = (new StringBuilder()).append(Character.toLowerCase(key.charAt(0))).append(key.substring(1)).toString();
		try {
			Field field = this.data.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			Object realData = data;
			if(ClassUtil.isNeedConvert(data, field.getType())){
			
			    realData = this.getElementFactory().convertValue(data, field.getType());
			}
			
			field.set(this.data, realData);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
