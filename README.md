# springbootLogin
Login Template Springboot WebApplication.This is project for study and test.

[![Build Status](https://travis-ci.org/skaqud/springbootLogin.svg?branch=develop)](https://travis-ci.org/skaqud/springbootLogin)

## Develop Environment

- OpenJDK 1.8, Mariadb 10.x, Gradle
- Springboot, Lombok, SpringSecurity, thymeleaf

### DB Script

This is db script of this application.(for mariadb, mysqldb)
	
	CREATE TABLE `test_user` (
	  `uid` bigint NOT NULL AUTO_INCREMENT,
	  `userId` varchar(20) NOT NULL,
	  `userName` varchar(50) NOT NULL,
	  `password` varchar(100) NOT NULL,
	  `userTel` varchar(100) DEFAULT NULL,
	  `userDesc` varchar(100) DEFAULT NULL,
	  `isAccountNonExpired` tinyint(1) DEFAULT NULL,
	  `isAccountNonLocked` tinyint(1) DEFAULT NULL,
	  `isCredentialsNonExpired` tinyint(1) DEFAULT NULL,
	  `isEnabled` tinyint(1) DEFAULT NULL,
	  `regDt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	  PRIMARY KEY (`uid`)
	) DEFAULT CHARSET=utf8;
	
	CREATE TABLE `test_autorities` (
	  `authorityId` bigint NOT null,
	  `authorityDesc` varchar(100) DEFAULT NULL,
	  `csp_key_id` bigint NOT nul,
	  PRIMARY KEY (`authorityId`)
	) DEFAULT CHARSET=utf8;
	
