package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.*;

public class RouteRuleBean {
    private String condition;
    private String url;
    private String targetEndpointName;
    private String name;
    
    
    @XmlAttribute
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RouteRuleBean() {
    }

    @XmlElement(name = "Condition")
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @XmlElement(name = "URL")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement(name = "TargetEndpoint")
    public String getTargetEndpointName() {
        return targetEndpointName;
    }

    public void setTargetEndpointName(String targetEndpointName) {
        this.targetEndpointName = targetEndpointName;
    }


}
