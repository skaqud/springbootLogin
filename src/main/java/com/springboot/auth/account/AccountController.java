package com.springboot.auth.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@Autowired
	AccountMapper accountMapper;
	
	@GetMapping("/user/{userName}")
	@ApiOperation(value = "사용자 조회")
	public Account getUser(@PathVariable("userName") String userName){
		Account account = accountService.loadUserByUsername(userName);
		logger.debug("Account Username:"+account.getUsername());
		return account;
	}
	
	//Login처리
	@GetMapping("/login")
	public String loginProcess(){
		logger.debug("AccontController-login");
		return "login";
	}

	//가입화면
	@GetMapping("/register")
	public String registerUser(){
		logger.debug("AccontController-register");
		return "register";
	}
	
	//가입처리
	@PostMapping("/join")
	public void joinUser(){
		logger.debug("AccontController-join");
//		accountService.save(account, authorityId);
	}
	

}
