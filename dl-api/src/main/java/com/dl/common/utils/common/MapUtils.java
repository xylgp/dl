package com.dl.common.utils.common;

import java.util.Comparator;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
@SuppressWarnings("unchecked")
public class MapUtils {
	/**
	 * 将request中的请求封装为Map
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, Object> packageRequestParamsToMap(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() != 0) {
					map.put(paramName, paramValue);
				}
			}
		}
		return map;
	}
	/**
	 * 将request请求头中的信息中的请求封装为Map
	 * 
	 * @param request
	 * @return
	 */
    public static Map<String, Object> packageRequestHeaderParamsToMap(HttpServletRequest request) {
    	Map<String, Object> map = new HashMap<>();
       
		Enumeration<String> e = request.getHeaderNames();
        while(e.hasMoreElements()){
            String headerName = e.nextElement();//透明称
            Enumeration<String> headerValues = request.getHeaders(headerName);
            while(headerValues.hasMoreElements()){
            	map.put(headerName, headerValues.nextElement());
            }
        }
        return map;
    }
    /**
     * Map按key进行排序---升序排列
     * @param map
     * @return
     */
    public static <T> Map<Integer , T> sortMapByKey(Map<Integer, T> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer,T> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }
 
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Map map){
    	return ((map == null) || (map.isEmpty()));
    }
    
    /**
     * 校验map和对应的value是否为空，只要存在空值，就返回false
     * @param map
     * @return
     */
    public static boolean checkAllNotEmpty(Map<String, String> map){
    	if(map.isEmpty()) return false;
    	for(String key : map.keySet()){
    		String value = map.get(key);
    		if(StringUtils.isEmpty(value)){
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * 比较器类
     *
     * @Description:
     * @Author: zhangfengchao
     * @CreateTime: 2017/4/28 14:57
     */
    private static class MapKeyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer str1, Integer str2) {
            return str1.compareTo(str2);
        }
    }
    
    
}
