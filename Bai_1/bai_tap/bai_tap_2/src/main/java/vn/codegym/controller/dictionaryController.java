package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class dictionaryController {
    @RequestMapping("/dictionary")
    public String search(Model model, HttpServletRequest request){
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Hello", "Xin chào");
        dictionary.put("Computer", "Máy tính");
        dictionary.put("Book", "Quyển sách");
        dictionary.put("Television", "Tivi");
        dictionary.put("Keyboard", "Bàn phím");
        String search = request.getParameter("search");
        String result = null;
        for (String key : dictionary.keySet()) {
            if (search.equals(key)) {
                result = dictionary.get(key);
                break;
            }
        }
        model.addAttribute("result", result);
        model.addAttribute("search", search);
        return "dictionary";
    }
}
