package com.example.toy.controller;

import com.example.toy.dto.BoardDTO;
import com.example.toy.entity.Board;
import com.example.toy.repository.WriteRepository;
import com.example.toy.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
@Log4j2
public class BoardController {
    @Autowired
    private WriteRepository writeRepository;

    @Autowired
    private BoardService boardService;


    @GetMapping("")
    public String list(Model model) {
        List<Board> writeEntityList = writeRepository.findAll();
        model.addAttribute("writeList", writeEntityList);
        return "board/board";
    }

    // 검색 및 카테고리 시작

    @GetMapping("/search")
    public String search(@RequestParam(value="keyword") String keyword, Model model) {
        log.info(keyword);
        List<Board> writeEntityList = boardService.search(keyword);
        model.addAttribute("writeList", writeEntityList);

        return "board/board";
    }

    @GetMapping("/type")
    public String type(@RequestParam(value="type") String type, Model model) {
        log.info(type);
        List<Board> writeEntityList = boardService.type(type);
        model.addAttribute("writeList", writeEntityList);

        return "board/board";
    }

    @GetMapping("/recruit")
    public String recruit(@RequestParam(value="recruit") String recruit, Model model) {
        log.info(recruit);
        List<Board> writeEntityList = boardService.recruit(recruit);
        model.addAttribute("writeList", writeEntityList);

        return "board/board";
    }

    @GetMapping("/online")
    public String online(@RequestParam(value="online") String online, Model model) {
        log.info(online);
        List<Board> writeEntityList = boardService.online(online);
        model.addAttribute("writeList", writeEntityList);

        return "board/board";
    }

    @GetMapping("/career")
    public String career(@RequestParam(value="career") String career, Model model) {
        log.info(career);
        List<Board> writeEntityList = boardService.career(career);
        model.addAttribute("writeList", writeEntityList);

        return "board/board";
    }

    // 검색 및 카테고리 끝


    @GetMapping("/{writeidx}")
    public String view(@PathVariable Long writeidx, Model model) {
        log.info("id = " + writeidx);
        Board writeEntity = writeRepository.findById(writeidx).orElse(null);
        model.addAttribute("write", writeEntity);
        return "/board/view";
    }

    @GetMapping("/edit/{writeidx}")
    public String edit(@PathVariable Long writeidx, Model model) {
        Board writeEntity = writeRepository.findById(writeidx).orElse(null);
        model.addAttribute("edit", writeEntity);
        return "board/edit";
    }

    @PostMapping("/edit/{writeidx}/ok")
    public String editok(BoardDTO form) {
        log.info(form.toString());
        Board writeEntity = form.toEntity();
        log.info(writeEntity.toString());

        Optional<Board> target = Optional.ofNullable(writeRepository.findById(writeEntity.getWriteidx()).orElse(null));
        if (target != null) {
            writeRepository.save(writeEntity);
        }
        return "redirect:/board/{writeidx}";
    }

    @GetMapping("/delete/{writeidx}")
    public String delete(@PathVariable Long writeidx) {
        log.info("삭제");
        Board wtarget = writeRepository.findById(writeidx).orElse(null);
        if (wtarget != null) {
            writeRepository.delete(wtarget);
        }
        return "/board";
    }
}
