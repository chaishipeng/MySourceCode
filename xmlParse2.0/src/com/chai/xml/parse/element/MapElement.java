package com.chai.xml.parse.element;

import java.util.Map;

import com.chai.xml.ele.datahelper.Merge2ParentMap;

public class MapElement extends AbstractElement{

	public MapElement(String name, String className) {
		super(name, className);
	}
	public void initData() {

         super.initData();
		
	}

	public void finishData() {
		// TODO Auto-generated method stub
		
	}

	public void putData(String key, Object data) {
		Map map  = (Map)this.data;
		if(data!=null&&data instanceof Merge2ParentMap){
			
			map.putAll((Map)data);
			
		}else{
		   map.put(key, data);
		}
		
	}

}
