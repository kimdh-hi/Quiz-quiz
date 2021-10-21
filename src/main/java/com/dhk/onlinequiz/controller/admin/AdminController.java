package com.dhk.onlinequiz.controller.admin;

import com.dhk.onlinequiz.domain.Teacher;
import com.dhk.onlinequiz.repository.TeacherRepository;
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

    private final TeacherRepository teacherRepository;

    @GetMapping("/admin/teachers")
    public String getTeacherList(Model model) {
        List<Teacher> teacherList = teacherRepository.findAll();
        model.addAttribute("teacherList", teacherList);

        return "admin/teacherList";
    }
}
