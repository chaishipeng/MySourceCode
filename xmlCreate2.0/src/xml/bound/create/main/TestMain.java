package xml.bound.create.main;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xml.bound.create.element.Element;
import xml.bound.create.element.IncludeElement;
import xml.bound.create.element.ListElement;
import xml.bound.create.element.SegmentElement;
import xml.bound.create.element.XMLElementBoundFactory;
import xml.bound.create.element.XMLElementFactory;
import xml.bound.create.element.XmlTagElement;
import xml.bound.create.handler.IncludeElementHandler;
import xml.bound.create.io.Reader;
import xml.bound.sax.SaxDefaultHandler;
import xml.bound.sax.SaxReader;
import xml.bound.util.DataUtil;

public class TestMain {

	
	public static void main(String args[]){
		
		InputStream ish = TestMain.class.getResourceAsStream("exmaple.xml");
		
		
		Reader reader = new SaxReader();
		
		XMLElementFactory factory = new XMLElementBoundFactory();
		factory.registerElement("List", ListElement.class);
		factory.registerElement("xmlTag", XmlTagElement.class);
		factory.registerElement("include", IncludeElement.class);
		factory.registerElement("segment", SegmentElement.class);
		
		reader.setElementFactory(factory);
		
		
		SaxDefaultHandler handler = new SaxDefaultHandler();
		handler.registerElementHandler("include", new IncludeElementHandler());

		
		
		
		Element ele = reader.read(ish,handler);
		
		InputStream segmentIs = TestMain.class.getResourceAsStream("segment.xml");
		
		SaxDefaultHandler handlerSegment = new SaxDefaultHandler();
		handler.registerElementHandler("include", new IncludeElementHandler());
		
		Element segmentEle = reader.read(segmentIs,handlerSegment);
		
		Map ElementMap = new HashMap();
		ElementMap.put("exmaple.xml", ele);
		ElementMap.put("segment.xml", segmentEle);
		
		
		Map map = new HashMap();
		map.put("TestString", "TestHandler");
		
		Map mapInner = new HashMap();
		mapInner.put("mapInner", "inneraaaaa");
		map.put("map", mapInner);
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		map.put("List", list);
		
		TestBean bean  = new TestBean();
		bean.setName("BeanName");
		map.put("TestBean", bean);
		map.put("UserSeq", 1);
		
		map.put("_TranName", "segment.xml");
		
		DataUtil.setIncludeElementMap(ElementMap);
		
		System.out.println(ele.asXML(map));
		
		
	}
	
}
