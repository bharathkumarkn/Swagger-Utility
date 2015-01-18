package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlElement;

public class HttpTargetConnection {
	
	
    private String url;
    
    @XmlElement(name = "URL")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    


}
