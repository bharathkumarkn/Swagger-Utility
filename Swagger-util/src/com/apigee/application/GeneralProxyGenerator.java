package com.apigee.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.util.*;

import com.apigee.messaging.config.beans.DirectionalFlow;
import com.apigee.messaging.config.beans.FlowBean;
import com.apigee.messaging.config.beans.HttpProxyConnection;
import com.apigee.messaging.config.beans.ProxyBean;
import com.apigee.messaging.config.beans.RouteRuleBean;
import com.apigee.messaging.config.beans.Step;
import com.apigee.swagger.*;


public class GeneralProxyGenerator {
	private ProxyObject proxyObject  = new ProxyObject();
	
    public GeneralProxyGenerator(ProxyObject proxyObject) throws IOException {
        this.proxyObject = proxyObject;
    }

	
    public void createProxy() throws JAXBException, IOException {
    	
    	


	JAXBContext jc = JAXBContext.newInstance(ProxyBean.class);
	
	ProxyBean proxyBean = new ProxyBean();
	DirectionalFlow preFlow = new DirectionalFlow();
	DirectionalFlow postFlow = new DirectionalFlow();

	Step step = new Step();
	FlowBean flow1 = new FlowBean();
	ArrayList<FlowBean> flows = new ArrayList<FlowBean>();
	HttpProxyConnection httpProxy = new HttpProxyConnection();
	RouteRuleBean routeRule = new RouteRuleBean();
	HashMap<String, OperationsObject> operations;
	OperationsObject operationsObject = new OperationsObject();
	List<ResourceObjects> resources = new ArrayList<ResourceObjects>();
	
	

	operations =(HashMap) proxyObject.getOperations();
	//System.out.println("Operations Object"+operations.size());



	List<String> keys =new ArrayList<String>(operations.keySet());
	for (String key: keys){
		FlowBean flow = new FlowBean();		
		DirectionalFlow requestFlow = new DirectionalFlow();				
		operationsObject  = operations.get(key);
		
		
		//System.out.println("PreoxyGENERATION**********KEYS"+key);

		String path = operationsObject.getPath();
		String verb = operationsObject.getVerb();
		String condition ="(proxy.pathsuffix MatchesPath " +  "\"" + path + "\"" + ") and (request.verb = " + "\"" + verb.toUpperCase() + "\"" +")";
		flow.setCondition(condition);
		flow.setDescription(operationsObject.getDescription());
		flow.setName(operationsObject.getOperationId());
		requestFlow.setRequest(step);
		requestFlow.setResponse(step);
		
		flows.add(flow);

		
		}

	

	
	proxyBean.setName("default");
	
	proxyBean.setDescription(proxyObject.getDescription());
	
	preFlow.setRequest(step);
	preFlow.setName("PreFlow");	
	preFlow.setResponse(step);
	
	postFlow.setRequest(step);
	postFlow.setName("PostFlow");	
	postFlow.setResponse(step);

	
	proxyBean.setPreFlow(preFlow);
	proxyBean.setPostFlow(postFlow);

	httpProxy.setBasePath(proxyObject.getBasePath());
    Collection<String> virtualHosts = new ArrayList<String>();

    virtualHosts.add("default");
	virtualHosts.add("secure");		
	httpProxy.addVirtualHosts(virtualHosts);
	
	proxyBean.setHttpProxyConnections(httpProxy);
	
	routeRule.setName("default");
	routeRule.setTargetEndpointName("default");
	
	proxyBean.setRouteRuleBean(routeRule);
	
	proxyBean.setFlows(flows);
	
	String proxyLocation = proxyObject.getApiBundleLocation()+"/"+proxyObject.getApiBundleName() + "/"+ "apiproxy";
	
    Xml xml = new Xml(proxyLocation, "/proxies/default.xml");
    xml.generateXML(ProxyBean.class, proxyBean);
    
    /**
	Marshaller marshaller = jc.createMarshaller();
	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	marshaller.marshal(proxyBean, System.out);
	**/
    }

}
