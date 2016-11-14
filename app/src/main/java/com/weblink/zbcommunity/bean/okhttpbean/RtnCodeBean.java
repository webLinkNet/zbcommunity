/**
 * 
 */
package com.weblink.zbcommunity.bean.okhttpbean;


import com.weblink.zbcommunity.Constants;

import java.io.Serializable;

/**
 * @author longya
 * @E-mail: xueyelongya@126.com
 * @version 创建时间：2015-6-24 下午7:19:22 
 * 类说明 :
 */
public class RtnCodeBean implements Serializable {
	
	private String code;
	private String message;
	
	
	public RtnCodeBean()
	{
		
	}
	
	public RtnCodeBean(String code, String message)
	{
		this.code= code;
		this.message = message;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public boolean isSuccess()
	{
		if(code!=null && code.equals(Constants.RESULT_CODE_SUCCESS))
			return true;
		return false;
	}

}
