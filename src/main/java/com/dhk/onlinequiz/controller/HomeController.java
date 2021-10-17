package com.dhk.onlinequiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/student/home")
    public String studentHome(Model model) {
        model.addAttribute("auth", "student");

        return "student/home";
    }

    @GetMapping("/teacher/home")
    public String teacherHome(Model model) {
        model.addAttribute("auth", "teacher");

        return "teacher/home";
    }

    @GetMapping("/admin/home")
    public String adminHome(Model model) {
        model.addAttribute("auth", "admin");

        return "admin/home";
    }
}
