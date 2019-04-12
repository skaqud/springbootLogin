package com.springboot.comm;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exStr = null;

	/**
	 * Construction	
	 * @param		String			오류 메시지
	 */
	public CustomException(String msg) {
		super(msg);
	}

	/**
	 * Construction	
	 * @param		String			오류 메시지
	 * @param		String			오류 메시지(로그용)
	 */
	public CustomException(String msg, String exStr) {
		super(msg);
		this.exStr = exStr;	
	}

	/**
	 * Construction	
	 * @param		String				오류 메시지
	 * @param		Exception			Exception
	 */
	public CustomException(String msg, Exception e) {
		super(msg,e);
	}

	/**
	 * Construction	
	 * @param		String				오류 메시지
	 * @param		String				오류 메시지(로그용)
	 * @param		Exception			Exception
	 */
	public CustomException(String msg, String exStr, Exception e) {
		super(msg,e);
		this.exStr = exStr;
	}

	/**
	 * 오류 메시지 추출
	 * @return		String				오류 메시지
	 */
	public String getExceptionMsg() {
		String exstr = null;
		exstr = "[Message] : " + getMessage();
		if(exStr != null) exstr += "[" + exStr +"]";
		Throwable cause = getCause();
		if(cause != null) {
			exstr += "\n[Cause Message] : " + cause.getMessage();
		}

		return exstr;
	}
    
}