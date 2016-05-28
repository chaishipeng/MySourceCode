package xml.bound.create.element;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class XMLElementBoundFactory extends XMLElementFactory{
	
	
	public Map<String,Class> elementClassMap = new HashMap<String,Class>();
	
    public Map<String, Class> getElementClassMap() {
		return elementClassMap;
	}

	public void setElementClassMap(Map<String, Class> elementClassMap) {
		this.elementClassMap = elementClassMap;
	}

	public Element createElement(String elementName) {
		
		Class className = elementClassMap.get(elementName);
		if(className==null){
			className = DefaultElement.class;
		}
		try {
			Element element = (Element) className.getConstructor(String.class).newInstance(elementName);
			return element;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new DefaultElement(elementName);
	}

	public void registerElement(String elementName, Class className) {
		elementClassMap.put(elementName, className);
		
	}
	
}
