/**
 * 
 */
package com.weblink.zbcommunity.bean.okhttpbean;

import java.io.Serializable;

/**
 *　　　　　　
 * @author longya
 * @E-mail: xueyelongya@126.com
 * @version 创建时间：2015-6-24 下午8:43:41 
 * 类说明 :
 */
public class ResultBean<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T data;
	private RtnCodeBean apiResult;
	private String housingId;



	public String getHousingId() {
		return housingId;
	}

	public void setHousingId(String housingId) {
		this.housingId = housingId;
	}

	@Override
	public String toString() {
		return "ResultBean{" +
				"data=" + data +
				", apiResult=" + apiResult +
				", housingId='" + housingId + '\'' +
				'}';
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the apiResult
	 */
	public RtnCodeBean getApiResult() {
		return apiResult;
	}
	/**
	 * @param apiResult the apiResult to set
	 */
	public void setApiResult(RtnCodeBean apiResult) {
		this.apiResult = apiResult;
	}


}
