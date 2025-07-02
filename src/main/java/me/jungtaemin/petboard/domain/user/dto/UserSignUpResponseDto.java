package me.jungtaemin.petboard.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSignUpResponseDto {

    private Long userId;
    private String email;
    private String nickname;
}
