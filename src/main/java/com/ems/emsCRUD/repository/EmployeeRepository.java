package com.ems.emsCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.emsCRUD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
