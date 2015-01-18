package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(propOrder={"displayName", "rate"})
@XmlRootElement(name="SpikeArrest")

public class SpikeArrestBean {
	
		
	    private String async;
	    private String continueOnError;
	    private String enabled;
	    private String name;
	    private String displayName;
	    private String rate;
	    
	    @XmlAttribute
	    public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
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
		@XmlElement(name="DisplayName", required=true)
		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
		
		@XmlElement(name="Rate", required=true)
		public String getRate() {
			return rate;
		}

		public void setRate(String rate) {
			this.rate = rate;
		}
	
		
	
    
    
}
