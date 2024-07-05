package com.example.toy.repository;

import com.example.toy.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface WriteRepository extends CrudRepository<Board, Long> {
    @Override
    ArrayList<Board> findAll();

    Optional<Board> findById(Long WRITE_IDX);

    Optional<Board> findByWritepw(String writepw);

//    List<TOY_WRITE_TB> findByWriteTitleLike(String WriteTitle);
//    @Query(value = "SELECT a FROM TOY_WRITE_TB a WHERE a.WriteTitle LIKE CONCAT('%', :keyword, '%')")
//    Optional<TOY_WRITE_TB> findByWriteTitie(@Param("WriteTitle") String WriteTitle);

}
