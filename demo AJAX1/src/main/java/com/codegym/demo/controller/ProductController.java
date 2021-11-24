package com.codegym.demo.controller;

import com.codegym.demo.model.Category;
import com.codegym.demo.model.Product;
import com.codegym.demo.repository.IProductRepository;
import com.codegym.demo.service.ICategoryService;
import com.codegym.demo.service.IProductService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ICategoryService categoryService;


    @ModelAttribute("category")
    public List<Category> categoryList() {
        return categoryService.findAll();
    }

    //    @GetMapping("")
//    public ResponseEntity<?> listProduct() {
//        List<Product> productList = productService.findAll();
//        if (productList.size() == 0) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }
    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        List<Product> productList = productService.findAll();
        if (productList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);

    }

    @GetMapping("/home")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<?> createProduct(@RequestBody Product product, @PathVariable String id) {
        Long new_id = Long.parseLong(id);
        Category category = categoryService.findById(new_id);
        product.setCategory(category);
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//    @GetMapping("/category")
//    public ResponseEntity<?> getCategory(@PathVariable) {
//        Category category = categoryService.findById(id)
//        if (productList.size() == 0) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }
    @PostMapping("/edit/{id}")
    public ResponseEntity<?> editProduct(@PathVariable String id) {
        Long new_id = Long.parseLong(id);
        Product product = productService.findById(new_id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Product product){
        Long new_id = Long.parseLong(id);
        Category category = categoryService.findById(new_id);
        product.setCategory(category);
        productService.save(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        Long new_id = Long.parseLong(id);
        productService.delete(new_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<?> searchProduct(@RequestParam(value = "pId", defaultValue = "") String id,
                                           @RequestParam(value = "pName", defaultValue = "") String productName,
                                           @RequestParam(value = "pPrice", defaultValue = "") String price,
                                           @RequestParam(value = "pDes", defaultValue = "") String description,
                                           @RequestParam(value = "pProducer", defaultValue = "") String producer,
                                           @RequestParam(value = "cateId", defaultValue = "") String category,
                                           @RequestParam(value = "page", defaultValue = "0") String page){
        List<Product> productList = productService.search(id, productName, price, description, producer, category,0,9999);
        int sizePage = 2;
//        int totalPage = productList.size() / sizePage;
        int page_1 = Integer.parseInt(page) * sizePage;
        List<Product> productList1 = productService.search(id, productName, price, description, producer, category, page_1, sizePage);
        return new ResponseEntity<>(productList1, HttpStatus.OK);

    }
    @ModelAttribute("totalpage")
    public int getTotalPage() {
        List<Product> productList = productService.search("", "", "", "", "", "",0,9999);
        int sizePage = 2;
        int totalPage = productList.size() / sizePage;
        return totalPage;
    }
    @GetMapping("detail/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
