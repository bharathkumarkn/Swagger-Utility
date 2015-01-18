package com.apigee.application;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;
import java.util.zip.*;


import com.apigee.messaging.config.beans.PolicyGenerator;
import com.apigee.swagger.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.*;	

import org.zeroturnaround.zip.ZipUtil;
public class APIProxyMain {
	
	public void generator(ProxyObject proxyObject) throws IOException, JAXBException {
		
		String apiDir = "/"+ proxyObject.getApiBundleName() + "/" + "apiproxy";
		String apiProxyZip = proxyObject.getApiBundleLocation() + "/" + "apiproxy.zip";
		String proxyDir  = apiDir + "/" + "proxies";
		String targetDir  = apiDir + "/" + "targets";
		String policiesDir = apiDir + "/" + "policies";

		boolean success = (new File(proxyObject.getApiBundleLocation()+ "/"+ proxyObject.getApiBundleName() )).mkdir();
		(new File(proxyObject.getApiBundleLocation()+ apiDir)).mkdir();
		(new File(proxyObject.getApiBundleLocation()+proxyDir)).mkdir();
		(new File(proxyObject.getApiBundleLocation()+targetDir)).mkdir();
		
		
		
	    try {

			 if(proxyObject.getSwaggerType().equalsIgnoreCase("n")){
				 GeneralProxyGenerator genProxy = new GeneralProxyGenerator(proxyObject);
				 genProxy.createProxy();
		    		
			 }else if(proxyObject.getSwaggerType().equalsIgnoreCase("y")){		 
				 ProxyGenerator proxy = new ProxyGenerator(proxyObject);
				 proxy.createProxy();

			 }

	    	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	    

	    TargetGenerator target = new TargetGenerator(proxyObject);
	    try {
	        target.createTarget();	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	    
	    ApplicationGenerator application = new ApplicationGenerator(proxyObject);
	    try {
	    	application.createProxy();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	    
		
		if(proxyObject.isApplyProlicies()){
		(new File(proxyObject.getApiBundleLocation()+policiesDir)).mkdir();
	      
	      PolicyGenerator policies = new PolicyGenerator(proxyObject);
	      try {
	        policies.createPolicies();
	      } catch (IOException e) {
	          e.printStackTrace();
	      } catch (JAXBException e) {
	          e.printStackTrace();
	      }
	      
		}

	    

		String proxyDefault =proxyObject.getApiBundleLocation() +  proxyDir + "/default.xml";
		String targetDefault =proxyObject.getApiBundleLocation() + targetDir + "/default.xml";
		
		String appfile = proxyObject.getApiBundleLocation() + "/"+ apiDir + "/"+proxyObject.getApiBundleName()+".xml";		
		
		//Create a apiproxy.zip
		ZipUtil.pack(new File( proxyObject.getApiBundleLocation() +  "/"+proxyObject.getApiBundleName() + "/" ), new File(proxyObject.getApiBundleLocation() +  "/"+proxyObject.getApiBundleName() + "/" + "apiproxy.zip"));


	
	}
	public void addToZipFile(String fileName, ZipOutputStream zos)throws FileNotFoundException, IOException
	{

		System.out.println("Writing '" + fileName + "' to zip file");

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		
		zos.putNextEntry(new ZipEntry(new File(fileName).getName())); 

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}


    public String createBundle(String apiproxydir) throws IOException {

    	System.out.println("apiproxydir"+apiproxydir);
        File dirObj = new File(apiproxydir);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("apiproxy" + ".zip"));

        addDir(dirObj, out);
        out.close();

        return null;

    }

    static void addDir(File dirObj, ZipOutputStream out) throws IOException {
        File[] files = dirObj.listFiles();
        byte[] tmpBuf = new byte[1024];

        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                addDir(file, out);
                continue;
            }
            FileInputStream in = new FileInputStream(file.getPath());
            System.out.println(" Adding: " + file.getPath());
            out.putNextEntry(new ZipEntry(file.getPath()));
            int len;
            while ((len = in.read(tmpBuf)) > 0) {
                out.write(tmpBuf, 0, len);
            }
            out.closeEntry();
            in.close();
        }
    }



}
