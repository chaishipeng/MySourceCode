package xml.bound.create.element;

import java.util.List;

import org.xml.sax.Attributes;

public interface Element {

	public String asXML(Object data);
	
	public String asText(Object data);
	
	public List<Element> getChilds();
	
	public void addChild(Element element);
	
	public void setElementName(String name);
	
	public String getElementName();
	
	public  Attributes getAttributes();
	
	public void setAttributes(Attributes attributes);
	
	public String getText();
	
	public void setText(String text);
	
	public void setParent(Element element);
	
	public Element getParent();
	
	public String getTagName();
	
	public void setTagName(String tagName);
	
	public String getName();
	
	public void setName(String name);
	
	
}
