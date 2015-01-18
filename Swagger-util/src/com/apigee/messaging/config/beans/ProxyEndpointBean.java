package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="ProxyEndpoint")
public class ProxyEndpointBean {
	
	private String proxyName;
	
	
	@XmlValue	
	public String getProxyName() {
		return proxyName;
	}
	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}

	
	
		

}
