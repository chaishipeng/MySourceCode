package xml.bound.create.element;

import java.util.List;

public class ListElement extends AbstractElement{

	public ListElement(String name) {
		super(name);
	}
	public String asXML(Object data) {
		StringBuffer sb = new StringBuffer();
		sb.append("<").append(getXMLTagName()).append(">");
		sb.append("\r\n");
		List dataList = (List) data;
		Element element = this.getChilds().get(0);
		for(Object mapData:dataList){
			
			sb.append(element.asXML(mapData));
			
			
		}
		
		sb.append("</").append(getXMLTagName()).append(">").append("\r\n");
		return sb.toString();
	}

}
