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
@Table(name = "course_record_info")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer courseId;
	@NonNull
	@Column(name = "course_name")
	private String courseName;
	@NonNull
	@Column(name = "Abbrivation")
	private String abbrivation;
	@NonNull
	@Column(name = "Fees")
	private Double coruseFee;
	@NonNull
	@Column(name = "modules")
	private Integer modules;
	@NonNull
	@Column(name = "title")
	private String courseTitle;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="forigne_key_student_course", joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
	private Set<Student> students;

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", abbrivation=" + abbrivation
				+ ", coruseFee=" + coruseFee + ", modules=" + modules + ", courseTitle=" + courseTitle + "]";
	}

}
