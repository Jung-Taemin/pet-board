package me.jungtaemin.petboard.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.jungtaemin.petboard.domain.user.dto.UserLoginRequestDto;
import me.jungtaemin.petboard.domain.user.dto.UserLoginResponseDto;
import me.jungtaemin.petboard.domain.user.dto.UserSignUpRequestDto;
import me.jungtaemin.petboard.domain.user.dto.UserSignUpResponseDto;
import me.jungtaemin.petboard.domain.user.service.UserService;
import me.jungtaemin.petboard.global.response.ApiResponse;
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
    public ResponseEntity<ApiResponse<UserSignUpResponseDto>> signup(@RequestBody UserSignUpRequestDto request) {
        UserSignUpResponseDto response = userService.signup(request);
        return ResponseEntity.ok(ApiResponse.success(response, "회원가입 성공"));
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "이메일, 비밀번호를 통해 로그인을 진행합니다.")
    public ResponseEntity<ApiResponse<UserLoginResponseDto>> login(@RequestBody UserLoginRequestDto request) {
        UserLoginResponseDto response = userService.login(request);
        return ResponseEntity.ok(ApiResponse.success(response, "로그인 성공"));
    }
}
