package com.dhk.onlinequiz.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private String email;
    private String name;
    private String password;
    private String schoolName;
    private int grade;

    private boolean teacher;
}
