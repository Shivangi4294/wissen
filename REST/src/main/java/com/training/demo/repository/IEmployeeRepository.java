package com.training.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.demo.Entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query ("SELECT E FROM Employee E where E.id = ?1 " )
//	List<Employee> getAllEmployees();
	List<Employee> getAllEmployeeById(int id);
	
	@Query(value = "SELECT * FROM Employee where name = ?1", nativeQuery = true)
	List<Employee> getAllByName(String name);
}
