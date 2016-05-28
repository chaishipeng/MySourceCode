package xml.bound.create.handler;

import xml.bound.create.element.Element;

public interface ElementHandler {

	
	public void onStart(Element element);
	
	public void onEnd(Element element);
	
	
}
