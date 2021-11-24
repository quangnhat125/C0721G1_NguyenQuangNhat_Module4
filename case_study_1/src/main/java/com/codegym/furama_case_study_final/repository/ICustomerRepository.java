package com.codegym.furama_case_study_final.repository;

import com.codegym.furama_case_study_final.dto.CustomerDetail;
import com.codegym.furama_case_study_final.dto.CustomerInUsing;
import com.codegym.furama_case_study_final.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customer WHERE customer_name LIKE :name AND gender LIKE :gender AND customer_type_id LIKE :typeCustomer", nativeQuery = true)
    Page<Customer> search(Pageable pageable, String name, String gender, String typeCustomer);

    @Query(value ="Select ct.id as contract,s.service_code as service, customer.customer_code as customercode,customer.customer_name as customername,\n" +
            "cd.quantity as quantity,SUM(s.service_cost + coalesce(a.attach_cost*cd.quantity,0)) as total, customer.id as customerid\n" +
            "from customer join contract ct on customer.id = ct.customer\n" +
            "join contract_detail cd on cd.contract = ct.id\n" +
            "join attach_service a on a.id = cd.attach_service\n" +
            "join service s on ct.service = s.id\n" +
            "Group by customer.id\n" +
            "ORDER BY ct.id LIMIT :page, :size", nativeQuery = true)
    List<CustomerInUsing> showList(@Param("page") int page,@Param("size") int size);

   @Query(value ="SELECT customer.customer_code as `code`, a.attach_name as attachname, cd.quantity, a.attach_cost as attachcost, (a.attach_cost * cd.quantity) as total\n" +
           "FROM customer join contract ct on customer.id = ct.customer\n" +
           "join contract_detail cd on cd.contract = ct.id\n" +
           "join attach_service a on a.id = cd.attach_service WHERE customer.id = :id", nativeQuery = true)
    List<CustomerDetail> showListDetail(@Param("id") Long id);
}
