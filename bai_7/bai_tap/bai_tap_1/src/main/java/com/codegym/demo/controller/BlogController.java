package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import com.codegym.demo.service.IBlogService;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ModelAndView listBlog() {
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateBlogForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        List<Category> categoryList = iCategoryService.findAll();
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("message", "Add Completed!");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        List<Category> categoryList = iCategoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Blog blog) {
        blogService.update(blog);
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/index");
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("message", "Update Completed!");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        blogService.deleteBlog(id);
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView =  new ModelAndView("/blog/index");
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("message", "Deleted Completed!");
        return modelAndView;
    }

}
