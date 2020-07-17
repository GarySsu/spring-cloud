package com.gary.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String username;
    private String address;
    private int age;
    private String lastLoginTime;

}
