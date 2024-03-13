package com.Registration.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Parameters are name, address, email ID, addhar card and mobile no
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Form {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String address;
	private String emailId;
	
	@TableGenerator(name = "Form", pkColumnName = "addharNo")
	private String addharNo;
	private String mobileNo;
	
	
	
}
