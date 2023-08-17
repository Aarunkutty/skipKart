package com.aarun.skipkart.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {
//	@org.springframework.web.bind.annotation.ExceptionHandler(UserDefindException.class)
//	public ResponseEntity<ResponseStucture<String>> handlingExpection(UserDefindException defindException) {
//		ResponseStucture<String> responseStucture = new ResponseStucture<>();
//		responseStucture.setData("");
//		responseStucture.setMessage(defindException.getMessage());
//		responseStucture.setStatus(HttpStatus.BAD_REQUEST.value());
//
//		return new ResponseEntity<ResponseStucture<String>>(responseStucture, null, HttpStatus.BAD_REQUEST.value());
//
//	}
}
