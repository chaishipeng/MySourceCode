package com.chai.xml.parse.sax;

import java.io.InputStream;

import com.chai.xml.bound.parse.sax.SaxParseDefaultHandler;
import com.chai.xml.parse.element.Element;
import com.chai.xml.parse.element.ElementFactory;

public interface ParserReader {

	
	public Element read(InputStream is,SaxParseDefaultHandler defaultHandler);
	
	public void setElementFactory(ElementFactory elementFactory);
	
}



