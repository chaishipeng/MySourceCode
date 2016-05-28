package xml.bound.create.element;

import xml.bound.util.DataUtil;

public class SegmentElement extends AbstractElement{

	public SegmentElement(String name) {
		super(name);
	}

     public String asXML(Object data) {
		
    	StringBuffer sb = new StringBuffer();
 		if(elements.size()>0){
 			for(Element element:elements){
 				Object currentData = DataUtil.getCurrentData(data, element.getName());
 				sb.append(element.asXML(currentData));
 			}
 		}
 		return sb.toString();
	}
	
	
}
