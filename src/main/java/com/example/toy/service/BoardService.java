package com.example.toy.service;

import com.example.toy.entity.Board;
import com.example.toy.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public List<Board> search(String keyword) {
        List<Board> boardList = boardRepository.findByWritetitleContaining(keyword);
        return boardList;
    }

    @Transactional
    public List<Board> type(String type) {
        List<Board> boardList = boardRepository.findByWritetypeContaining(type);
        return boardList;
    }

    @Transactional
    public List<Board> recruit(String recruit) {
        List<Board> boardList = boardRepository.findByWriterecruitContaining(recruit);
        return boardList;
    }

    @Transactional
    public List<Board> online(String online) {
        List<Board> boardList = boardRepository.findByWriteonlineContaining(online);
        return boardList;
    }

    @Transactional
    public List<Board> career(String career) {
        List<Board> boardList = boardRepository.findByWritecareerContaining(career);
        return boardList;
    }
}
