package com.apigee.messaging.config.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class HttpProxyConnection {
	
    public static final String PATH_SEPARATOR = "/".intern();

	
    private String basePath;
    private List<String> virtualHosts = new ArrayList<String>();
    
    @XmlElement(name = "VirtualHost")
    public Collection<String> getVirtualHosts() {
        return virtualHosts;
    }

    public void addVirtualHosts(Collection<String> virtualHosts) {
        this.virtualHosts.addAll(virtualHosts);
    }

    public void addVirtualHost(String virtualHost) {
        this.virtualHosts.add(virtualHost);
    }

    @XmlElement(name = "BasePath")
    public String getBasePath() {
        return basePath == null ? PATH_SEPARATOR : basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

}
