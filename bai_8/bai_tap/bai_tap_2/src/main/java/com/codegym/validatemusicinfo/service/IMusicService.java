package com.codegym.validatemusicinfo.service;

import com.codegym.validatemusicinfo.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    Page<Music> findAll(Pageable pageable);
    void update(Music music);
    void save(Music music);
    void delete(Long id);
    Music findById(Long id);
}
