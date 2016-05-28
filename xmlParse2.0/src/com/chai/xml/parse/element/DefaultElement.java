package com.chai.xml.parse.element;

public class DefaultElement extends AbstractElement{

	public DefaultElement(String name,String className) {
		super(name,className);
	}
	public void initData() {
		super.initData();
	}
	public void finishData() {
		
	}
	public void putData(String key, Object data) {
		
	}
	public Object getData() {
		return this.getText();
	}

}
