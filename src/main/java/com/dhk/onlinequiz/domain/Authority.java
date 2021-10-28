package com.dhk.onlinequiz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@IdClass(Authority.class) // 동일한 권한이 부여되지 않도록 슈퍼키로 구성
public class Authority implements GrantedAuthority {

    private final String ROLE_GUEST = "ROLE_GUEST";
    private final String ROLE_STUDENT = "ROLE_STUDENT";
    private final String ROLE_TEACHER = "ROLE_TEACHER";
    private final String ROLE_ADMIN = "ROLE_ADMIN";

    @Id
    private Long userId;

    @Id
    private String authority = ROLE_GUEST;
}
