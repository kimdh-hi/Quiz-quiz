package com.dhk.onlinequiz.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class AdminController {


    @GetMapping("/admin/teachers")
    public String getTeacherList(Model model) {


        return "admin/teacherList";
    }
}
