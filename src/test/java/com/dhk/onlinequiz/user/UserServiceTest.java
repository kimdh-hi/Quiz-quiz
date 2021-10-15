package com.dhk.onlinequiz.user;

import com.dhk.onlinequiz.domain.User;
import com.dhk.onlinequiz.repository.UserRepository;
import com.dhk.onlinequiz.request.SignupRequest;
import com.dhk.onlinequiz.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void before() {
        userRepository.deleteAll();
        userService = new UserService(userRepository);
    }

    @DisplayName("1. 회원가입 테스트")
    @Test
    void test1() {
        SignupRequest request = new SignupRequest("test.gmail.com", "김대현", "test1234", "test", 6);

        User signup = userService.signup(request);
        List<User> list = userRepository.findAll();

        assertEquals(1, list.size());
        assertEquals("test.gmail.com", list.get(0).getEmail());
    }
}
