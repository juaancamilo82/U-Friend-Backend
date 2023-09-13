package com.ufriend.dto;

import lombok.Data;

@Data
public class RegisterInDTO {
    private String email;
    private String password;
    private String confirmPassword;
}
