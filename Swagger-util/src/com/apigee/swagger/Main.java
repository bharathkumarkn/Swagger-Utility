package com.apigee.swagger;

import java.io.*;
import java.util.*;


import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import com.apigee.application.APIProxyMain;

public class Main implements DeploymentUtilityConstants{
	public static void main(String args[]) throws Exception { 
		
	        ApigeeHTTPClient apigeeHTTPClient;
	        String apiproxyLatestVersion = "1";
	
	
	        apigeeHTTPClient = new ApigeeHTTPClient();
	
	        final Map<String, String> headers = new Hashtable<String, String>();
	        headers.put(CONTENT_TYPE_HEADER, CONTENT_TYPE_APPLICATION_OCTET_STREAM);
	
			
	
			System.out.print("Enter the location of the Yaml file :");
			String fileLocation = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			
			System.out.print("Is this Swagger developed from Apigee-127 Specific (y/n) :");
			String swaggerType = (new BufferedReader(new InputStreamReader(System.in))).readLine();
	
			System.out.print("Enter the API Proxy Name :");
			String apiBundleName = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			
			
			System.out.print("Enter the Location for the API Bundle :");
			String apiBundleLocation  = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			
			
	
			FileReader fr;
			try {
				fr = new FileReader(fileLocation);
				
				BufferedReader br = new BufferedReader(fr); 
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        
		        while (line != null) {
		            sb.append(line);
		            sb.append("\n");
		            line = br.readLine();
	        }
			fr.close(); 
			br.close();
			String yamlstr=sb.toString();
			
	        //System.out.println(sb.toString());
			 Yaml yaml = new Yaml();
			 Map map = (Map) yaml.load(yamlstr);
			 
			 
				ProxyObject proxyObj = new ProxyObject();
				
				proxyObj.setSwaggerType(swaggerType);
				proxyObj.setApiBundleLocation(apiBundleLocation);
				proxyObj.setApiBundleName(apiBundleName);
	
				 if(swaggerType.equalsIgnoreCase("n")){
					 SwaggerGeneral swaggerGen = new SwaggerGeneral();
					 proxyObj = swaggerGen.swaggerParser(proxyObj, map);
			 
				 }else if(swaggerType.equalsIgnoreCase("y")){
			 
					 SwaggerA127 swagger = new SwaggerA127();
					 proxyObj = swagger.swaggerParser(proxyObj, map);
	
				 }
			
			
	
	 
	
	
			APIProxyMain proxyMain = new APIProxyMain();
			proxyMain.generator(proxyObj);
			
			
			System.out.print("API Proxy Successfully Generated.Do you want to deploy this API to enterprise(y/n) :");
			String deploytoEnterprise = (new BufferedReader(new InputStreamReader(System.in))).readLine();
	
			if(deploytoEnterprise.equalsIgnoreCase("y")){
				
		        String enterpriseURL;;
		        String org;
		        String username;
		        String password;
	            String environment;

				System.out.print("Enter the Enterprise URL (Default= https://api.enterprise.apigee.com) :");
				enterpriseURL = (new BufferedReader(new InputStreamReader(System.in))).readLine();
				if(enterpriseURL==null || enterpriseURL.equalsIgnoreCase("")){
					enterpriseURL="https://api.enterprise.apigee.com";
				System.out.println("Enterprise URL: "+enterpriseURL);
				}
				System.out.print("Enter the Org Name :");
				org = (new BufferedReader(new InputStreamReader(System.in))).readLine();
				
				
				System.out.print("Enter the Environment Name :");
				environment = (new BufferedReader(new InputStreamReader(System.in))).readLine();
	
				
				System.out.print("Enter the Username :");
				username = (new BufferedReader(new InputStreamReader(System.in))).readLine();
				
	            String prompt = String.format("Enter Password for Org :");
	            System.out.println(prompt);
	            Console console = System.console();
	            password = String.valueOf(console.readPassword());
	
		        String orgPath = enterpriseURL + ORG_BASEPATH + URL_PATH_SEPERATOR + org;
	
				
	        File proxyFile = new File(proxyObj.getApiBundleLocation() + "/"+proxyObj.getApiBundleName(), "apiproxy" + ZIP_EXTENSION);
	
	        final String importUrl = orgPath + APIS_BASEPATH + String.format("?action=import&name=%s", proxyObj.getApiBundleName());
	
	
	        try {
	
	          String response =   apigeeHTTPClient.doPOST(importUrl, headers, proxyFile, username, password);
	          apiproxyLatestVersion = ((net.sf.json.JSONObject) net.sf.json.JSONSerializer.toJSON(response)).getString("revision");
	
	
	        }catch (IOException e) {
	            e.printStackTrace();
	        }
	
	
	        
	
	
	            
	
	        final String deployUrl = orgPath + APIS_BASEPATH + "/" + proxyObj.getApiBundleName() + String.format("/revisions/%s/deployments?action=deploy&env=%s", apiproxyLatestVersion, environment);
	
	        try {
	        	
	             apigeeHTTPClient.doPOST(deployUrl, headers, "", username, password);
	
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            
			System.out.println("API Proxy "+apiBundleName+" Successfully Generated and Deployed to Enterprise");

	
			} else{
				System.out.println("API Proxy "+apiBundleName+"Successfully Generated");
				
			}
	
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
		}
}
	
	

