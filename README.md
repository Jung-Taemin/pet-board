# pet-board

├── global                            # 전역 설정 및 공통 처리
│   ├── config                        # CORS, Swagger, S3, Security 설정 등
│   ├── exception                     # 예외 처리 전역
│   │   ├── GlobalExceptionHandler.java
│   │   ├── CustomException.java
│   │   └── ErrorCode.java
│   ├── response                      # 공통 응답 포맷
│   │   ├── ApiResponse.java
│   │   └── ResponseUtil.java
│   ├── security                      # JWT, 필터, 시큐리티 설정
│   │   ├── JwtTokenProvider.java
│   │   ├── JwtAuthenticationFilter.java
│   │   ├── SecurityConfig.java
│   │   └── UserDetailsImpl.java
│   └── util                          # 공통 유틸 클래스
│       └── S3Uploader.java
│
├── domain                            # 핵심 도메인 기능별로 구성
│   ├── user                          # 회원가입, 로그인, 권한 관리
│   │   ├── controller
│   │   ├── dto
│   │   │   ├── UserRequestDto.java
│   │   │   ├── UserResponseDto.java
│   │   │   └── LoginDto.java
│   │   ├── entity
│   │   │   └── User.java
│   │   ├── repository
│   │   ├── service
│   │   └── validator                 # 이메일/비밀번호 유효성 검사 등
│
│   ├── post                          # 게시판 (자유게시판, 공지사항)
│   │   ├── controller
│   │   ├── dto
│   │   │   ├── PostRequestDto.java
│   │   │   └── PostResponseDto.java
│   │   ├── entity
│   │   │   └── Post.java
│   │   ├── repository
│   │   ├── service
│   │   └── type                      # 게시판 유형 enum (자유/공지)
│   │       └── PostCategory.java
│
│   ├── comment                       # 게시글 댓글
│   │   ├── controller
│   │   ├── dto
│   │   ├── entity
│   │   ├── repository
│   │   └── service
│
│   ├── photo                         # 사진첩, 좋아요 등
│   │   ├── controller
│   │   ├── dto
│   │   │   ├── PhotoRequestDto.java
│   │   │   └── PhotoResponseDto.java
│   │   ├── entity
│   │   │   ├── Photo.java
│   │   │   └── PhotoLike.java
│   │   ├── repository
│   │   └── service
│
│   ├── item                          # 반려동물 물품 공유
│   │   ├── controller
│   │   ├── dto
│   │   │   ├── ItemRequestDto.java
│   │   │   └── ItemResponseDto.java
│   │   ├── entity
│   │   ├── repository
│   │   └── service
│
│   └── admin                         # 관리자 전용 기능 (공지 등록, 사용자 관리 등)
│       ├── controller
│       ├── service
│       └── dto
│
├── common                            # 공통 상수, Enum 등
│   ├── constants
│   │   └── AuthConstants.java
│   └── enums
│       ├── UserRole.java
│       ├── PostCategory.java
│       └── FileType.java
