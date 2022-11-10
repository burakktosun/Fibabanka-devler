package com.fibaday2.spring.relation.mvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fibaday2.spring.relation.entity.Employee;
import com.fibaday2.spring.relation.entity.Department;
import com.fibaday2.spring.relation.repository.DepartmentRepository;

@Controller
@RequestMapping("/sports")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository; 
	
	@GetMapping("/department/insert")
	@ResponseBody
	public String insertDepartment() {
		Department departmentA = new Department(0, "Şirket");
		departmentA.setEmployeeList(new ArrayList<>());
		
		Employee employee1 = new Employee(0, "Orhan Gencebay ", 10000);
		employee1.setDepartment(departmentA);
		departmentA.getEmployeeList().add(employee1);
		
		Employee employee2 = new Employee(0, "Ferdi Tayfur " , 15000);
		employee2.setDepartment(departmentA);
		departmentA.getEmployeeList().add(employee2);
		
		Employee employee3 = new Employee(0, "Fikret Kızılok", 20000);
		employee3.setDepartment(departmentA);
		departmentA.getEmployeeList().add(employee3);
		
		departmentRepository.save(departmentA);
		
		return "Sokuldu : "+departmentA.getDepartmentId() ;
	}
	
}
