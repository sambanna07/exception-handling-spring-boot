package com.exceptionhandler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exceptionhandler.entity.Employee;
import com.exceptionhandler.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * Retrieves all employees.
	 * 
	 * @return ResponseEntity<List<Employee>> containing the list of employees
	 */
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> list = employeeService.getAllEmployees();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	/**
	 * Retrieves an employee by ID.
	 * 
	 * @param employeeId the ID of the employee to retrieve
	 * @return ResponseEntity<Employee> containing the employee details
	 */
	@GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
		Employee employeeById = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employeeById, HttpStatus.OK);
	}
	
	/**
	 * Saves a new employee.
	 * 
	 * @param employee the employee to be saved
	 * @return ResponseEntity<Employee> containing the saved employee details
	 */
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee saveEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}
	
	/**
	 * Updates an existing employee.
	 * 
	 * @param employee the updated employee details
	 * @return ResponseEntity<Employee> containing the updated employee details
	 */
	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
	}
	
	/**
	 * Deletes an employee by ID.
	 * 
	 * @param employeeId the ID of the employee to delete
	 * @return ResponseEntity<String> indicating the successful deletion
	 */
	@DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmployee(@RequestParam(value = "id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>("Employee deleted", HttpStatus.ACCEPTED);
	}
}
