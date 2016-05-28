package xml.bound.create.element;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

import xml.bound.util.DataUtil;

public abstract class AbstractElement implements Element{
	protected List<Element> elements;
	protected String elementName;
	protected String text;
	protected Element parent;
	protected String tagName;
	protected String name;
	protected Attributes attributes;

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public AbstractElement(String elementName){
		elements = new ArrayList<Element>();
		this.elementName = elementName;
		
		
	}
	
	public String asXML(Object data) {
		StringBuffer sb = new StringBuffer();
		sb.append("<").append(getXMLTagName()).append(">");
		if(elements.size()>0){
			sb.append("\r\n");
			for(Element element:elements){
				Object currentData = DataUtil.getCurrentData(data, element.getName());
				sb.append(element.asXML(currentData));
			}
		}else{
			
			sb.append(data==null?"":data);
			
		}
		sb.append("</").append(getXMLTagName()).append(">").append("\r\n");
		return sb.toString();
	}
	
	public String asText(Object data) {
		StringBuffer sb = new StringBuffer();
		if(elements.size()>0){
			for(Element element:elements){
				Object currentData = DataUtil.getCurrentData(data, element.getName());
				sb.append(element.asXML(currentData));
			}
		}else{
			
			sb.append(data==null?"":data);
			
		}
		return sb.toString();
	}
	
	
	public String getXMLTagName(){
		
		return getTagName()==null?getElementName():getTagName();
	}
	
	
	public List<Element> getChilds() {
		return elements;
	}
	public void addChild(Element element) {
		elements.add(element);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public String getText() {
		return this.text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public void setParent(Element element) {
		element.addChild(this);
		this.parent = element;
	}

	public Element getParent(){
		return this.parent;
	}

	
}
