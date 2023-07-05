package com.exceptionhandler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.exceptionhandler.entity.Employee;
import com.exceptionhandler.exception.EmptyInputException;
import com.exceptionhandler.exception.EmptyOutputException;
import com.exceptionhandler.reposistories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Retrieves all employees from the database.
	 *
	 * @return List of employees
	 * @throws EmptyOutputException if no data found in the database
	 */
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		if (employeeList.isEmpty()) {
			throw new EmptyOutputException(601, "No data found in the database while fetching employees.");
		}
		return employeeList;
	}

	/**
	 * Retrieves an employee by the given employee ID.
	 *
	 * @param employeeId the ID of the employee to retrieve
	 * @return the employee with the specified ID
	 * @throws EmptyInputException  if the employee ID is null or invalid
	 * @throws EmptyOutputException if no employee found with the given ID
	 */
	@Override
	public Employee getEmployeeById(Long employeeId) {
		if (employeeId == null) {
			throw new EmptyInputException(602, "Employee ID is null. Please provide a valid ID.");
		}
		try {
			return employeeRepository.findById(employeeId)
					.orElseThrow(() -> new EmptyOutputException(603,
							"No employee found with ID: " + employeeId + ". Unable to fetch employee details."));
		} catch (Exception e) {
			throw new EmptyOutputException(604,
					"Something went wrong while fetching employee by ID: " + e.getMessage());
		}
	}

	/**
	 * Saves a new employee to the database.
	 *
	 * @param employee the employee to be saved
	 * @return the saved employee
	 * @throws EmptyInputException  if the employee name or age is blank or invalid
	 * @throws EmptyOutputException if an error occurs while saving the employee
	 */
	@Override
	public Employee saveEmployee(Employee employee) {
		if (employee.getName() == null || employee.getName().isEmpty()) {
			throw new EmptyInputException(605, "Employee name is blank. Please provide a valid name.");
		}
		if (employee.getAge() == null || employee.getAge() <= 0) {
			throw new EmptyInputException(606, "Employee age is blank or negative. Please provide a valid age.");
		}
		try {
			return employeeRepository.save(employee);
		} catch (Exception e) {
			throw new EmptyOutputException(607, "Something went wrong while saving employee: " + e.getMessage());
		}
	}

	/**
	 * Updates an existing employee in the database.
	 *
	 * @param employee the employee to be updated
	 * @return the updated employee
	 * @throws EmptyInputException  if the employee name or age is blank or invalid
	 * @throws EmptyOutputException if an error occurs while updating the employee
	 */
	@Override
	public Employee updateEmployee(Employee employee) {
		if (employee.getName() == null || employee.getName().isEmpty()) {
			throw new EmptyInputException(606, "Employee name is blank. Please provide a valid name.");
		}
		if (employee.getAge() == null || employee.getAge() <= 0) {
			throw new EmptyInputException(606, "Employee age is blank or negative. Please provide a valid age.");
		}
		try {
			return employeeRepository.save(employee);
		} catch (Exception e) {
			throw new EmptyOutputException(607, "Something went wrong while updating employee: " + e.getMessage());
		}
	}

	/**
	 * Deletes an employee from the database based on the employee ID.
	 *
	 * @param employeeId the ID of the employee to be deleted
	 * @throws EmptyInputException  if the employee ID is null or invalid
	 * @throws EmptyOutputException if no employee found with the given ID or an error occurs while deleting the employee
	 */
	@Override
	public void deleteEmployee(Long employeeId) {
		if (employeeId == null) {
			throw new EmptyInputException(603, "Employee ID is null. Please provide a valid ID.");
		}

		boolean existsBeforeDeletion = employeeRepository.existsById(employeeId);
		if (!existsBeforeDeletion) {
			throw new EmptyOutputException(609,
					"No employee found with ID: " + employeeId + ". Unable to delete employee.");
		}

		try {
			employeeRepository.deleteById(employeeId);
		} catch (Exception e) {
			throw new EmptyOutputException(608, "Something went wrong while deleting employee: " + e.getMessage());
		}
	}
}
