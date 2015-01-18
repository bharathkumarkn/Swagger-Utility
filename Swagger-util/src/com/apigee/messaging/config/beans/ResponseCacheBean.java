package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"displayName", "scope", "expirySetting"})
@XmlRootElement(name="ResponseCache")
public class ResponseCacheBean {
	
    private String displayName;
    private CacheKeyBean cachekey;
    private ExpirySettings expirySetting;
    private String scope;
    private String async;
    private String continueOnError;
    private String enabled;
    private String name;
    
    
    @XmlAttribute
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	@XmlElement(name="CacheKey", required=true)
	public CacheKeyBean getCachekey() {
		return cachekey;
	}

	public void setCachekey(CacheKeyBean cachekey) {
		this.cachekey = cachekey;
	}

	@XmlElement(name="ExpirySettings" ,required=true)
	public ExpirySettings getExpirySetting() {
		return expirySetting;
	}

	public void setExpirySetting(ExpirySettings expirySetting) {
		this.expirySetting = expirySetting;
	}

	@XmlElement(name="Scope", required=true)
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

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

	
    
    
}
