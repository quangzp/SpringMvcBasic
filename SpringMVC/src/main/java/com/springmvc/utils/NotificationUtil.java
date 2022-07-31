package com.springmvc.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class NotificationUtil {
	
	public Map<String,String> notice(String message){
		Map<String,String> result = new HashMap<>();
		if(message.equals("create_success")) {
			result.put("message", "Insert success");
			result.put("alert", "success");
		}else if(message.equals("update_success")) {
			result.put("message", "Update success");
			result.put("alert", "success");
		}else if(message.equals("error_system")) {
			result.put("message", "Error_system");
			result.put("alert", "danger");
		}
		
		return result;
	}
}
