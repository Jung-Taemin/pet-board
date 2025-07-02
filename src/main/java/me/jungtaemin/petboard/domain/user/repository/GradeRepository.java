package me.jungtaemin.petboard.domain.user.repository;

import me.jungtaemin.petboard.domain.user.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
