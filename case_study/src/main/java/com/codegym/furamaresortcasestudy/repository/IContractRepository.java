package com.codegym.furamaresortcasestudy.repository;

import com.codegym.furamaresortcasestudy.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Long> {
}
