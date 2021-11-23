package com.codegym.furamaresortcasestudy.repository;

import ch.qos.logback.core.boolex.EvaluationException;
import com.codegym.furamaresortcasestudy.model.Employee;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value ="SELECT * FROM employee WHERE employee_name LIKE :name AND address LIKE :address AND position_id LIKE :typePosition AND education_id LIKE :typeEducation AND division_id LIKE :typeDivision", nativeQuery = true)
    Page<Employee> search(Pageable pageable, String name, String address, String typePosition, String typeEducation, String typeDivision);
}
