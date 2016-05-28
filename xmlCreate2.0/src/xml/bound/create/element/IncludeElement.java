package xml.bound.create.element;

import java.util.List;

import xml.bound.util.DataUtil;

public class IncludeElement extends AbstractElement{

	public IncludeElement(String name) {
		super(name);
	}

	public String asXML(Object data) {
		
		Object keyData = DataUtil.getCurrentData(data, key);
		if(keyData!=null){
			
			Element element = DataUtil.getIncludeElement(keyData.toString());
			if(element!=null){
			   return element.asXML(data);
			}
		}
		
		return "";
	}
	
	public String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
