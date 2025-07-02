-- 중복시 무시 (MySQL/MariaDB 전용)
INSERT IGNORE INTO grade (grade_no, grade_name) VALUES (1, '일반회원');
INSERT IGNORE INTO grade (grade_no, grade_name) VALUES (2, '관리자');
