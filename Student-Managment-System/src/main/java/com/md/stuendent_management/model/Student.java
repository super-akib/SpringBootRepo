package com.md.stuendent_management.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Student_table")
public class Student {

    @Id
    private Long studentId;

    @NonNull
    private String firstName;
    @NonNull
    private String secondName;
    @NonNull
    private String contactNumber;
    @NonNull
    private String fatherName;
    @NonNull
    private String motherName;
    @NonNull
    private String emailId;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address; // Establish One-to-One relationship with Address

    @ManyToMany
    @JoinTable(
        name = "student_course", // Join table name
        joinColumns = @JoinColumn(name = "student_id"), // Foreign key to Student
        inverseJoinColumns = @JoinColumn(name = "course_id") // Foreign key to Course
    )
    private Set<Course> courses; // Many-to-Many relationship with Course
}
