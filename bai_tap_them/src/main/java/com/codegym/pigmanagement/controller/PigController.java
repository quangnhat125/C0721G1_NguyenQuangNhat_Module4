package com.codegym.pigmanagement.controller;

import com.codegym.pigmanagement.dto.PigDto;
import com.codegym.pigmanagement.model.OriginCountry;
import com.codegym.pigmanagement.model.Pig;
import com.codegym.pigmanagement.service.ICountryService;
import com.codegym.pigmanagement.service.IPigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pig")
public class PigController {
    @Autowired
    IPigService pigService;
    @Autowired
    ICountryService countryService;

    @ModelAttribute("countryList")
    public List<OriginCountry> getListCountry() {
        return countryService.findAll();
    }


//    @GetMapping("")
//    public ModelAndView listPig(@PageableDefault(value = 5) Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("/list");
//        Page<Pig> pigPage = pigService.findAll(pageable);
//        modelAndView.addObject("pig", pigPage);
//        return modelAndView;
//    }

    @GetMapping(value = {"/search",""})
    public ModelAndView search(@RequestParam(value = "codeSearch", defaultValue = "", required = false) String code,
                               @RequestParam(value = "statusSearch", defaultValue = "", required = false) String status,
                               @RequestParam(value = "country" , defaultValue = "", required = false) String country,
                               @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/list");
        Page<Pig> pigPage = pigService.search(pageable, code, status, country);
        modelAndView.addObject("pigList", pigPage);
        modelAndView.addObject("codeSearch", code);
        modelAndView.addObject("statusSearch", status);
        modelAndView.addObject("country", country);
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam(value = "idPig") String id, @PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/list");
        pigService.deletePig(Long.parseLong(id));
        Page<Pig> pigPage = pigService.findAll(pageable);
        modelAndView.addObject("pigList", pigPage);
        return modelAndView;
    }
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(value = "idDetail") String id){
        ModelAndView modelAndView = new ModelAndView("/detail");
        Pig pig = pigService.findById(Long.parseLong(id));
        PigDto pigDto = new PigDto();
        BeanUtils.copyProperties(pig, pigDto);
        modelAndView.addObject("pigDto",pigDto);
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute @Validated PigDto pigDto, BindingResult bindingResult) {
        List<Pig> pigList = pigService.findAll();
        for (int i = 0; i < pigList.size() ; i++) {
            if (pigList.get(i).getId() == pigDto.getId()){
                pigList.remove(pigList.get(i));
            }
        }
        pigDto.setPigList(pigList);
        new PigDto().validate(pigDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/detail");
        if (!bindingResult.hasFieldErrors()) {
            Pig pig = new Pig();
            BeanUtils.copyProperties(pigDto, pig);
            pigService.save(pig);
            modelAndView.addObject("message", "Edit completed!");
        }
        return modelAndView;
    }
    @GetMapping("/get-top")
    public ResponseEntity<?> getTop(){
        List<Pig> pigList = pigService.getTop();
        return new ResponseEntity<>(pigList,HttpStatus.OK);
    }

}
