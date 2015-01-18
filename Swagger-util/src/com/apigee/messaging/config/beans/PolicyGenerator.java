package com.apigee.messaging.config.beans;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


import javax.annotation.Resources;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.apigee.application.PolicyConstants;
import com.apigee.application.Xml;
import com.apigee.swagger.OperationsObject;
import com.apigee.swagger.ProxyObject;
import com.apigee.swagger.ResourceObjects;

public class PolicyGenerator {

	private ProxyObject proxyObject  = new ProxyObject();
	
	public PolicyGenerator(ProxyObject proxyObject) throws IOException {
	    this.proxyObject = proxyObject;
	}
	
	
	public void createPolicies() throws JAXBException, IOException {
		
		JAXBContext jc = JAXBContext.newInstance(ApplicationBean.class);

				
		HashMap<String, OperationsObject> operations;
		OperationsObject operationsObject = new OperationsObject();
		
		List<ResourceObjects> resources = proxyObject.getResources();


		for (int i = 0; i<resources.size(); i++){
			
			ResourceObjects resource = resources.get(i);
			

			
			if(resource.isOauth()){
				OauthV2Bean oauth = new OauthV2Bean();
				oauth.setAsync(PolicyConstants.ASYNC);
				oauth.setContinueOnError(PolicyConstants.CONTINUEONERROR);
				oauth.setDisplayName(PolicyConstants.OAUTH_DisplayName);
				oauth.setEnabled(PolicyConstants.ENABLED);
				oauth.setName(PolicyConstants.OAUTH_PolicyName);
				oauth.setExternalAuthorization(PolicyConstants.EXTERNALAUTHORIZATION);
				oauth.setOperation(PolicyConstants.OAUTH_OPERATION);
				
				String proxyLocation = proxyObject.getApiBundleLocation()+"/"+proxyObject.getApiBundleName() + "/"+ "apiproxy";
			    Xml xml = new Xml(proxyLocation, "/policies/"+ PolicyConstants.OAUTH_PolicyName+".xml");

			    xml.generateXML(OauthV2Bean.class, oauth);
				
								
			}else if(resource.isQuota()){
				QuotaBean quota = new QuotaBean();
				AllowQuotaBean allow = new AllowQuotaBean();
				quota.setAsync(PolicyConstants.ASYNC);
				quota.setContinueOnError(PolicyConstants.CONTINUEONERROR);
				quota.setDisplayName(PolicyConstants.QUOTA_DisplayName);
				quota.setEnabled(PolicyConstants.ENABLED);
				quota.setName(PolicyConstants.QUOTA_PolicyName);
				allow.setCount(new Integer(proxyObject.getxVolosQuota().getAllowCount()).toString());
				quota.setAllow(allow);
				quota.setInterval(new Integer(proxyObject.getxVolosQuota().getInterval()).toString());
				quota.setDistributed(PolicyConstants.QUOTA_Distrubuted);
				quota.setSynchronous(PolicyConstants.QUOTA_Synchronous);
				quota.setTimeUnit(proxyObject.getxVolosQuota().getTimeUnit());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = format.format( new Date()   );

				quota.setStartTime(dateString);
				quota.setType("calendar");
				String proxyLocation = proxyObject.getApiBundleLocation()+"/"+proxyObject.getApiBundleName() + "/"+ "apiproxy";
			    Xml xml = new Xml(proxyLocation, "/policies/"+ PolicyConstants.QUOTA_PolicyName+".xml");

			    xml.generateXML(QuotaBean.class, quota);				
								
			}else if(resource.isSpike()){
				SpikeArrestBean spikeArrest = new SpikeArrestBean();
				spikeArrest.setAsync(PolicyConstants.ASYNC);
				spikeArrest.setContinueOnError(PolicyConstants.CONTINUEONERROR);
				spikeArrest.setDisplayName(PolicyConstants.SPIKEARREST_DisplayName);
				spikeArrest.setEnabled(PolicyConstants.ENABLED);
				spikeArrest.setName(PolicyConstants.SPIKEARREST_PolicyName);
				String allow =new Integer(proxyObject.getxVolosSpikeArrest().getAllow()).toString();
				String timeUnit = proxyObject.getxVolosSpikeArrest().getTimeUnit();
				String rate="";
				if(timeUnit.equalsIgnoreCase("minute")){
					rate=allow + PolicyConstants.SPIKEARREST_TimeUnit_Minute;
				} else if(timeUnit.equalsIgnoreCase("seconds")){
					rate=allow + PolicyConstants.SPIKEARREST_TimeUnit_Seconds;
				}
				spikeArrest.setRate(rate);
				String proxyLocation = proxyObject.getApiBundleLocation()+"/"+proxyObject.getApiBundleName() + "/"+ "apiproxy";
			    Xml xml = new Xml(proxyLocation, "/policies/"+ PolicyConstants.SPIKEARREST_PolicyName+".xml");

			    xml.generateXML(SpikeArrestBean.class, spikeArrest);
				
								
			}

			
		}
		

		/**
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(applicationBean, System.out);
		**/
		
	}
	
	
	
	

}
