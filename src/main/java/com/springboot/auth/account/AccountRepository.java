package com.springboot.auth.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
	
	@Autowired
	AccountMapper accountMapper;
	
	public Account save(Account account,int authorityId){
		accountMapper.insertUser(account);
		accountMapper.insertUserAutority(account.getUid(), authorityId);
		return account;
	}

	public Account checkUserName(String username) {
		return accountMapper.checkAccount(username);
	}
	
	public List<Account> getAllUsers() {
		return accountMapper.readAllUsers();
	}
	
	public void deleteAccount(String userName) {
		accountMapper.deleteAccount(userName);
	}

	public List<String> findAuthoritiesByID(String username) {
		return accountMapper.readAutorities(username);
	}
	
}
	



