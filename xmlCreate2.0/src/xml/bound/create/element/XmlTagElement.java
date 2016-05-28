package xml.bound.create.element;

import xml.bound.util.DataUtil;

public class XmlTagElement extends AbstractElement{

	public XmlTagElement(String name) {
		super(name);
	}

	public String asXML(Object data) {
		StringBuffer sb = new StringBuffer();
		sb.append("<").append(getXMLTagName()).append(">");
		if(elements.size()>0){
			for(Element element:elements){
				Object currentData = DataUtil.getCurrentData(data, element.getName());
				sb.append(element.asText(currentData));
			}
		}else{
			
			sb.append(data==null?"":data);
			
		}
		sb.append("</").append(getXMLTagName()).append(">").append("\r\n");
		return sb.toString();
	}
	
}
