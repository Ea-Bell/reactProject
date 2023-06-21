package com.reactproject.reactProject.controller;

import com.reactproject.reactProject.common.vo.ResponseVO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 반드시 json데이터 형식으로 만들어서 내려 보내야함 ex) Map, Object....
 */
@RestController
@Slf4j
public class ReactController {



    @GetMapping(value = "/first")
    public ResponseVO first(){
        log.info("initCall");

        return ResponseVO.of()
                .data("first call")
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping(value = "/text")
    public ResponseVO text(@RequestBody Map<String, Object> resultMap){
        log.info("resultMap={}", resultMap);

        Map<String, Object> resultMap2 = new HashMap<>();
        resultMap2.put("text", "임시테스트");

        return ResponseVO.of()
                .data("ResponseVO test")
                .status(HttpStatus.OK)
                .build();
    }
}
