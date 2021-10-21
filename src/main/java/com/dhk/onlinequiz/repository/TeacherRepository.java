package com.dhk.onlinequiz.repository;

import com.dhk.onlinequiz.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
