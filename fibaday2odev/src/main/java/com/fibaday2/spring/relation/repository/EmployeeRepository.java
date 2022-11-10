package com.fibaday2.spring.relation.repository;


import java.util.List;
import com.fibaday2.spring.relation.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface EmployeeRepository extends CrudRepository <Employee, Long> {
	@Query ("select p from Employee p where p.department.departmentId = :departmentId")
	List<Employee> findAllByTeamId (long departmentId);
}