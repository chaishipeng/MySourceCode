package com.chai.xml.parse.element;

import java.util.List;

public class ListElement extends AbstractElement{

	public ListElement(String name, String className) {
		super(name, className);
	}
	public void finishData() {
		// TODO Auto-generated method stub
		
	}

	public void putData(String key, Object data) {
		List list = (List)this.data;
		list.add(data);
	}

}
