package org.ohjic.flower.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UriRoleCheck {
	private static HashMap<String, List<String>> uriMap;
	
	static {
		uriMap = new HashMap<String, List<String>>();
		uriMap.put("/main",  Arrays.asList("1","2"));
		uriMap.put("/layout/test", Arrays.asList("3","4"));
	}
	
	public static List<String> getRole (String uri) {
		return uriMap.get(uri);
	}
}
