package com.reactproject.reactProject.service;

import com.reactproject.reactProject.domain.BoardVO;
import com.reactproject.reactProject.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardVO> getBoardTop10() {
        return this.boardRepository.findTop10ByOrderByDocNumAsc();
    }
}
