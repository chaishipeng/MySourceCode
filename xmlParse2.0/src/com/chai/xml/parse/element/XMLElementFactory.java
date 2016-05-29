package com.chai.xml.parse.element;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.chai.xml.parse.exception.ParseRuntimeException;

public class XMLElementFactory implements ElementFactory{

	public Properties classNameProperties;
	
	public Properties elementParseProperties;
	
	public Properties elementTagAliasProperties;
	
	public Properties getClassNameProperties() {
		return classNameProperties;
	}

	public void setClassNameProperties(Properties classNameProperties) {
		this.classNameProperties = classNameProperties;
	}

	public Properties getElementParseProperties() {
		return elementParseProperties;
	}

	public void setElementParseProperties(Properties elementParseProperties) {
		this.elementParseProperties = elementParseProperties;
	}

	public Map<String,Class> elementClassMap = new HashMap<String,Class>();
	
	public Map<Class,ValueConvertHandler> valueConvertHandlerMap = new HashMap<Class,ValueConvertHandler>();
	
	public Element createElement(String elementName) {
		
		String tagAliasName = elementTagAliasProperties.getProperty(elementName);
		if(tagAliasName!=null){
			elementName = tagAliasName;
		}
		
		String className = classNameProperties.getProperty(elementName);
		
		String elementParseName = elementParseProperties.getProperty(elementName);
		if(elementParseName==null){
			elementParseName = elementName;
		}
		Class elementClass = elementClassMap.get(elementParseName);
		if(elementClass==null){
			elementClass = DefaultElement.class;
		}
		Element element = null;
		try {
			element = (Element) elementClass.getConstructor(String.class,String.class).newInstance(elementName,className);
		    
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(element!=null){
			element.setElementFactory(this);
		}
		
		return element;
	}

	public void registerElement(String elementName, Class className) {
		elementClassMap.put(elementName, className);
		
	}
	public void registerValueConvertHandler(Class class0,
			ValueConvertHandler valueConvertHandler) {
		valueConvertHandlerMap.put(class0, valueConvertHandler);
		
	}

	public Object convertValue(Object text, Class requireType) {
		if(text==null){
			return null;
		}
		if(String.class.equals(requireType)){
			return text.toString();
		}
		if(requireType.isEnum()){
			Enum t[] = (Enum[])requireType.getEnumConstants();
			for(Enum enum0:t){
				
				if(enum0.toString().equals(text.toString())){
					
					return enum0;
					
				}
				
				
			}
			
		}
		
		ValueConvertHandler handler = valueConvertHandlerMap.get(requireType);
		if(handler==null){
			throw new ParseRuntimeException(requireType.getName()+" need to be register to ElementFactory!!!");
		}
		
		return handler.convertValue(text);
	}

	@Override
	public void setElementTagAliasParseProperties(
			Properties elementParseProperties) {
		this.elementTagAliasProperties = elementParseProperties;
		
	}
	
	
	

}
