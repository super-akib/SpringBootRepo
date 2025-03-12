package com.md.stuendent_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.md.stuendent_management.dto.StudentDetailsDTO;
import com.md.stuendent_management.model.Student;
import com.md.stuendent_management.repository.IStudentRepository;


@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDetailsDTO getStudentDetails(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        return new StudentDetailsDTO(student, student.getAddress(), student.getCourses());
    }

    @Override
    public Page<StudentDetailsDTO> getAllStudentDetails(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(student -> new StudentDetailsDTO(student, student.getAddress(), student.getCourses()));
    }
}
