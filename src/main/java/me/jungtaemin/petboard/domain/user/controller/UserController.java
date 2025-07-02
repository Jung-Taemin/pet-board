package me.jungtaemin.petboard.domain.user.controller;

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
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponseDto> signup(@RequestBody UserSignUpRequestDto request) {
        UserSignUpResponseDto response = userService.signup(request);
        return ResponseEntity.ok(response);
    }
}
