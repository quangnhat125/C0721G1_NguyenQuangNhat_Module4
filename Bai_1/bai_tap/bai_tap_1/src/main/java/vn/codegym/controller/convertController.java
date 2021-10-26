package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class convertController {
    @RequestMapping("/convert")
    private String result(Model model, HttpServletRequest request){
        Double vnd = Double.parseDouble(request.getParameter("vnd"));
        Double usd = vnd / 23000;
        model.addAttribute("usd", usd);
        return "result";
    }
}
