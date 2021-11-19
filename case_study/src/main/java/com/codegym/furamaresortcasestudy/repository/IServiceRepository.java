package com.codegym.furamaresortcasestudy.repository;

import com.codegym.furamaresortcasestudy.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceRepository extends JpaRepository<Service, Long> {
}
