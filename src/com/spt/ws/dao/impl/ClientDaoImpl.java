package com.spt.ws.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spt.fjj.service.models.common.AnnotationCommonService;
import com.spt.util.DateHelper;
import com.spt.ws.dao.IClientDao;

@Service
public class ClientDaoImpl extends AnnotationCommonService implements IClientDao {

	@Transactional
	@Override
	public List<Map<String, Object>> getXZSB() throws Exception {
		String sql = "select id,SBSJ,SBYY,sbid FJJDM,WLHCH,bjtm YJTM,MDDDM,CARNO from F_XZSBXXB where bz = 0 and rownum < 3000";
		return this._queryMultex(sql);
	}
	@Transactional
	@Override
	public void setXZSBFlag(String idList,String flag) throws Exception {
		String sql = "update F_XZSBXXB t set t.bz = '"
				+ flag
				+ "' where id in (" + idList + ")";
		this._update(sql);
	}
	
	@Transactional
	@Override
	public List<Map<String, Object>> getSBFJ() throws Exception {

		String sql = "select id,sbid FJJDM,CAR,wlhch WLGKH,MDDDM,bjtm YJTM,SRSJ,SRYY from TSRGKZTXXB where scbz = 0 and rownum < 3000";
		List<Map<String,Object>> li = this._queryMultex(sql);
		return li;
	}
	
	@Transactional
	@Override
	public void setSBFJFlag(String idList,String flag) throws Exception {
		//String ids = "'" + idList.replace(",", "','") + "'";
		String sql = "update TSRGKZTXXB t set t.scbz = '"
				+ flag
				+ "' where id in (" + idList + ")";
		this._update(sql);
	}
	@Transactional
	@Override
	public List<Map<String, Object>> getRoute() throws Exception {
	    String sql = "select id,bjtm YJTM,gkhm LJGK,LXGKMC,ZL,YWLX from table where csbz = 0 and rownum < 1000";
        List<Map<String,Object>> li = this._queryMultex(sql);
        return li;
	}
	@Transactional
	@Override
	public void setRouteFlag(String idList,String flag) throws Exception {
	    String sql = "update table t set t.scbz = '"
                + flag
                + "' where id in (" + idList + ")";
        this._update(sql);
	}
	@Transactional
	@Override
	public List<Map<String, Object>> getQGFF() throws Exception {
		String sqlhead = "select id,fjjid SBID,id PCH,ljgkdm GKHM,WLGKH,to_char(JS) js,YWLX,FFSJ,'"
		        + DateHelper.getDateTime()
		        + "' fssj from TZBXX where bz = 0 and rownum < 1000";
		String sqlbody = "select id,bjtm YJTM,bjzl SJZL,carno XCBH,ffsj LGSJ from F_FFBJXXB where ffqdid=?";
		List<Map<String,Object>> li = this._queryMultex(sqlhead);
		if(li == null || li.size() == 0) return null;
		for(Map<String,Object> map : li){
		    List<Map<String,Object>> libody = this._queryMultex(sqlbody, map.get("ID"));
		    map.put("maillist", libody);
		}
		return li;
	}
	@Transactional
	@Override
	public void updateQGFF(Map<String, Object> row,String flag) throws Exception {
	    String sqlhead = "update TZBXX t set t.bz = '"
                + flag
                + "',fssj = ? where id =?";
	    String sqlbody = "update F_FFBJXXB t set t.scbz = '"
                + flag
                + "' where ffqdid =?";
        this._update(sqlhead,row.get("FSSJ"),row.get("ID"));
        this._update(sqlbody,row.get("ID"));
	}
	
	@Transactional
	@Override
	public void saveTransferStatus(String method, Integer delayTime) throws Exception {
		String sql = "update T_MANAGE_LIST set delaytime = ?,lastActDt = '"
		        + DateHelper.getDateTime()
		        + "' where dealfunction = ? ";
		this._update(sql, delayTime, method);
		
	}
}
