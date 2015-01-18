package com.apigee.application;

import java.io.IOException;
import java.util.*;


import javax.annotation.Resources;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.apigee.messaging.config.beans.ApplicationBean;
import com.apigee.messaging.config.beans.ConfigurationVersionBean;
import com.apigee.messaging.config.beans.Policy;
import com.apigee.messaging.config.beans.ProxyEndpointBean;
import com.apigee.messaging.config.beans.ResourceBean;
import com.apigee.messaging.config.beans.TargetEndpointBean;
import com.apigee.swagger.ProxyObject;

public class ApplicationGenerator {

	private ProxyObject proxyObject  = new ProxyObject();
	
	public ApplicationGenerator(ProxyObject proxyObject) throws IOException {
	    this.proxyObject = proxyObject;
	}
	
	
	public void createProxy() throws JAXBException, IOException {
		
		JAXBContext jc = JAXBContext.newInstance(ApplicationBean.class);

		
		ApplicationBean applicationBean = new ApplicationBean();
		List<Policy> policies  = new ArrayList<Policy>();
		List<TargetEndpointBean> targetendpoints = new ArrayList<TargetEndpointBean>();
		List<ProxyEndpointBean> proxyEndpoints = new ArrayList<ProxyEndpointBean>();
		List<ResourceBean> resources = new ArrayList<ResourceBean>();
		ConfigurationVersionBean configurationVersion = new ConfigurationVersionBean();
		
		Long currentEpochTime = new Long(System.currentTimeMillis()/1000);
		
		configurationVersion.setMajorVersion("4");
		configurationVersion.setMinorVersion("0");
		
		applicationBean.setDisplayName(proxyObject.getApiBundleName());
		applicationBean.setRevision("1");
		applicationBean.setName(proxyObject.getApiBundleName());
		applicationBean.setConfigurationVersion(null);
		applicationBean.setCreatedAt(currentEpochTime.toString());
		applicationBean.setCreatedBy("admin@apigee.com");
		applicationBean.setDescription(proxyObject.getDescription());
		applicationBean.setDisplayName(proxyObject.getDisplayName());
		applicationBean.setLastModifiedAt(currentEpochTime.toString());
		applicationBean.setLastModifiedBy("admin@apigee.com");
		applicationBean.setPolicies(policies);
		applicationBean.setConfigurationVersion(configurationVersion);
		
		ProxyEndpointBean proxyEndpointBean = new ProxyEndpointBean();
		proxyEndpointBean.setProxyName("default");
		
		TargetEndpointBean targetEndpointBean = new TargetEndpointBean();
		targetEndpointBean.setTargetName("default");
		
		ResourceBean res = new ResourceBean();
		res.setResourceName("yaml://_SwaggerYaml.yaml");
		resources.add(res);
		

		
		targetendpoints.add(targetEndpointBean);
		proxyEndpoints.add(proxyEndpointBean);
		
		applicationBean.setPolicies(policies);
		applicationBean.setTargetEndpoints(targetendpoints);
		applicationBean.setProxyEndpointBeans(proxyEndpoints);
		applicationBean.setResources(resources);
		
		String proxyLocation = proxyObject.getApiBundleLocation()+"/"+proxyObject.getApiBundleName() + "/"+ "apiproxy" + "/";
		
	    Xml xml = new Xml(proxyLocation, proxyObject.getApiBundleName()+".xml");
	    xml.generateXML(ApplicationBean.class, applicationBean);

		/**
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(applicationBean, System.out);
		**/
		
	}
	
	
	
	

}
