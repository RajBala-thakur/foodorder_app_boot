package com.ty.food_app.food_app_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.food_app.food_app_boot.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseStructure<String> noSuchIdFoundHandler(NoSuchIdFoundException exception)
	{
		ResponseStructure<String >responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("IdNotFoundException");
		responseStructure.setData(exception.getMessage());
		return responseStructure;
	}
	@ExceptionHandler(UnableToUpdateException.class)
	public ResponseStructure<String> unableToUpdateHandler(UnableToUpdateException exception)
	{
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("UnableToUpdateException");
		responseStructure.setData(exception.getMessage());
		return responseStructure;
		
	}
	@ExceptionHandler(UnableToDeleteException.class)
	public ResponseStructure<String> unableToDeleteHandler(UnableToDeleteException exception)
	{
		ResponseStructure<String>responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("UnableToDeleteException");
		responseStructure.setData(exception.getMessage());
		return responseStructure;
		
	}
	
	
}
