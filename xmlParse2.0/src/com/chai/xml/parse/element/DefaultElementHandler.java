package com.chai.xml.parse.element;



public class DefaultElementHandler implements ElementHandler{

	public void onStart(Element element) {
		
		element.initData();
		
	}

	public void onEnd(Element element) {
		
		element.finishData();
		if(element.getParent()!=null){
			element.getParent().putData(element.getElementName(), element.getData());
		}
		
	}

}
