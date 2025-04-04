package com.portfolio.backend.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ExceptionMessageVo implements Serializable {
    private int status;
    private Map<String, String> data = new HashMap<>();

    public ExceptionMessageVo(int status, String code, String message){
        this.status = status;
        this.data.put("code", code);
        this.data.put("message", message);
    }
}
