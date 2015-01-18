package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlElement;


public class KeyFragment {
	
	private String ref;
	private String type;
	
	@XmlElement
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	@XmlElement
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
