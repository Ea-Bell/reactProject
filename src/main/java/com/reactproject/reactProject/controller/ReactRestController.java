package com.reactproject.reactProject.controller;

import com.reactproject.reactProject.common.vo.ResponseVO;
import com.reactproject.reactProject.domain.BoardVO;
import com.reactproject.reactProject.repository.BoardRepository;
import com.reactproject.reactProject.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 반드시 json데이터 형식으로 만들어서 내려 보내야함 ex) Map, Object....
 */
@Slf4j
@RestController
@AllArgsConstructor
public class ReactRestController {

    private final BoardService boardService;

    @GetMapping(value = "/first")
    public ResponseVO first(){
        List<BoardVO> top10BoardList = this.boardService.getBoardTop10();
        //log.debug("top10BoardList={}", top10BoardList);
        return ResponseVO.of()
                .data(top10BoardList)
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping(value = "/text")
    public ResponseVO text(@RequestBody Map<String, Object> resultMap){
        List<BoardVO> top10BoardList = this.boardService.getBoardTop10();
        Map<String, Object> resultMap2 = new HashMap<>();
        resultMap2.put("text", "임시테스트");

        return ResponseVO.of()
                .data(top10BoardList)
                .status(HttpStatus.OK)
                .build();
    }
}
