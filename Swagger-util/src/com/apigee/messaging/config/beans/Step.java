package com.apigee.messaging.config.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "Step")
public class Step {
	
    private String stepName;
    private String condition;
    private String faultRules;
    
    @XmlElement(name = "Name", required = true)
    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    @XmlElement(name = "Condition")
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @XmlElement(name="FaultRules", required=true)
	public String getFaultRules() {
		return faultRules;
	}

	public void setFaultRules(String faultRules) {
		this.faultRules = faultRules;
	}
    
    

}
