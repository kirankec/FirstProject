package com.kiran.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kiran.entities.ToDo;
import com.kiran.services.ToDoService;

@Controller
public class HomeController {
	
	@Autowired
	private ToDoService todoservice;
	
	@RequestMapping("/home")
	public String home(Model m){
		m.addAttribute("page", "home");
		return "home";
	}
	
	@RequestMapping("/add")
	public String add(Model m){
		ToDo t = new ToDo();
		m.addAttribute("page", "add");
		m.addAttribute("todo", t);
		return "home";
	}
	
	@RequestMapping(path="/saveToDo", method=RequestMethod.POST)
	public String saveToDo(@ModelAttribute("todo") ToDo t, Model m){
		t.setDate(new Date());
		String i = todoservice.save(t);
		m.addAttribute("title", t.getTitle());
		m.addAttribute("content", t.getContent());
		m.addAttribute("returned", i);
		return "home";
	}

}
