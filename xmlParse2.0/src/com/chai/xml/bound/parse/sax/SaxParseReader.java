package com.chai.xml.bound.parse.sax;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.chai.xml.parse.element.Element;
import com.chai.xml.parse.element.ElementFactory;
import com.chai.xml.parse.sax.ParserReader;

public class SaxParseReader implements ParserReader{

	@Override
	public Element read(InputStream is, SaxParseDefaultHandler defaultHandler) {
		SAXParser parser = getParser();
		
		defaultHandler.setElementFactory(elementFactory);
		
		try {
			parser.parse(is, defaultHandler);
			return defaultHandler.getRoot();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ElementFactory elementFactory;

	public ElementFactory getElementFactory() {
		return elementFactory;
	}

	public void setElementFactory(ElementFactory elementFactory) {
		this.elementFactory = elementFactory;
	}
     public SAXParser getParser(){
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			return factory.newSAXParser();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
