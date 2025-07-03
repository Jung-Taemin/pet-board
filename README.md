# pet-board

```text
├── global                     # 공통 설정, 예외 처리, 응답 포맷 등
│   ├── config                 # JWT, CORS, Swagger 등
│   ├── exception              # 예외 처리
│   ├── response               # 공통 응답 객체
│   └── util                   # 파일 업로드 등 유틸
│
├── domain
│   ├── user                   # 회원 가입, 로그인, 마이페이지
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── dto
│   │   └── entity
│   │
│   ├── freeboard              # 자유게시판
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── dto
│   │   └── entity
│   │
│   ├── resellboard             # 중고거래 게시판
│   │   └── (동일 구조)
│   │
│   ├── noticeboard            # 공지사항 (관리자 전용)
│   │   └── (동일 구조)
│   │
│   ├── photoboard             # 사진자랑 (사진 + 좋아요)
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── dto
│   │   └── entity
│   │
│   ├── comment                # 댓글 (공통 댓글 기능)
│   │   └── (자유게시판/장터/사진 등에 연결)
│   │
│   ├── like                   # 좋아요 (사진자랑용)
│   │   └── (Photoboard와 연결)
│   │
│   ├── message                # 쪽지 기능
│   │   └── ...
│   │
│   └── admin                  # 관리자 전용 (회원관리 등)
│       └── ...
│
└── PetBoardApplication.java
