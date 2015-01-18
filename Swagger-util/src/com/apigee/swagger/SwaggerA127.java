package com.apigee.swagger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

public class SwaggerA127 {
	
	/**
	public static void main(String[] args){
		
		
		FileReader fr;
		try {
			fr = new FileReader("/Users/bharathkumar/Documents/4G/Utils-Ws/yaml-files/WeatherAdvanced.yaml");
		
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
		 
			 
		 SwaggerA127 swaggerGen = new SwaggerA127();
		 
		 
		ProxyObject proxyObj = new ProxyObject();
		
		JSONObject jsonObject=new JSONObject(map);
		
		swaggerGen.swaggerParser(proxyObj, map);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	**/

	public ProxyObject swaggerParser(ProxyObject proxyObj, Map map){
		
		try{
		VolosCache volosCache = new VolosCache();
		VolosQuota volosQuota = new VolosQuota();
		VolosSpikeArrest voloSpikeArrest = new VolosSpikeArrest();
	
			
			
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
		
		
		JSONObject json_X_volos_resources = jsonObject.getJSONObject("x-volos-resources");
		
		JSONObject json_X_volos_spikeArrest = json_X_volos_resources.optJSONObject("spikeArrest");
		JSONObject json_X_volos_spikeArrest_options = json_X_volos_spikeArrest.getJSONObject("options");
		voloSpikeArrest.setAllow(json_X_volos_spikeArrest_options.getInt("allow"));
		voloSpikeArrest.setBufferSize(json_X_volos_spikeArrest_options.getInt("bufferSize"));
		voloSpikeArrest.setTimeUnit(json_X_volos_spikeArrest_options.getString("timeUnit"));
		
		
		JSONObject json_X_volos_Cache = json_X_volos_resources.optJSONObject("cache");
		JSONObject json_X_volos_Cache_options = json_X_volos_Cache.optJSONObject("options");
		volosCache.setName(json_X_volos_Cache_options.getString("name"));
		volosCache.setTtl(json_X_volos_Cache_options.getInt("ttl"));

		
		JSONObject json_X_volos_Quota = json_X_volos_resources.getJSONObject("quota");
		JSONObject json_X_volos_Quotaoptions = json_X_volos_Quota.optJSONObject("options");
		volosQuota.setAllow(json_X_volos_Quotaoptions.getInt("allow"));
		volosQuota.setInterval(json_X_volos_Quotaoptions.getInt("interval"));
		volosQuota.setTimeUnit(json_X_volos_Quotaoptions.getString("timeUnit"));

		proxyObj.setxVolosSpikeArrest(voloSpikeArrest);
		proxyObj.setxVolosCache(volosCache);
		proxyObj.setxVolosQuota(volosQuota);
		
		
		
		
		String pathsKey;
		String operationsKey;
		JSONObject pathsJsonObj;
		JSONObject opsResJsonObj;
		JSONObject volosJSONObjOauth;
		JSONObject volosJSONObj;
		Iterator opItr;
		Iterator ipaths =basepath.keys();
		Iterator op1Itr;
		
		
		List<ResourceObjects> resources = new ArrayList<ResourceObjects>();
		

		while(ipaths.hasNext()){

			pathsKey = (String)ipaths.next();
			pathsJsonObj =  basepath.getJSONObject(pathsKey);
			ResourceObjects resource = new ResourceObjects();
			Map<String,OperationsObject> resOps =new HashMap<String,OperationsObject>();			

			
			opItr = pathsJsonObj.keys();
				while(opItr.hasNext()){
					OperationsObject opsObj = new OperationsObject();
					operationsKey = (String)opItr.next();

					if(operationsKey.equalsIgnoreCase("x-volos-authorizations")){
						volosJSONObjOauth = pathsJsonObj.optJSONObject(operationsKey);
						if(volosJSONObjOauth!=null){
							proxyObj.setApplyProlicies(true);
							resource.setOauth(true);
						}
					}else if(operationsKey.equalsIgnoreCase("x-volos-apply")){
						volosJSONObj = pathsJsonObj.optJSONObject(operationsKey);
						if(volosJSONObj!=null){
							resource.setQuota((volosJSONObj.optJSONObject("quota")!=null ? true : false));
							resource.setCache((volosJSONObj.optJSONObject("cache")!=null ? true : false));
							resource.setSpike((volosJSONObj.optJSONObject("spikeArrest")!=null ? true : false));
							proxyObj.setApplyProlicies(true);

							
						}
						}else if(operationsKey.equalsIgnoreCase("get")|| operationsKey.equalsIgnoreCase("post") || operationsKey.equalsIgnoreCase("delete") || operationsKey.equalsIgnoreCase("put")){
					opsResJsonObj = pathsJsonObj.getJSONObject(operationsKey);
					opsObj.setDescription(opsResJsonObj.optString("description"));
					opsObj.setOperationId(opsResJsonObj.getString("operationId"));
					
					opsObj.setPath(pathsKey);
					opsObj.setVerb(operationsKey);
					
					
					resOps.put(pathsKey+"_"+operationsKey, opsObj);
					resource.setOperations(resOps);
					resource.setPath(pathsKey);

						}

				}
				
				
				resources.add(resource);

	}
		proxyObj.setResources(resources);
		
		}catch(JSONException jsone){
			jsone.printStackTrace();
		}
		return proxyObj;
		
	}

}
