package com.Registration.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Registration.entities.Form;


@Repository
public interface FormRespository extends JpaRepository<Form, Long> {
	
	@Query(value="select f from Form f") //HQl
	public List<Form> getDetails();
	
	@Query(value="select f from Form f where f.id = :id")
	public Form formById(@Param(value = "id")long id);
}
