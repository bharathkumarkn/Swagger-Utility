package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"displayName", "externalAuthorization", "operation"})
@XmlRootElement(name="OAuthV2")

public class OauthV2Bean {
	
    private String async;
    private String continueOnError;
    private String enabled;
    private String name;
    private String displayName;
    private String externalAuthorization;
    private String operation;
    
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
	
	@XmlElement(name= "DisplayName", required =true)
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	@XmlElement(name="ExternalAuthorization", required=true)
	public String getExternalAuthorization() {
		return externalAuthorization;
	}
	public void setExternalAuthorization(String externalAuthorization) {
		this.externalAuthorization = externalAuthorization;
	}
	
	@XmlElement(name="Operation", required=true)
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}


    
    
    
}
