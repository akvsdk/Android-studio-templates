package com.j1ang.base.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * 对象为空的判断 
 * 
 */
public class NullUtil {

	/**
	 * 判断是否为NULL
	 * 
	 * @param obj
	 * @return
	 */
	public static final boolean isNull(Object obj) {
		if (null == obj) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否为Not NULL
	 * 
	 * @param obj
	 * @return
	 */
	public static final boolean isNotNull(Object obj) {
		if (null != obj) {
			return true;
		} else {
			return false;
		}
	}

	public static final boolean isEmpty(Object obj) {
		if (null == obj || "".equals(obj)) {
			return true;
		} else {
			return false;
		}
	}

	public static final boolean isNotEmpty(Object obj) {
		if (null != obj && !"".equals(obj)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static final boolean isParamsNull(Map<String, Object> params){
		if(params == null){
			return true;
		}
		Iterator<String> it = params.keySet().iterator();
		if(!it.hasNext()){
			return true;
		}else{
			return false;
		}
	}

}
