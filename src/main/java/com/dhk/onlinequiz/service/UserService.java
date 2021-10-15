package com.dhk.onlinequiz.service;

import com.dhk.onlinequiz.domain.User;
import com.dhk.onlinequiz.repository.UserRepository;
import com.dhk.onlinequiz.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public User signup(SignupRequest signupRequest) {
        User user = User.builder()
                .name(signupRequest.getName())
                .email(signupRequest.getEmail())
                .password(signupRequest.getPassword())
                .enabled(true)
                .build();

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> {
                    throw new IllegalArgumentException("존재하지 않는 이메일입니다.");
                }
        );

        return user;
    }
}
