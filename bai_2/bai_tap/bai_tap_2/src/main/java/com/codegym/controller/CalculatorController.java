package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {
    @GetMapping
    public String calculator() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam(name = "number1") double number_1,
                             @RequestParam(name = "number2") double number_2,
                             @RequestParam(name = "calculate") String calculator,
                             Model model){
        double result = 0;
        switch (calculator) {
            case "+":
                result = number_1 + number_2;
                model.addAttribute("result", result);
                break;
            case "-":
                result = number_1 - number_2;
                model.addAttribute("result", result);
                break;
            case "*":
                result = number_1 * number_2;
                model.addAttribute("result", result);
                break;
            case "/":
                result = number_1 / number_2;
                model.addAttribute("result", result);
                break;
        }
        return "calculator";
    }
}
