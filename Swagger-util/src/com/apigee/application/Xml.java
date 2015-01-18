package com.apigee.application;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: dchand
 * Date: 11/28/11
 * Time: 6:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Xml {
    private String path;
    private String apiBunndleLocation;

    public Xml(String filePath,String path) {
    	this.apiBunndleLocation = filePath;
        this.path = path;

    }

    public void generateXML(Class className1, Object object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(className1, className1);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                true);
        try {
            marshaller.marshal(object,
                    new FileOutputStream(apiBunndleLocation +path));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
