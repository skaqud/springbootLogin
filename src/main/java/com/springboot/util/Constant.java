package com.springboot.util;

public enum Constant {
	INSTANT;
	// ������Ʈ��
	public static final String CONTEXT_ROOT = "itsbox-web";

	// �α���
	public static final String USER = "USER";
	public static final String LOGIN = "login";
	public static final String COMMON = "common";
	public static final String LOGIN_COOKIE = "loginCookie";
	public static final int COOKIE_LIMIT_TIME = 60 * 60 * 24 * 30;
	public static final int LOGOUT_TIME = 1000 * 60 * 20;

	public static enum ROLE_TYPE {
		ROLE_USER, ROLE_ADMIN
	};
}