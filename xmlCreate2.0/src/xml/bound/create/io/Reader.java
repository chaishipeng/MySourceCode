package xml.bound.create.io;

import java.io.InputStream;

import xml.bound.create.element.Element;
import xml.bound.create.element.ElementFactory;
import xml.bound.sax.SaxDefaultHandler;

public interface Reader {

	
	public Element read(InputStream is,SaxDefaultHandler defaultHandler);
	
	public void setElementFactory(ElementFactory elementFactory);
	
}
