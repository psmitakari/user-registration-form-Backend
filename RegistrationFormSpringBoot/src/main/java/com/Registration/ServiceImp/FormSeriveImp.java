package com.Registration.ServiceImp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Registration.Exception.FormDetailsAlreadyExistException;
import com.Registration.Exception.FormDetailsNotFountException;
import com.Registration.Repository.FormRespository;
import com.Registration.Service.FormService;
import com.Registration.entities.Form;


@Service
public class FormSeriveImp implements FormService {

	@Autowired
	private FormRespository repo;
	
	public List<Form> getAllDetails() throws FormDetailsNotFountException {
		List<Form> forms = repo.findAll();//built_in query
		
//		List<Form> forms = repo.getDetails();//custom query
		if(forms.isEmpty()) {
			throw new FormDetailsNotFountException("details is empty.please add ");
		}
		return forms;
	}

	public Form saveDetails(Form form) throws FormDetailsAlreadyExistException {
		
		Form form1 = null;
		if(repo.existsById(form.getId())) {
			throw new FormDetailsAlreadyExistException("add new details is already exist");
		}
		else {
			form1 = repo.save(form);
		}
		return form1;
	}

//	public String updateDetails(long id,Form form) {
////		List<Form> forms = repo.findAll();
////		for(int i=0;i<forms.size();i++){
////			Form f = forms.get(i);
////			
////			
////		}
////			
//		
//		return null;
//	}

	public String deleteDetails(long id) {
		Form form =null;
		repo.deleteById(id);
		return "deleted";
		
	}

	@Override
	public String updateDetails(Long id, Form form) {
		List<Form> forms = repo.findAll();
	for(int i=0;i<forms.size();i++){
		Form f = forms.get(i);
				
		}		
	return null;
	}

	
}
