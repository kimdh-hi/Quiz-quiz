package com.dhk.onlinequiz.controller;

import com.dhk.onlinequiz.utils.SchoolInfoApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final SchoolInfoApi schoolInfoApi;

    @GetMapping("/test/api")
    public String test() {
        return schoolInfoApi.getAllSchoolInfo("100260", "elem_list");
    }
}
