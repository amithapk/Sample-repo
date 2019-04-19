package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonProperty;

@Controller
public class ControllerDemo {
	
	
	
@Autowired
	TestDaoImpl testDaoImpl;

	@GetMapping("/get/{names}")
	public @ResponseBody List<Employee> getEmp(@PathVariable("names") List<String> names) {
		//return testDaoImpl.getEmployee();
		return testDaoImpl.getEmp(names);
	}
}
