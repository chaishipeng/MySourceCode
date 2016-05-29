package com.chai.xml.parse.element;

import java.util.Properties;


public interface ElementFactory {

	public Element createElement(String elementName);
	
	public void registerElement(String elementName,Class className);
	
	public void setClassNameProperties(Properties classNameProperties);

	public void setElementParseProperties(Properties elementParseProperties);
	
	public void setElementTagAliasParseProperties(Properties elementParseProperties);
	
	public void registerValueConvertHandler(Class class0,ValueConvertHandler valueConvertHandler);
	
	public Object convertValue(Object text,Class requireType);
	
}
