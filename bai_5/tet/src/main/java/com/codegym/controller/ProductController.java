package com.codegym.controller;


import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.codegym.service.IProductService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, Model model) {
        productService.save(product);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("success", "Add Completed!");
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        productService.delete(id);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("success", "Delete Completed!");
        return "index";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product, Model model) {
        productService.update(product);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("success", "Update Completed!");
        return "index";
    }
}
