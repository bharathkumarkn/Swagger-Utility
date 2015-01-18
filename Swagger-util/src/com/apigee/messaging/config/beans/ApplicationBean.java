package com.apigee.messaging.config.beans;

import java.util.*;

import javax.annotation.Resource;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="APIProxy")
public class ApplicationBean {
	
	 
 	
    private String description;
    private ConfigurationVersionBean configurationVersion;
    private String createdAt;
    private String createdBy;
    private String displayName;
    private String lastModifiedAt;
    private String lastModifiedBy;
    private List<Policy> policies;
    private List<ProxyEndpointBean> proxyEndpointBeans;
    private List<TargetEndpointBean> targetEndpoints;
    private List<ResourceBean> resources;
    private String revision;
    private String name;
    
    
	@XmlElement(name = "Description")    
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	@XmlElement(name = "CreatedAt")	
	public String getCreatedAt() {
		return createdAt;
	}
	
	@XmlElement(name = "ConfigurationVersion")
	public ConfigurationVersionBean getConfigurationVersion() {
		return configurationVersion;
	}
	public void setConfigurationVersion(
			ConfigurationVersionBean configurationVersion) {
		this.configurationVersion = configurationVersion;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	@XmlElement(name = "CreatedBy")	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@XmlElement(name = "DisplayName")	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	@XmlElement(name = "LastModifiedAt")
	public String getLastModifiedAt() {
		return lastModifiedAt;
	}
	public void setLastModifiedAt(String lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	@XmlElement(name = "LastModifiedBy")
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
	@XmlElementWrapper(name = "Policies")
	@XmlElement(name = "Policy", required = true)
	public List<Policy> getPolicies() {
		return policies;
	}
	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}
	

	@XmlElementWrapper(name = "TargetEndpoints")
	@XmlElement(name = "TargetEndpoint", required = true)
	public List<TargetEndpointBean> getTargetEndpoints() {
		return targetEndpoints;
	}
	public void setTargetEndpoints(List<TargetEndpointBean> targetEndpoints) {
		this.targetEndpoints = targetEndpoints;
	}
	
	@XmlElementWrapper(name = "ProxyEndpoints")
	@XmlElement(name = "ProxyEndpoint", required = true)
	public List<ProxyEndpointBean> getProxyEndpointBeans() {
		return proxyEndpointBeans;
	}
	public void setProxyEndpointBeans(List<ProxyEndpointBean> proxyEndpointBeans) {
		this.proxyEndpointBeans = proxyEndpointBeans;
	}
	
	@XmlElementWrapper(name = "Resources")
	@XmlElement(name = "Resource", required = true)
	public List<ResourceBean> getResources() {
		return resources;
	}
	public void setResources(List<ResourceBean> resources) {
		this.resources = resources;
	}
	@XmlAttribute
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}    
    


}
