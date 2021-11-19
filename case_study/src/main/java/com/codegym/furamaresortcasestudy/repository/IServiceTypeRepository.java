package com.codegym.furamaresortcasestudy.repository;

import com.codegym.furamaresortcasestudy.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
