package com.dhk.onlinequiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    private String name;

    private String email;

    private String password;

    private int grade;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name="user_id"))
    private Set<Authority> authorities;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    private boolean enabled;

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
