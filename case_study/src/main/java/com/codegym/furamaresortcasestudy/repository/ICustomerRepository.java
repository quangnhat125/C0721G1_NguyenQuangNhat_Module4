package com.codegym.furamaresortcasestudy.repository;

import com.codegym.furamaresortcasestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customer WHERE customer_name LIKE :name AND gender LIKE :gender AND customer_type_id LIKE :typeCustomer", nativeQuery = true)
    Page<Customer> search(Pageable pageable, String name, String gender, String typeCustomer);
}
