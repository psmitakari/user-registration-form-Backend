package com.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Registration.Exception.FormDetailsAlreadyExistException;
import com.Registration.Exception.FormDetailsNotFountException;
import com.Registration.Service.FormService;
import com.Registration.entities.Form;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping("/Form")
public class FormController {

	@Autowired
	private FormService service;
	
	//for getting the data 
	@GetMapping("/forms")
	@Operation(summary="to get all the details")
	public ResponseEntity<?> get(){
		
		ResponseEntity<?> response = null;
		
		try {
			response = new ResponseEntity<>(service.getAllDetails(),HttpStatus.OK);
		} catch (FormDetailsNotFountException e) {
			response = new ResponseEntity<>(e.getMessage(),HttpStatus.OK);

		}
		
		return response;
	}
	
	
	//posting the data
	@PostMapping("/form")
	@Operation(summary="to post the new details" )
	public ResponseEntity<?> post(@RequestBody Form form){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.saveDetails(form),HttpStatus.OK);
		} catch (FormDetailsAlreadyExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
		
		return response;
	}
	

	@DeleteMapping("/form/{id}")
	@Operation(summary = "to delete the existing product by using formid")
	public ResponseEntity<?> deletedetail(@PathVariable(value="id")long id)
	{
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(service.deleteDetails(id),HttpStatus.OK);
		return response;
		
	}
	
}
