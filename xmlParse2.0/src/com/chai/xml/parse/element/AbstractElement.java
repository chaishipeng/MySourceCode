package com.chai.xml.parse.element;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractElement implements Element{

	public AbstractElement(String name,String className){
		
		this.elementName = name;
		this.className = className;
		this.elementChilds = new ArrayList();
	}
	
	public Element parent;
	public Element getParent() {
		return parent;
	}
	public void setParent(Element parent) {
		this.parent = parent;
		if(parent!=null){
			parent.addChild(this);
		}
	}
    public String text;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String elementName;
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public String className;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Object data;

	public void initData(){
		
		if(className!=null){
				try {
					data = Class.forName(className).newInstance();
				} catch (Throwable e) {
				
					throw new RuntimeException(e.getMessage());
					
				}
		}
		
	}
	public Object getData() {
		// TODO Auto-generated method stub
		return data;
	}
	
	public List elementChilds;
	
	public void addChild(Element element){
		this.elementChilds.add(element);
	}
	
	public ElementFactory elementFactory;
	public ElementFactory getElementFactory() {
		return elementFactory;
	}
	public void setElementFactory(ElementFactory elementFactory) {
		this.elementFactory = elementFactory;
	}
	
}
