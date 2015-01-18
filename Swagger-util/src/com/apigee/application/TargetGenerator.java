package com.apigee.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.apigee.messaging.config.beans.DirectionalFlow;
import com.apigee.messaging.config.beans.FlowBean;
import com.apigee.messaging.config.beans.HttpTargetConnection;
import com.apigee.messaging.config.beans.RouteRuleBean;
import com.apigee.messaging.config.beans.Step;
import com.apigee.messaging.config.beans.TargetBean;
import com.apigee.swagger.ProxyObject;

public class TargetGenerator {
	private ProxyObject proxyObject  = new ProxyObject();
	
    public TargetGenerator(ProxyObject proxyObject) throws IOException {
        this.proxyObject = proxyObject;
    }

	
    public void createTarget() throws JAXBException, IOException {


	JAXBContext jc = JAXBContext.newInstance(TargetBean.class);
	
	TargetBean targetBean = new TargetBean();
	DirectionalFlow preFlow = new DirectionalFlow();
	DirectionalFlow postFlow = new DirectionalFlow();
	HttpTargetConnection httpTarget = new HttpTargetConnection();
	Step step = new Step();
	FlowBean flow = new FlowBean();
	ArrayList<FlowBean> flows = new ArrayList<FlowBean>();
	RouteRuleBean routeRule = new RouteRuleBean();
	

	
	
	preFlow.setRequest(step);
	preFlow.setName("PreFlow");	
	preFlow.setResponse(step);
	
	postFlow.setName("PostFlow");
	postFlow.setRequest(step);
	postFlow.setRequest(step);
	
	targetBean.setName("default");
	
	targetBean.setPreFlow(preFlow);
	targetBean.setPostFlow(postFlow);
	targetBean.setDescription("proxy generated from Swagger Version:"+proxyObject.getSwaggerVersion());
	

	
	String[] schemes = proxyObject.getSchemes();
	String httpScheme = schemes[0];
	String url = httpScheme + "://" + proxyObject.getHost();
	
	httpTarget.setUrl(url);

	targetBean.setHttpTargetConnections(httpTarget);
	
	String proxyLocation = proxyObject.getApiBundleLocation()+"/"+proxyObject.getApiBundleName() + "/"+ "apiproxy";
	

	
	targetBean.setFlows(flows);
	
    Xml xml = new Xml(proxyLocation, "/targets/default.xml");
    xml.generateXML(TargetBean.class, targetBean);
    /**
	Marshaller marshaller = jc.createMarshaller();
	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	marshaller.marshal(targetBean, System.out);
	**/
    }

}
