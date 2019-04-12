package com.springboot.comm;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
*  Global Exception Handler
*  
* @author      CHOI KI HUN
* @version     1.0
* @since       1.0
*/

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Exception 처리 
	 * 	- Return Code: 400
	 *  
	 * @param request HttpServletRequest
	 * @param ex Exception
	 * 									
	 */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(HttpServletRequest request, Exception ex) {
    	logger.error("[Exception]"+ex.toString());
    	ex.printStackTrace();
        // Exception 예외 발생시 공통 처리 로직 작성
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }
    
	/**
	 * Runtime Exception 처리
	 * 	- Return Code: 500
	 *  
	 * @param request HttpServletRequest
	 * @param ex RuntimeException
	 * 									
	 */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<?> handleRunTimeException(HttpServletRequest request, RuntimeException ex) {
    	logger.error("[RunTimeException]"+ex.toString());
    	ex.printStackTrace();
        // RuntimeException 예외 발생시 공통 처리 로직 작성
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	/**
	 * Custom Exception 처리
	 * 	- Return Code: 500
	 *  
	 * @param request HttpServletRequest
	 * @param ex CustomException
	 * 									
	 */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<?> handleCustomException(HttpServletRequest request, CustomException ex) {
    	logger.error("[CustomException]"+ex.toString());
    	ex.printStackTrace();
        // CustomException 예외 발생시 공통 처리 로직 작성
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}