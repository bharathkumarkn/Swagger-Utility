package com.apigee.messaging.config.beans;
import javax.xml.bind.annotation.*;


public class ConfigurationVersionBean {
	
	private String majorVersion;
	private String minorVersion;

	@XmlAttribute
	public String getMajorVersion() {
		return majorVersion;
	}
	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}
	@XmlAttribute
	public String getMinorVersion() {
		return minorVersion;
	}
	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
	}
	
	
	
}
