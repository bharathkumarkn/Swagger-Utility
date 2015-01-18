package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlAttribute;

public class AllowQuotaBean {
	
	private String count;
	
	@XmlAttribute
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	
}
