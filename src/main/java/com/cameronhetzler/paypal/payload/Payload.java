package com.cameronhetzler.paypal.payload;

import java.util.Map;

import org.json.JSONObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter @Setter
@NoArgsConstructor
public class Payload implements PayloadInt  {
	
	private Classifications classification;
	
	private Map<String, Object> table;
	
	private JSONObject payloadJson;
	
	private String payloadString;
	
}
