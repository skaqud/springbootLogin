package com.springboot.auth.account;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.main.LoginApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = { AccountMapper.class, LoginApplication.class })
@RunWith(SpringRunner.class)
//@Transactional
public class AccountMapperTest {
	
	@Autowired
	AccountService accountService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void joinTest() {
		Account account=new Account();
		account.setUsername("admin사용자");
		account.setUserId("admin");
		account.setUserTel("87687687687");
		account.setUserDesc("this is admin user.");
		account.setAccountNonExpired(true);
		account.setAccountNonLocked(true);
		account.setCredentialsNonExpired(true);
		account.setEnabled(true);
		account.setPassword(passwordEncoder.encode("1234"));
		accountService.save(account, 11);
	}
	
	@Test
	public void getAllUsers() {
		List<Account> account = accountService.list();
		logger.info("Account : {}", account);
		assertNotNull(account);
	}
	
	@Test
	public void deleteAccountTest() {
//		accountService.deleteAccount("111");
	}
	
	
	
}
