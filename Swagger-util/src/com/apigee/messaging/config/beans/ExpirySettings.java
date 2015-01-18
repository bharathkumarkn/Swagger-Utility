package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ExpirySettings {
	
	private String expiryDate;
	private String timeOfDay;
	private String timeoutInSec;
	
	@XmlElement(name="ExpiryDate")
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	@XmlElement(name="TimeOfDay")
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	@XmlElement(name="TimeoutInSec")
	public String getTimeoutInSec() {
		return timeoutInSec;
	}
	public void setTimeoutInSec(String timeoutInSec) {
		this.timeoutInSec = timeoutInSec;
	}
	
	
	
}
