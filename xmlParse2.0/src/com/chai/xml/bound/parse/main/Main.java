package com.chai.xml.bound.parse.main;

import java.io.InputStream;
import java.util.Properties;

import com.chai.xml.bound.parse.sax.SaxParseDefaultHandler;
import com.chai.xml.bound.parse.sax.SaxParseReader;
import com.chai.xml.parse.element.BeanElement;
import com.chai.xml.parse.element.ElementFactory;
import com.chai.xml.parse.element.ListElement;
import com.chai.xml.parse.element.MapElement;
import com.chai.xml.parse.element.XMLElementFactory;
import com.chai.xml.parse.sax.ParserReader;

public class Main {

	public static void main(String args[]) throws Exception{
		
		InputStream ish = Main.class.getResourceAsStream("exmaple.xml");
		
		//factory single
		ElementFactory factory = new XMLElementFactory();
		
		Properties classNamePro = new Properties();
		classNamePro.load(Main.class.getResourceAsStream("elementClassNameProperties.properties"));
		
		Properties elementParsePro = new Properties();
		elementParsePro.load(Main.class.getResourceAsStream("elementParseProperties.properties"));
		
		Properties elementAliasPro = new Properties();
		elementAliasPro.load(Main.class.getResourceAsStream("elementParseProperties.properties"));
		
		factory.setClassNameProperties(classNamePro);
		factory.setElementParseProperties(elementParsePro);
		factory.setElementTagAliasParseProperties(elementAliasPro);
		
		factory.registerElement("Map", MapElement.class);
		factory.registerElement("List", ListElement.class);
		factory.registerElement("Bean", BeanElement.class);
		//factory
		
		ParserReader reader = new SaxParseReader();
		reader.setElementFactory(factory);
		
		SaxParseDefaultHandler handler = new SaxParseDefaultHandler();
		
		reader.read(ish, handler);
		
		System.out.println(handler.getRoot().getData());
		
	}
	
}
