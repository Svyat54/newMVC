package com.example.newmvc.controller;

import com.example.newmvc.entity.BinaryDecimal;
import com.example.newmvc.entity.BinaryHex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
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
    public String cconverter(){
        return "converter";
    }

    @PostMapping("/converter")
    public String converter(@RequestParam(name = "binaryNumber", defaultValue = "0", required = false)
            String binaryNumber, @RequestParam(name = "binaryNumberPath2", defaultValue = "0", required = false)
            String binaryNumberPath2, @RequestParam(name = "decimalNumber", defaultValue = "0", required = false) Integer
            decimalNumber, @RequestParam(name = "hexNumber", defaultValue = "0", required = false) String hexNumber,
                                Model model){
        model.addAttribute("decimalNumber", BinaryDecimal.toDecimal(binaryNumber)); //2k10
        model.addAttribute("hexNumber", BinaryHex.toHex(binaryNumberPath2)); //2k16
        model.addAttribute("binaryNumber", BinaryDecimal.toBinary(decimalNumber)); //10k2
        model.addAttribute("binaryNumberPath2", BinaryHex.toBinary(hexNumber)); //16k2
        return "converter";
    }
}

