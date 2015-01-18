package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CacheKey")
public class CacheKeyBean {
	
	private String prefix;
	private KeyFragment keyFragment;

	@XmlElement
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	@XmlElement
	public KeyFragment getKeyFragment() {
		return keyFragment;
	}

	public void setKeyFragment(KeyFragment keyFragment) {
		this.keyFragment = keyFragment;
	}
	
	
	

}
