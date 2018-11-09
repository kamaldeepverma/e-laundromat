package com.laundrovalley.rest.model;

public class BaseResponse {

	private String status;
    private Integer code;
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public Integer getCode() {
        return code;
    }
 
    public void setCode(Integer code) {
        this.code = code;
    }

	public BaseResponse(String status, Integer code) {
		super();
		this.status = status;
		this.code = code;
	}
}
