package com.petboard.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignUpRequestDto {

    private String email;
    private String password;
    private String nickname;

    private Long gradeId;
}
