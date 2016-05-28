package com.chai.xml.parse.element;



public interface Element {

	
    public void setParent(Element element);
	
	public Element getParent();
	
	public void setText(String text);
	
	public void initData();
	
	public void finishData();
	
	public void putData(String key,Object data);
	
	public Object getData();
	
	public String getElementName();
	
	public void addChild(Element element);
	
	public ElementFactory getElementFactory();
	
	public void setElementFactory(ElementFactory elementFactory);
	
}
