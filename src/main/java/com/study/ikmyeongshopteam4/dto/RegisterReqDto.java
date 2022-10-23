package com.study.ikmyeongshopteam4.dto;

import lombok.Data;

@Data
public class RegisterReqDto {
    private String username;
    private String password;
    private String checkPassword;
    private String name;
    private String email;
    private String cellphone;
    private String phone;
    private String address;
}
