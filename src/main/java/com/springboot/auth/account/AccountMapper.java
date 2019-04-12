package com.springboot.auth.account;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
	//user테이블- test
	@Select("SELECT * FROM test_user WHERE userId=#{username}")
	public Account checkAccount(String username);
	
	@Select("SELECT authorityId FROM test_autorities WHERE uid=#{id}")
	public List<String> readAutorities(String id);
	
	@Insert("INSERT INTO test_user(userId,userName,password,userTel,userDesc,isaccountnonexpired,isAccountNonLocked,isCredentialsNonExpired,isEnabled) "
    		+ "VALUES(#{account.userId},#{account.username},#{account.password},#{account.userTel},#{account.userDesc},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled})")
	public void insertUser(@Param("account") Account account);
	
	@Insert("INSERT INTO test_autorities VALUES(#{uid},#{autorityId})")
	public void insertUserAutority(@Param("uid") int uid,@Param("autorityId")int autorityId);
	
	@Select("SELECT * FROM test_user")
	public List<Account> readAllUsers();
	
	@Delete("DELETE FROM test_user where userName=#{username}")
	public void deleteAccount(@Param("username")String name);

	
}