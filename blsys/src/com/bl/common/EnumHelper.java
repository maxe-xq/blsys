package com.bl.common;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate; 

import com.bl.bean.BlDic;

public abstract class EnumHelper {
	@Autowired
    private static transient JdbcTemplate jdbcTemplate;
	
	private static Map<String, HashMap<String, String>> codetableCache 
		= new ConcurrentHashMap<String, HashMap<String, String>>();
	private static int size = 0;

	public EnumHelper() {
	}

	/**
	 * key tbname.columnName value HashMap<String,String>
	 * @param codeType
	 * @return
	 */
	public static boolean contains(String codeType) {
		try {
			if (size == 0)
				init();
			return codetableCache.containsKey(codeType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static void init() throws BlException {
		refresh();
	}

	public static void refresh() throws BlException {
		try {
			synchronized (codetableCache) {
				String detailSql = "SELECT `bl_dic_id`, `bl_table`, `bl_column`, `bl_name`, `bl_value`, `bl_order` FROM `bl_dic` WHERE 1";
				List<BlDic>  rsls=jdbcTemplate.queryForList(detailSql, BlDic.class);
				for(BlDic blDic:rsls){
				    String keyName=generateCodeKeyName(blDic.getBl_table(),blDic.getBl_column()); 
				    HashMap<String,String> codemap=null;
				    if(keyName==null){
				    	continue;
				    }
					if (codetableCache.containsKey(keyName)) {
						codemap = codetableCache.get(keyName);

					} else {
						codemap = new HashMap<String, String>();
						codetableCache.put(keyName, codemap);
					}
					codemap.put(blDic.getBl_name().trim(), blDic.getBl_value());					
				}
				if(codetableCache.size()>0)
					size=1;
			}
		} catch (BlException ex) {
			throw ex;
		}

	}

	
	public static String generateCodeKeyName(String tbName,String colName){
		if(StringUtils.isBlank(tbName)||StringUtils.isBlank(colName)){
			return null;
		}
		  String keyName=tbName.trim()+"."+colName.trim();		  
		    return keyName.toUpperCase();
	}
	public static Map<String,String> get(String keyName) {
		if (size == 0)
			init();

		return codetableCache.get(keyName);
	}

	public static String getDisplayValue(String keyName, String value) {
		if (size == 0)
			init();
		if (value == null)
			return null;
		else
			return getString((Map<String,String>) codetableCache.get(keyName),
					String.valueOf(value));
	}

	public static String getEnumKeyValue(String keyName, String displayValue) {
		if (size == 0)
			init();
		if (displayValue == null)
			return null;
		else
			return getKeyName((Map<String,String>) codetableCache.get(keyName),
					displayValue);
	}
	
	
	
	private static String getString(Map<String,String> map, String key) {
		if (isEmpty(map) || key == null) {
			return null;
		} else {
			return map.get(key);
		}
	}

	private static String getKeyName(Map<String,String> map, String displayVlue) {
		if (isEmpty(map) || displayVlue == null) {
			return null;
		} else {
			if (map.containsValue(displayVlue)) {
				Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String,String> entry = it.next();
					String obj = entry.getValue();
					if (obj != null && obj.equals(displayVlue)) {
						return (String) entry.getKey();
					}
				}
			}
			return null;
		}
	}
	
	
	private static boolean isEmpty(Map<String,String> map) {
		return map == null || map.isEmpty();
	}

}
