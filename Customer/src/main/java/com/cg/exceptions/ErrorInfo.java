package com.cg.exceptions;

/**
-File Name          : ErrorInfo
-Author Name        : Capgemini
-Description        : ErrorInfo
-Creation Date		: 15/04/2021
*/

public class ErrorInfo {
	
	private String url;
	private String message;
	
	
	public ErrorInfo() {
		
	}


	public ErrorInfo(String url, String message) {
		super();
		this.url = url;
		this.message = message;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "ErrorInfo [url=" + url + ", message=" + message + "]";
	}
	
	
	

}
