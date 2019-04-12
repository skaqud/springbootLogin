package com.springboot.auth.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService implements UserDetailsService{
	
	@Autowired
	AccountRepository accounts;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Account loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account=accounts.checkUserName(username);
//		account.setAuthorities(getAuthorities(username));
		return account;
	}
	public Account save(Account account,int authorityId) {
		logger.debug("AccountService-save,id="+account.getUsername()+",pw="+account.getPassword());
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		return accounts.save(account, authorityId);
	}
	
	public List<Account> list() {
		return accounts.getAllUsers();
	}
	
	public void deleteAccount(String userName) {
		accounts.deleteAccount(userName);
	}
	
	public Collection<GrantedAuthority> getAuthorities(String username) 
	{ 
		List<String> strAuthorities = accounts.findAuthoritiesByID(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		for (String authority : strAuthorities) 
		{ 
			authorities.add(new SimpleGrantedAuthority(authority)); 
		} 
		return authorities; 
	}
	

}