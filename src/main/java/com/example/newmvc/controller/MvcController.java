package com.example.newmvc.controller;

import com.example.newmvc.entity.BinaryDecimal;
import com.example.newmvc.entity.BinaryHex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MvcController {

    @GetMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "MVC + Thymeleaf") String name
                        , Model model){
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model){
        model.addAttribute("processors", Runtime.getRuntime().availableProcessors());
        model.addAttribute("FreeMemory", Runtime.getRuntime().freeMemory());
        model.addAttribute("TotalMemory", Runtime.getRuntime().totalMemory());
        return "info";
    }
    //Сделать передачу данных по заданию JSON API , ответ автоматическое конвертирование
    @GetMapping("/converter")
    public String converter(){
        return "converter";
    }

    @PostMapping("/converter")
    public String converter(@RequestParam(name = "binaryNumber", required = false)
            String binaryNumber, @RequestParam(name = "binaryNumberPath2", required = false)
            String binaryNumberPath2, @RequestParam(name = "decimalNumber", required = false) Integer
            decimalNumber, @RequestParam(name = "hexNumber", required = false) String hexNumber,
                                Model model){
        if(binaryNumber != null) {
            model.addAttribute("decimalNumber", BinaryDecimal.toDecimal(binaryNumber)); //2k10
        }
        if(binaryNumberPath2 != null) {
            model.addAttribute("hexNumber", BinaryHex.toHex(binaryNumberPath2)); //2k16
        }
        if(decimalNumber != null) {
            model.addAttribute("binaryNumber", BinaryDecimal.toBinary(decimalNumber)); //10k2
        }
        if(hexNumber != null) {
            model.addAttribute("binaryNumberPath2", BinaryHex.toBinary(hexNumber)); //16k2
        }
        return "converter";
    }
}

