package com.spt.ws.dao;

import java.util.List;
import java.util.Map;

public interface IClientDao {
	/**
	 * 卸载失败信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getXZSB() throws Exception ;
	
	public void setXZSBFlag(String idList,String flag) throws Exception;
	
	/**
	 * 失败分拣信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getSBFJ () throws Exception ;
	
	public void setSBFJFlag(String idList,String flag) throws Exception;
	
	/**
	 * 路由决策
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getRoute() throws Exception ;
	
	public void setRouteFlag(String idList,String flag) throws Exception;

	
	
	/**
	 * 齐格封发信息
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getQGFF() throws Exception ;
	
	void updateQGFF(Map<String, Object> row,String flag) throws Exception;
	
	
	
	

	void saveTransferStatus(String method, Integer delayTime) throws Exception;
}
