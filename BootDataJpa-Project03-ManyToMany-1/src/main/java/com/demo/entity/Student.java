package com.demo.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "Student_record_info")
public class Student 
{
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   @Column(name = "student_id")
   private Integer studentId;
   @NonNull
   @Column(name = "student_name")
   private String studentName;
   @NonNull
   @Column(name = "student_age")
   private Integer studentAge;
   @NonNull
   @Column(name = "student_grade")
   private Character  studentGrade;
   
   @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinTable(name = "forigne_key_student_course", joinColumns = @JoinColumn(name ="student_id",referencedColumnName = ""),
   inverseJoinColumns = @JoinColumn(name="course_id") )
   private Set<Course> courses;
@Override
public String toString() {
	return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
			+ ", studentGrade=" + studentGrade + "]";
}
   
   
   
}
