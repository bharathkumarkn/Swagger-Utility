package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

public class FlowBean {
	
    private String description;
    private DirectionalFlow requestFlow = new DirectionalFlow();
    private DirectionalFlow responseFlow = new DirectionalFlow();
    private String condition;
    private String name;
    
    @XmlAttribute
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
	
    @XmlElement(name = "Request")
    public DirectionalFlow getRequestFlow() {
        return requestFlow;
    }

    public void setRequestFlow(DirectionalFlow requestFlow) {
        this.requestFlow = requestFlow;
    }

    @XmlElement(name = "Response")
    public DirectionalFlow getResponseFlow() {
        return responseFlow;
    }

    public void setResponseFlow(DirectionalFlow responseFlow) {
        this.responseFlow = responseFlow;
    }
    
    @XmlElement(name = "Condition")
    public String getCondition() {
        return this.condition;
    }

    
    
}
