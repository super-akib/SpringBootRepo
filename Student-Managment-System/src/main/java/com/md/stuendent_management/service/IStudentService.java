package com.md.stuendent_management.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.md.stuendent_management.dto.StudentDetailsDTO;

public interface IStudentService {
    StudentDetailsDTO getStudentDetails(Long studentId);
    Page<StudentDetailsDTO> getAllStudentDetails(Pageable pageable);
}
