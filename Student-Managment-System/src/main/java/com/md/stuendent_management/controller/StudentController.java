package com.md.stuendent_management.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.md.stuendent_management.dto.StudentDetailsDTO;
import com.md.stuendent_management.service.IStudentService;

@RestController
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}/details")
    public StudentDetailsDTO getStudentDetails(@PathVariable Long id) {
        return studentService.getStudentDetails(id);
    }

    @GetMapping("/students/details")
    public Page<StudentDetailsDTO> getAllStudentDetails(Pageable pageable) {
        return studentService.getAllStudentDetails(pageable);
    }
}
