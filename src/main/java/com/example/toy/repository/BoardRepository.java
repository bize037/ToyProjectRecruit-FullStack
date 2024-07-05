package com.example.toy.repository;

import com.example.toy.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByWritetitleContaining(String writetitle);
    List<Board> findByWritetypeContaining(String writetype);
    List<Board> findByWriterecruitContaining(String writerecruit);
    List<Board> findByWriteonlineContaining(String writeonline);
    List<Board> findByWritecareerContaining(String writecareer);
}
