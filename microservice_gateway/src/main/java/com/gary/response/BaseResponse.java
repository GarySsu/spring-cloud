package com.gary.response;

import lombok.Data;

@Data
public class BaseResponse {

    private String status;
    private String message;

    public BaseResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
