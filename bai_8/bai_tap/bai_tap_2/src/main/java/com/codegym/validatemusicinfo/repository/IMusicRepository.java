package com.codegym.validatemusicinfo.repository;

import com.codegym.validatemusicinfo.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Long> {
}
