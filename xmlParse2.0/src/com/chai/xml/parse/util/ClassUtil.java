package com.chai.xml.parse.util;

public class ClassUtil {

	public static boolean isNeedConvert(Object data,Class requireType){
		
		if(data==null){
			return false;
		}
		if(data.getClass().equals(requireType)){
			return false;
		}
		return true;
		
	}
	
}
