package xml.bound.create.element;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

public class XMLElementFactory implements ElementFactory{

	
	public Element createElement(String elementName) {
		
		return new DefaultElement(elementName);
	}

	public List<Attribute> createAttributes(Attributes attributes) {
		List list = new ArrayList(attributes.getLength());
		for(int i=0;i<attributes.getLength();i++){
			
			String key = attributes.getQName(i);
			String value = attributes.getValue(i);
			Attribute attr = createAttribute(key,value);
			list.add(attr);
			
		}
		return list;
	}
	
	protected Attribute createAttribute(String key,String value){
		
		return new SimpleAttribute(key,value);
		
	}

	public void registerElement(String elementName, Class className) {
		// TODO Auto-generated method stub
		
	}

}
