package com.kiran.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kiran.entities.ToDo;

@Component
public class ToDoService {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public String save(ToDo t){
		String i = (String) hibernateTemplate.save(t);
		return i;
	}

}
