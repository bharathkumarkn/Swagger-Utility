package com.apigee.swagger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

public class SwaggerGeneral {
	
	
	public ProxyObject swaggerParser(ProxyObject proxyObj, Map map){
		
		try{
		JSONObject jsonObject=new JSONObject(map);
		
		
		JSONObject basepath =  jsonObject.getJSONObject("paths");	
		
		proxyObj.setSwaggerVersion((String)jsonObject.getString("swagger"));
		
		JSONObject swaggerVersion = jsonObject.getJSONObject("info");
		
		proxyObj.setApiVersion(swaggerVersion.getString("version"));
		proxyObj.setDescription(swaggerVersion.optString("description"));
		proxyObj.setHost(jsonObject.getString("host"));
		proxyObj.setBasePath(jsonObject.getString("basePath"));
		
		String[] schems = new String[2];
		JSONArray schemes = jsonObject.getJSONArray("schemes");
			for(int i=0;i<schemes.length();i++){
				schems[i]= (String) schemes.get(i);
			}
		proxyObj.setSchemes(schems);
		
		
		String pathsKey;
		String operationId;
		JSONArray jsonArray1;
		JSONArray jsonArray2;		
		String operationsKey;
		JSONObject pathsJsonObj;
		JSONObject opsResJsonObj;		
		Iterator opItr;
		Iterator ipaths =basepath.keys();
		Iterator op1Itr;
		
		
		Map<String,OperationsObject> resOps =new HashMap<String,OperationsObject>();
		

		while(ipaths.hasNext()){

			pathsKey = (String)ipaths.next();
			pathsJsonObj =  basepath.getJSONObject(pathsKey);


			opItr = pathsJsonObj.keys();
				while(opItr.hasNext()){				
					OperationsObject opsObj = new OperationsObject();
					
					operationsKey = (String)opItr.next();
					
					opsResJsonObj = pathsJsonObj.getJSONObject(operationsKey);
					opsObj.setDescription(opsResJsonObj.optString("description"));
					
					operationId = opsResJsonObj.optString("operationId");
					
					
					jsonArray1 = opsResJsonObj.optJSONArray("produces");
					jsonArray2 = (JSONArray)opsResJsonObj.get("parameters");
					
					
					String[] produces = new String[10];
					if(jsonArray1!=null){
						for(int i=0;i<jsonArray1.length();i++){
							produces[i]= (String) jsonArray1.get(i);
						}
					}
						opsObj.setProduces(produces);
					
						for(int i=0;i<jsonArray2.length();i++){
							JSONObject paramsList = jsonArray2.getJSONObject(i);
							Iterator paramsItr = paramsList.keys();
							List<ParametersObject> parameters = new ArrayList<ParametersObject>();
								while(paramsItr.hasNext()){
									ParametersObject parameter = new ParametersObject();
									HashMap<String,String> paramsMap = new HashMap<String, String>();
									String key = (String)paramsItr.next();
									String value = paramsList.optString(key);

									paramsMap.put(key, value);
									parameter.setParameters(paramsMap);
									parameters.add(parameter);
								}
								opsObj.setParameters(parameters);		
									
							
						}
						opsObj.setProduces(produces);
						opsObj.setPath(pathsKey);
						opsObj.setVerb(operationsKey);
						
						if(operationId.equalsIgnoreCase("")){
							operationId = jsonObject.getString("basePath") + pathsKey + ":" + operationsKey;
						} 					
						opsObj.setOperationId(operationId);
						resOps.put(pathsKey+"_"+operationsKey, opsObj);
				}
				
				proxyObj.setOperations(resOps);
			
			
			

			

	}
		
		}catch(JSONException jsone){
			jsone.printStackTrace();
		}
		return proxyObj;
		
	}

}
