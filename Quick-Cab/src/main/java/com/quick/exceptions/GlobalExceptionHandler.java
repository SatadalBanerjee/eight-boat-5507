package com.quick.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(AdminException.class)
	 public ResponseEntity<MyErrorDetails> adminExceptionHandler(AdminException ae, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(ae.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 
	 @ExceptionHandler(CabException.class)
	 public ResponseEntity<MyErrorDetails> CabExceptionHandler(CabException ce, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(ce.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 
	 @ExceptionHandler(CustomerException.class)
	 public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(ce.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 
	 @ExceptionHandler(DriverException.class)
	 public ResponseEntity<MyErrorDetails> driverExceptionHandler(DriverException de, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(de.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(TripBookingException.class)
	 public ResponseEntity<MyErrorDetails> TripBookingExceptionHandler(TripBookingException tbe, WebRequest req) {
		 MyErrorDetails err = new MyErrorDetails();
	  
	  err.setTimestamp(LocalDateTime.now());
	  err.setMessage(tbe.getMessage());
	  err.setDetails(req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	 }
	 
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<MyErrorDetails> exception(MethodArgumentNotValidException manve, WebRequest req){
			
			
			MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(manve.getMessage());
			err.setDetails(req.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
			
		}
	 
	 @ExceptionHandler(Exception.class)
		public ResponseEntity<MyErrorDetails> exception(Exception e, WebRequest req){
			
			
			MyErrorDetails err= new MyErrorDetails();
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(e.getMessage());
			err.setDetails(req.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
			
		}
}
