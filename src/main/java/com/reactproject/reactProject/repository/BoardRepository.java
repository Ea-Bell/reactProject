package com.reactproject.reactProject.repository;


import com.reactproject.reactProject.domain.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardVO, Integer> {

    List<BoardVO> findTop10ByOrderByDocNumAsc();
}
