package com.fibaday2.spring.relation.repository;

import org.springframework.data.repository.CrudRepository;
import com.fibaday2.spring.relation.entity.Department;

public interface DepartmentRepository extends CrudRepository <Department, Long> {	
}