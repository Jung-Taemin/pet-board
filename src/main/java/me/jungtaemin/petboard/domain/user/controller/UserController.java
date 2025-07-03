package me.jungtaemin.petboard.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.jungtaemin.petboard.domain.user.dto.UserSignUpRequestDto;
import me.jungtaemin.petboard.domain.user.dto.UserSignUpResponseDto;
import me.jungtaemin.petboard.domain.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "회원", description = "회원 관련 API")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "이메일, 비밀번호, 닉네임을 통해 회원가입을 진행합니다.")
    public ResponseEntity<UserSignUpResponseDto> signup(@RequestBody UserSignUpRequestDto request) {
        UserSignUpResponseDto response = userService.signup(request);
        return ResponseEntity.ok(response);
    }
}
