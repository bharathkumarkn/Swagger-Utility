package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"displayName", "allow", "interval", "distributed", "synchronous", "timeUnit", "startTime"})
@XmlRootElement(name="Quota")
public class QuotaBean {
	
    private String async;
    private String continueOnError;
    private String enabled;
    private String name;
    private String displayName;
    private String type;    
    private AllowQuotaBean allow;
    private String interval;
    private String distributed;
    private String synchronous;
    private String timeUnit;
    private String startTime;
    
    
    @XmlAttribute
	public String getAsync() {
		return async;
	}
	public void setAsync(String async) {
		this.async = async;
	}
	@XmlAttribute
	public String getContinueOnError() {
		return continueOnError;
	}
	public void setContinueOnError(String continueOnError) {
		this.continueOnError = continueOnError;
	}
	@XmlAttribute
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="DisplayName", required=true)
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	@XmlAttribute
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name="Allow", required=true)
	public AllowQuotaBean getAllow() {
		return allow;
	}
	public void setAllow(AllowQuotaBean allow) {
		this.allow = allow;
	}
	
	@XmlElement(name="Interval", required=true)
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	
	@XmlElement(name="Distributed", required=true)
	public String getDistributed() {
		return distributed;
	}
	public void setDistributed(String distributed) {
		this.distributed = distributed;
	}
	
	@XmlElement(name="Synchronous", required=true)
	public String getSynchronous() {
		return synchronous;
	}
	public void setSynchronous(String synchronous) {
		this.synchronous = synchronous;
	}
	@XmlElement(name="TimeUnit", required=true)	
	public String getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}
	
	@XmlElement(name="StartTime", required=true)	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
    
    
    
    
}
