package xml.bound.sax;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xml.bound.create.element.Element;
import xml.bound.create.element.ElementFactory;
import xml.bound.create.element.XMLElementFactory;
import xml.bound.create.io.Reader;

public class SaxReader implements Reader{
	
	public ElementFactory elementFactory;

	public ElementFactory getElementFactory() {
		return elementFactory;
	}

	public void setElementFactory(ElementFactory elementFactory) {
		this.elementFactory = elementFactory;
	}

	//传入输入流以及saxhandler处理类，handler类必须非单例
	public Element read(InputStream is,SaxDefaultHandler defaultHandler) {
		//获取JAVA自带的解析器
		SAXParser parser = getParser();
		//装入ElementFactory（工厂可以单例）
		defaultHandler.setElementFactory(elementFactory);
		
		try {
			parser.parse(is, defaultHandler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return defaultHandler.getRoot();
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
