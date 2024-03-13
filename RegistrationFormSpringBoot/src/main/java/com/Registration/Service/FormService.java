package com.Registration.Service;

import java.util.List;

import com.Registration.Exception.FormDetailsAlreadyExistException;
import com.Registration.Exception.FormDetailsNotFountException;
import com.Registration.entities.Form;

public interface FormService {

	public List<Form> getAllDetails() throws FormDetailsNotFountException;
	public Form saveDetails(Form form) throws FormDetailsAlreadyExistException;
	public String updateDetails(Long id, Form form);
	public String deleteDetails(long id);
	
}
