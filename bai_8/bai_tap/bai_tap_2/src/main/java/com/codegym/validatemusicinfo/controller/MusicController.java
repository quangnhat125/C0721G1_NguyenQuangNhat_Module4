package com.codegym.validatemusicinfo.controller;

import com.codegym.validatemusicinfo.model.Music;
import com.codegym.validatemusicinfo.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService musicService;
    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable) {
        Page<Music> musicPage = musicService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/views/index");
        modelAndView.addObject("songList", musicPage);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateMusicForm() {
        ModelAndView modelAndView = new ModelAndView("/views/create");
        List<Music> musicList = musicService.findAll();
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Music music, @PageableDefault(value = 5) Pageable pageable) {
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/views/index");
        Page<Music> musicPage = musicService.findAll(pageable);
        modelAndView.addObject("musicList", musicPage);
        modelAndView.addObject("message", "Add Completed!");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        List<Music> musicList = musicService.findAll();
        ModelAndView modelAndView = new ModelAndView("/views/edit");
        modelAndView.addObject("music", musicService.findById(id));
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Music music) {
        musicService.update(music);
        List<Music> musicList = musicService.findAll();
        ModelAndView modelAndView = new ModelAndView("/views/index");
        modelAndView.addObject("musicList", musicList);
        modelAndView.addObject("message", "Update Completed!");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        musicService.delete(id);
        List<Music> musicList = musicService.findAll();
        ModelAndView modelAndView = new ModelAndView("/views/index");
        modelAndView.addObject("musicList", musicList);
        modelAndView.addObject("message", "Deleted Completed!");
        return modelAndView;
    }
}
