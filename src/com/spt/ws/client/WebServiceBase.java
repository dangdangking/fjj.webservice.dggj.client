package com.spt.ws.client;



import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.logging.log4j.LogManager;  
import org.apache.logging.log4j.Logger;

import com.spt.core.Property;

public class WebServiceBase {
    private static Logger log = LogManager.getLogger("com.spt.ws.client");
    private Client client;
	public String callWS(String method,String parm) {
	    if(client == null){
	        log.info("=========================== client is null, create new client now! ======================");
	        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance(); 
	        String wsUrl = Property.getProperty("wsurl"); 
	        log.info("wsUrl is " + wsUrl);
	        client = dcf.createClient(wsUrl);
	    }
	    
	    //log.info("create client");
	    Object[] result = null;
	    try {
	       result = client.invoke(method, parm);//调用webservice 
	       //log.info("tranfer done");
	    } catch (Exception e) {
	        client = null;
	       e.printStackTrace();
	    }
	    
	    //log.info("return msg is " + (String)result[0]);
	    return (String)result[0];
	}
	
	
	
}
