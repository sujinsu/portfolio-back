package com.portfolio.backend.common.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResultVo {

    private int status;
    private Object data;

    public ResultVo(int status, Object data){
        this.status = status;
        this.data = data;
    }

    public ResultVo(Object data){
        this.status = HttpStatus.OK.value();
        this.data = data;
    }
}
