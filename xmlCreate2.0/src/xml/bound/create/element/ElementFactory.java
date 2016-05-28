package xml.bound.create.element;

import java.util.List;

import org.xml.sax.Attributes;

public interface ElementFactory {

	public Element createElement(String elementName);
	
	public List<Attribute> createAttributes(Attributes attributes);
	
	public void registerElement(String elementName,Class className);
	
}
