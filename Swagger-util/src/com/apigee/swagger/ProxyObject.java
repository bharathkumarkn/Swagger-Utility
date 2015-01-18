package com.apigee.swagger;

import java.util.*;

public class ProxyObject {
	
	String swaggerVersion;
	String description;
	String displayName;
	String host;
	String basePath;
	String[]  schemes;
	String apiVersion;
	String apiBundleName;
	String apiBundleLocation;
	VolosCache xVolosCache;
	VolosQuota xVolosQuota;
	VolosSpikeArrest xVolosSpikeArrest;
	boolean applyProlicies;
	Map<String, OperationsObject> operations;
	List<ResourceObjects> resources;
	String swaggerType;

	
	public Map<String, OperationsObject> getOperations() {
		return operations;
	}
	public void setOperations(Map<String, OperationsObject> operations) {
		this.operations = operations;
	}
	
	public String getSwaggerVersion() {
		return swaggerVersion;
	}
	public void setSwaggerVersion(String swaggerVersion) {
		this.swaggerVersion = swaggerVersion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getBasePath() {
		return basePath;
	}
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	public String[] getSchemes() {
		return schemes;
	}
	public void setSchemes(String[] schemes) {
		this.schemes = schemes;
	}
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getApiBundleName() {
		return apiBundleName;
	}
	public void setApiBundleName(String apiBundleName) {
		this.apiBundleName = apiBundleName;
	}
	public String getApiBundleLocation() {
		return apiBundleLocation;
	}
	public void setApiBundleLocation(String apiBundleLocation) {
		this.apiBundleLocation = apiBundleLocation;
	}
	public VolosCache getxVolosCache() {
		return xVolosCache;
	}
	public void setxVolosCache(VolosCache xVolosCache) {
		this.xVolosCache = xVolosCache;
	}
	public VolosQuota getxVolosQuota() {
		return xVolosQuota;
	}
	public void setxVolosQuota(VolosQuota xVolosQuota) {
		this.xVolosQuota = xVolosQuota;
	}
	public VolosSpikeArrest getxVolosSpikeArrest() {
		return xVolosSpikeArrest;
	}
	public void setxVolosSpikeArrest(VolosSpikeArrest xVolosApikeArrest) {
		this.xVolosSpikeArrest = xVolosApikeArrest;
	}
	public boolean isApplyProlicies() {
		return applyProlicies;
	}
	public void setApplyProlicies(boolean applyProlicies) {
		this.applyProlicies = applyProlicies;
	}
	public List<ResourceObjects> getResources() {
		return resources;
	}
	public void setResources(List<ResourceObjects> resources) {
		this.resources = resources;
	}
	public String getSwaggerType() {
		return swaggerType;
	}
	public void setSwaggerType(String swaggerType) {
		this.swaggerType = swaggerType;
	}
	
	
	

}
