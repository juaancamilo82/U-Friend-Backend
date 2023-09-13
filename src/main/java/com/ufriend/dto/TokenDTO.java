package com.ufriend.dto;

import lombok.Data;

@Data
public class TokenDTO {
    private String accessToken;
    private String refreshToken;
}
