package com.codegym.validatemusicinfo.service;

import com.codegym.validatemusicinfo.model.Music;
import com.codegym.validatemusicinfo.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return musicRepository.findAll(pageable);
    }

    @Override
    public void update(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(Long id) {
        musicRepository.deleteById(id);
    }

    @Override
    public Music findById(Long id) {
        return musicRepository.findById(id).get();
    }
}
