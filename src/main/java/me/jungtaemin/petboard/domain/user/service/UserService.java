package me.jungtaemin.petboard.domain.user.service;

import lombok.RequiredArgsConstructor;
import me.jungtaemin.petboard.domain.user.dto.UserLoginRequestDto;
import me.jungtaemin.petboard.domain.user.dto.UserLoginResponseDto;
import me.jungtaemin.petboard.domain.user.dto.UserSignUpRequestDto;
import me.jungtaemin.petboard.domain.user.dto.UserSignUpResponseDto;
import me.jungtaemin.petboard.domain.user.entity.Grade;
import me.jungtaemin.petboard.domain.user.entity.User;
import me.jungtaemin.petboard.domain.user.repository.GradeRepository;
import me.jungtaemin.petboard.domain.user.repository.UserRepository;
import me.jungtaemin.petboard.global.security.JwtTokenProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GradeRepository gradeRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserSignUpResponseDto signup(UserSignUpRequestDto request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        if (userRepository.existsByNickname(request.getNickname())) {
            throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
        }

        Grade grade = gradeRepository.findById(request.getGradeId())
                .orElseThrow(() -> new IllegalArgumentException("해당 등급이 존재하지 않습니다."));


        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .grade(grade)
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);

        return new UserSignUpResponseDto(user.getUserId(), user.getEmail(), user.getNickname());
    }

    public UserLoginResponseDto login(UserLoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtTokenProvider.generateToken(user.getEmail());
        return new UserLoginResponseDto(token);
    }
}
