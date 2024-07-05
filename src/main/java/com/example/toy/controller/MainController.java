package com.example.toy.controller;

import com.example.toy.entity.Board;
import com.example.toy.repository.WriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private WriteRepository writeRepository;

    @GetMapping("/")
    public String main(Model model) {
        List<Board> writeEntityList = writeRepository.findAll();
        model.addAttribute("writeList", writeEntityList);
        return "main/main";
    }
}
