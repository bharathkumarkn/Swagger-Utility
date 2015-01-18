package com.apigee.messaging.config.beans;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"description", "preFlow", "flows", "postFlow", "httpTargetConnections"})
@XmlRootElement(name="TargetEndpoint")
public class TargetBean {
	 
	 	
	    private String description;
	    private DirectionalFlow preFlow = new DirectionalFlow();
	    private DirectionalFlow postFlow = new DirectionalFlow();
	    private ArrayList<FlowBean> flows; 
	    private HttpTargetConnection httpTargetConnections;
	    private String name;
	    
	    @XmlElement(name = "Description")
		public String getDescription() {
			return description;
		}

		public void setDescription(String desc) {
			description = desc;
		}
		@XmlElement(name = "PreFlow", required = true)
		public DirectionalFlow getPreFlow() {
			return preFlow;
		}

		public void setPreFlow(DirectionalFlow preflow) {
			preFlow = preflow;
		}
		@XmlElement(name = "PostFlow", required = true)
		public DirectionalFlow getPostFlow() {
			return postFlow;
		}

		public void setPostFlow(DirectionalFlow postflow) {
			postFlow = postflow;
		}
		@XmlElementWrapper(name = "Flows")
		@XmlElement(name = "Flow", required = true)
		public ArrayList<FlowBean> getFlows() {
			return flows;
		}
		
		public void setFlows(ArrayList<FlowBean> flows) {
			this.flows = flows;
		}

		@XmlElement(name = "HTTPTargetConnection", required = true)
		public HttpTargetConnection getHttpTargetConnections() {
			return httpTargetConnections;
		}

		public void setHttpTargetConnections(HttpTargetConnection httpTargetConnections) {
			this.httpTargetConnections = httpTargetConnections;
		}

		@XmlAttribute
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	 
	    
}
