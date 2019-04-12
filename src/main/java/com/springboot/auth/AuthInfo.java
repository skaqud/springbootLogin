package com.springboot.auth;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.springboot.auth.account.Account;

import lombok.Data;

@Data
public class AuthInfo extends UsernamePasswordAuthenticationToken {
	 private static final long serialVersionUID = 1L;

	  long userId;
	  Account account;
	  int loginType;

	  public AuthInfo(String id, String password, List<GrantedAuthority> grantedAuthorityList, Account account) {
	    super(id, password, grantedAuthorityList);
	    this.account = account;
	    this.loginType = loginType;
	    this.userId = userId;
	}
}
