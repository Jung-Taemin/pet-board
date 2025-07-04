package me.jungtaemin.petboard.domain.user.dto;

import lombok.Getter;

@Getter
public class UserLoginRequestDto {
    private String email;
    private String password;
}
