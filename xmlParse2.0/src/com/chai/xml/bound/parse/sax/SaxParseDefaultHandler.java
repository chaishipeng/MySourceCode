package com.chai.xml.bound.parse.sax;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.chai.xml.parse.element.DefaultElementHandler;
import com.chai.xml.parse.element.Element;
import com.chai.xml.parse.element.ElementFactory;
import com.chai.xml.parse.element.ElementHandler;

public class SaxParseDefaultHandler extends DefaultHandler{

	protected String currentElementName;
	
	protected StringBuilder currentElementTextSB;

	protected Element currentElement;
	
	protected boolean isParentFlag = false;
	
	public ElementFactory elementFactory;
	
   protected Map<String,ElementHandler> elementHandlers = new HashMap<String,ElementHandler>();
	
	private ElementHandler defaultElementHandler = new DefaultElementHandler();
	
	public ElementHandler getDefaultElementHandler() {
		return defaultElementHandler;
	}


	public void setDefaultElementHandler(ElementHandler defaultElementHandler) {
		this.defaultElementHandler = defaultElementHandler;
	}

	public void registerElementHandler(String name,ElementHandler handeler){
		elementHandlers.put(name, handeler);
	}

	public ElementFactory getElementFactory() {
		return elementFactory;
	}

	public void setElementFactory(ElementFactory elementFactory) {
		this.elementFactory = elementFactory;
	}
	public Element getRoot(){
		Element root = this.currentElement.getParent()==null?this.currentElement:this.currentElement.getParent();
		return root;
	}
	public void startElement (String uri, String localName,
            String qName, Attributes attributes)throws SAXException
	{
		
		Element element;
	    if(isParentFlag){
	    	
	    	Element parentElement = this.currentElement;
	    	element = getElementFactory().createElement(qName);
	    	if(parentElement!=null){
	    	   element.setParent(parentElement);
	    	}
	    	
	    	
	    }else{
	    	
	    	 element = getElementFactory().createElement(qName);
	    	 isParentFlag = true;
	    	 if(this.currentElement!=null){
		    	 //Element parentElement = this.currentElement.getParent();
		    	 element.setParent(this.currentElement);
	    	 }
	    	
	    }
	    
	    if(getDefaultElementHandler()!=null){
	    	getDefaultElementHandler().onStart(element);
	    }
	    ElementHandler handler = elementHandlers.get(qName);
		 if(handler!=null){
			 handler.onStart(this.currentElement);
		 }
	    
	    this.currentElementName = qName;
	    this.currentElement = element;
	    currentElementTextSB = new StringBuilder();
		
	}
	 public void endElement (String uri, String localName, String qName)
		        throws SAXException{
		      
		 isParentFlag = false;
		 if(currentElementTextSB!=null){
		    this.currentElement.setText(currentElementTextSB.toString());
		 }
		 currentElementTextSB = null;
		 if(getDefaultElementHandler()!=null){
		    	getDefaultElementHandler().onEnd(this.currentElement);
		    }
		 ElementHandler handler = elementHandlers.get(qName);
		 if(handler!=null){
			 handler.onEnd(this.currentElement);
		 }
		 
		 Element parentElement = this.currentElement.getParent();
		 if(parentElement!=null){
			 this.currentElement = parentElement;
    	 }
		 
	 }
     public void characters (char ch[], int start, int length)
		        throws SAXException
     {
    	 if(currentElementTextSB!=null){
    	    currentElementTextSB.append(new String(ch,start,length));
    	 }
	 }
}
