package com.spt.ws.client;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spt.core.Property;
import com.spt.ws.dao.IClientDao;
import org.apache.logging.log4j.LogManager;  
import org.apache.logging.log4j.Logger;
@Component
public class ClientWYImpl extends WebServiceBase implements IClientWY{
	private static Logger log = LogManager.getLogger("com.spt.ws.client");
	//@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
	@Autowired
	private IClientDao dao;
	
	private String head = "#HEAD";
	private String end = "#END";

	
	private boolean checkMsg(String msg){
		if(msg.startsWith("#MSG")&&msg.endsWith("#END")){
			String s[] = msg.split("::");
			if("0".equals(s[1])) {
				return true;
			}else {
				return false;
			}
			
		}else{
			return false;
		}
	}
	
	private String assembleLine(String[] keys,Map<String,Object> map){
		StringBuffer sb = new StringBuffer("::");
		for(String key:keys){
		    String a = (String) map.get(key);
		    if(a == null) a = "";
			sb.append(a).append("::");
		}
		sb.append("||");
		return sb.toString();
	}
	
	
	@Override
	public void getQGFF() {
		log.info("start getQGFF..........");
		try {
			List<Map<String,Object>> li = dao.getQGFF();
			int i = 0,total = 0;
			//StringBuffer parmyy = new StringBuffer(head);
			StringBuffer parm = new StringBuffer(head);
			String[] headkeys = Property.getProperty("fjj.send.qgff.head").split(",");
			String[] bodykeys = Property.getProperty("fjj.send.qgff.body").split(",");
            if(headkeys == null || headkeys.length == 0 || bodykeys == null || bodykeys.length == 0){
                //log.error("记取字段配置信息出错");
                return;
            }
            if(li == null){
                log.info("no message");
                return;
            }
			for(Map<String,Object> map : li){
				i++;total++;
				//parmyy.append(this.assembleLine(keysyy, map));
				parm.append(this.assembleLine(headkeys, map));
				//ids.append(map.get("ID")).append(",");
				List<Map<String,Object>> libody = (List<Map<String, Object>>) map.get("maillist");
				for(Map<String,Object> mapbody : libody){
				    parm.append(this.assembleLine(bodykeys, mapbody));
				}
				parm.append(end);
				log.info("send msg is : " + parm.toString());
                String res = callWS("qigeff", parm.toString());
                log.info("return msg is :" + res);
                if(checkMsg(res)){
                    dao.updateQGFF(map, "1");
                }else{
                    dao.updateQGFF(map, "9");
                }
				parm.setLength(0);
				parm.append(head);
			}
			li.clear();
			//GETQGFF_DEALY_TIME = 0;
		} catch (Exception e) {
		log.error(e.getMessage());
		e.printStackTrace();
		//if(GETQGFF_DEALY_TIME < 110) GETQGFF_DEALY_TIME += 10;
        //delay(GETQGFF_DEALY_TIME);
		}
		
		log.info("end getQGFF..........");
	}

	
	private List<String> assemb(String parm){
		List<String> li = new ArrayList<String>();
		String[] parmLine = parm.split("\\|\\|");
		for (String ss : parmLine){
			if(ss.startsWith("#HEAD::")) {
				li.add(ss+"||#END");
			}else if(ss.startsWith("#END")){
				continue;
			}else{
				li.add("#HEAD" + ss+"||#END");
			}
		}
		return li;
	}
	private void delay(int seconds){
		if (seconds == 0) return;
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e1) {
			//log.info(e1.getMessage());
		}
	}
	
	@Override
	public void test() {
	    log.info("start");
	    for(int i = 0; i < 100; i++){
	    String a = "#HEAD::11002200::::1093::1001::23::003::||#END";
	    String res = callWS("sayHi", a);
	    log.info(res);
	    }
	    //String res = callsbfj(a);
	    //System.out.println(res);
	}
}
