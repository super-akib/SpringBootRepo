package com.md.stuendent_management.dto;

import java.util.Set;

import com.md.stuendent_management.model.Address;
import com.md.stuendent_management.model.Course;
import com.md.stuendent_management.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailsDTO {
    private Student student;
    private Address address;
    private Set<Course> courses;
}
