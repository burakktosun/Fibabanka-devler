package com.fibaday2.spring.relation.mvc;

import java.util.List;
import com.fibaday2.spring.configuration.MyBean;
import com.fibaday2.spring.relation.entity.Employee;
import com.fibaday2.spring.relation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sports")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private MyBean myBean;
	@GetMapping("/employees/bydepartment")
	@ResponseBody
	
	public String getEmployeesByDepartment() {
		System.out.println("Çekirdek " +myBean.getMyLong()+ " "
					+myBean.getMyString()+ " "
					+ myBean.getMyDouble());
		long departmentId=2;
		List<Employee> employees =employeeRepository.findAllByTeamId(departmentId);
		double totalSalary=0;
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeId()+" "
					+employee.getEmployeeName()+" "
					+employee.getMonthlySalary());
			totalSalary+=employee.getMonthlySalary();
		}
		double monthlySalary = totalSalary/employees.size();
		return "Ortalama Maaş: "+monthlySalary;
	}
}