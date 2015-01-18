package com.apigee.swagger;

import java.util.*;

public class ResourceObjects {
	

	private String path;
	private Map<String, OperationsObject> operations;
	
	private boolean quota;
	private boolean cache;
	private boolean oauth;
	private boolean spike;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Map<String, OperationsObject> getOperations() {
		return operations;
	}
	public void setOperations(Map<String, OperationsObject> operations) {
		this.operations = operations;
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
