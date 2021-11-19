package com.codegym.furamaresortcasestudy.repository;

import com.codegym.furamaresortcasestudy.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Long> {
}
