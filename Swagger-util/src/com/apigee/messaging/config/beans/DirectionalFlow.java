package com.apigee.messaging.config.beans;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;


public class DirectionalFlow {
	
	
	private Step Request;
	private Step Response;
	private String name;
	
    private ArrayList<Step> step; 
	
	
	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "Request", required = true)
	public Step getRequest() {
		return Request;
	}

	public void setRequest(Step request) {
		Request = request;
	}
	@XmlElement(name = "Response", required = true)
	public Step getResponse() {
		return Response;
	}

	public void setResponse(Step response) {
		Response = response;
	}

	@XmlElement(name="Step")
	public ArrayList<Step> getStep() {
		return step;
	}

	public void setStep(ArrayList<Step> step) {
		this.step = step;
	}

	
	
	
	
	
	

}
