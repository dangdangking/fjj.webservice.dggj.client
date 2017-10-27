package com.spt.fjj.service.models.common;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * Description:鏁版嵁璁块棶灞傞�氱敤鎺ュ彛锛岀埗绫绘帴鍙ｏ紝瀹炵幇鏁版嵁CRUD锛屽疄鐜版暟鎹〃鍜岃褰曠殑杞崲锛屽疄鐜颁唬鐮佸鐢�
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company:涓婃捣鑻忕繑淇℃伅绉戞妧鏈夐檺鍏徃
 * </p>
 * 
 * @author 瀛鍗�
 * @param <T>
 *            绫诲瀷鍙傛暟
 */
public interface ICommonService {
	/**
	 * 淇濆瓨
	 * 
	 * @param sql
	 *            SQL Command
	 * @return 褰卞搷琛屾暟
	 * @throws Exception
	 */
	int _insert(String sql) throws Exception;
	
	/**
	 * 淇濆瓨
	 * 
	 * @param sql
	 *            SQL Command
	 * @param args
	 *            SQL 鍙傛暟
	 * @return 褰卞搷琛屾暟
	 * @throws Exception
	 */
	int _insert(String sql, Object... args) throws Exception;
	
	/**
	 * 淇敼
	 * 
	 * @param sql
	 *            SQL Command
	 * @return 褰卞搷琛屾暟
	 * @throws Exception
	 */
	int _update(String sql) throws Exception;
	
	/**
	 * 淇敼
	 * 
	 * @param sql
	 *            SQL Command
	 * @param args
	 *            SQL 鍙傛暟
	 * @return 褰卞搷琛屾暟
	 * @throws Exception
	 */
	int _update(String sql, Object... args) throws Exception;
	
	/**
	 * 鍒犻櫎
	 * 
	 * @param sql
	 *            SQL Command
	 * @return 褰卞搷琛屾暟
	 * @throws Exception
	 */
	int _delete(String sql) throws Exception;
	
	/**
	 * 鍒犻櫎
	 * 
	 * @param sql
	 *            SQL Command
	 * @param args
	 *            SQL 鍙傛暟
	 * @return 褰卞搷琛屾暟
	 * @throws Exception
	 */
	int _delete(String sql, Object... args) throws Exception;
	
	/**
	 * 鎵瑰鐞�
	 * 
	 * @param sql
	 *            SQL Commands
	 * @return 褰卞搷琛屾暟鏁扮粍
	 * @throws Exception
	 */
	int[] _execBatch(String... sql) throws Exception;
	
	
	
	/**
	 * 鏌ヨ锛堝崟鍊硷級
	 * 
	 * @param sql
	 *            SQL Command
	 * @return 鍊�
	 * @throws Exception
	 */
	String _querySingle(String sql) throws Exception;
	

	
	/**
	 * 鏌ヨ锛堝琛岋級
	 * 
	 * @param sql
	 *            SQL Command
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
	List<Map<String, Object>> _queryMultex(String sql) throws Exception;
	

	/**
	 * 搴撹〃涓婚敭鐢熸垚鍣�
	 * 
	 * @param arg0
	 *            搴撹〃鏍囪瘑锛堝父鐢ㄥ簱琛ㄤ富閿垪浣滀负璇ュ弬鏁帮級
	 * @return 涓婚敭鏍囪瘑
	 * @throws Exception
	 */
	String _identifyGenerater(final String arg0) throws Exception;

	List<Map<String, Object>> _queryMultex(String sql, Object[] args)
			throws Exception;

	String _querySingle(String sql, Object[] args) throws Exception;
}
// /:~