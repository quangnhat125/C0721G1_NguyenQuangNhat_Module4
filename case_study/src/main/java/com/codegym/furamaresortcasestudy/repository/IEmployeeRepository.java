package com.codegym.furamaresortcasestudy.repository;

import com.codegym.furamaresortcasestudy.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
