package com.springboot.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springboot.auth.account.Account;
import com.springboot.auth.account.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("authProvider")
public class AuthProvider implements AuthenticationProvider  {
    
    @Autowired
    AccountService accountService;
    
	@Autowired
	PasswordEncoder passwordEncoder;
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String password = authentication.getCredentials().toString();

        logger.info("authenticate:"+userId+","+password );
        Account account = accountService.loadUserByUsername(userId);
		    
        
        if (null == account) {
        	logger.debug("계정정보 없음");
        	return null;
        } else if(!passwordEncoder.matches(password, account.getPassword())) {
        	logger.debug("비번불일치");
            logger.debug("input password:"+passwordEncoder.encode(password));
            logger.debug("saved password:"+account.getPassword());
        	return null;
        }
        
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        
//        if (account.isIsadmin()) {
//       	if (true) {
//            grantedAuthorityList.add(new SimpleGrantedAuthority(Constant.ROLE_TYPE.ROLE_ADMIN.toString()));
//        } else {
//            grantedAuthorityList.add(new SimpleGrantedAuthority(Constant.ROLE_TYPE.ROLE_USER.toString()));
//        }
 
        return new AuthInfo(userId, password, grantedAuthorityList, account);
    }
    
    @Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

    
}
