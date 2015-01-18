package com.apigee.swagger;

import java.util.*;

public class OperationsObject {
	
	String verb;
	String path;
	String[] produces;
	List<ParametersObject> parameters;
	String description;
	String operationId;
	boolean quota;
	boolean cache;
	boolean oauth;
	boolean spike;

	
	public String getVerb() {
		return verb;
	}
	public void setVerb(String verb) {
		this.verb = verb;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String[] getProduces() {
		return produces;
	}
	public void setProduces(String[] produces) {
		this.produces = produces;
	}
	public List<ParametersObject> getParameters() {
		return parameters;
	}
	public void setParameters(List<ParametersObject> parameters) {
		this.parameters = parameters;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOperationId() {
		return operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public boolean isQuota() {
		return quota;
	}
	public void setQuota(boolean quota) {
		this.quota = quota;
	}
	public boolean isCache() {
		return cache;
	}
	public void setCache(boolean cache) {
		this.cache = cache;
	}
	public boolean isOauth() {
		return oauth;
	}
	public void setOauth(boolean oauth) {
		this.oauth = oauth;
	}
	public boolean isSpike() {
		return spike;
	}
	public void setSpike(boolean spike) {
		this.spike = spike;
	}
	
	
 
}
