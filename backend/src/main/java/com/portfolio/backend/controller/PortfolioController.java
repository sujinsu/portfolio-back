package com.portfolio.backend.controller;

import com.portfolio.backend.vo.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/portfolio")
@RestController
public class PortfolioController {

    @GetMapping("test")
    public ResultVo testApi(){
        return new ResultVo(HttpStatus.OK.value(), true);
    }
}
