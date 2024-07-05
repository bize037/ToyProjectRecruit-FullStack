package com.example.toy.controller;

import com.example.toy.dto.BoardDTO;
import com.example.toy.entity.Board;
import com.example.toy.repository.WriteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/write")
public class WriteController {

    @Autowired
    private WriteRepository writeRepository;

    @GetMapping("")
    public String write() {
        return "write/write";
    }

    @PostMapping("/ok")
    public String writeok(BoardDTO form) {
        Board write = form.toEntity();
        Board saved = writeRepository.save(write);
//        log.info(saved.toString());
        return "redirect:/board";
    }
}
