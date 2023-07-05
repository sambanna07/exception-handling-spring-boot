package com.exceptionhandler.service;

import java.util.List;

import com.exceptionhandler.entity.Employee;

public interface EmployeeService {
	
	/**
	 * Get an employee by ID.
	 *
	 * @param employeeId the ID of the employee
	 * @return the employee with the specified ID
	 */
	public Employee getEmployeeById(Long employeeId);

	/**
	 * Save an employee.
	 *
	 * @param employee the employee to save
	 * @return the saved employee
	 */
	public Employee saveEmployee(Employee employee);

	/**
	 * Update an employee.
	 *
	 * @param employee the employee to update
	 * @return the updated employee
	 */
	public Employee updateEmployee(Employee employee);

	/**
	 * Delete an employee by ID.
	 *
	 * @param employeeId the ID of the employee to delete
	 */
	public void deleteEmployee(Long employeeId);

	/**
	 * Get all employees.
	 *
	 * @return a list of all employees
	 */
	public List<Employee> getAllEmployees();
}
