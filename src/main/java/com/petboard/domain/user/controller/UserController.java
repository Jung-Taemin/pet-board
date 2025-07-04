package com.petboard.domain.user.controller;

import com.petboard.domain.user.dto.*;
import com.petboard.domain.user.entity.User;
import com.petboard.global.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import com.petboard.domain.user.service.UserService;
import com.petboard.global.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "회원", description = "회원 관련 API")
@SecurityRequirement(name = "JWT")
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

    @SecurityRequirement(name = "JWT")
    @GetMapping("/me")
    @Operation(summary = "로그인한 유저 정보 조회", description = "JWT 토큰을 기반으로 로그인한 유저 정보를 조회합니다.")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyInfo(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        User user = userPrincipal.getUser();
        UserResponseDto response = new UserResponseDto(user);
        return ResponseEntity.ok(ApiResponse.success(response, "내 정보 조회 성공"));
    }
}
