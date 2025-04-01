package com.portfolio.backend.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
