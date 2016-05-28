package xml.bound.create.handler;

import java.lang.reflect.Field;

import org.xml.sax.Attributes;

import xml.bound.create.element.Element;

public class DefaultElementHandler implements ElementHandler{

	public void onStart(Element element) {
		Attributes attributes = element.getAttributes();
		if(attributes!=null){
			
			int length = attributes.getLength();
			for(int i = 0;i<length;i++){
				
				Class elementClass = element.getClass();
				while(elementClass!=Object.class){
					
					try {
						Field field = elementClass.getDeclaredField(attributes.getQName(i));
						if(field.getType().equals(String.class)){
							field.setAccessible(true);
							field.set(element, attributes.getValue(i));
							break;
						}
					} catch (Throwable e) {
						
					}
					elementClass = elementClass.getSuperclass();
				}
				
			}
		}
		
	}

	public void onEnd(Element element) {
		
		
	}

}
