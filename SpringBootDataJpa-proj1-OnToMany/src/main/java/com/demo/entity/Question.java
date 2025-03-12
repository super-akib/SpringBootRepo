package com.demo.entity;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "JPA_OTM_Question")
public class Question {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "Questions_list")
    private String questions;

    @NonNull
    @Column(name = "Answer_list")
    private String answer;

    @ElementCollection
    @CollectionTable(name = "JPA_OTM_Answer", joinColumns = @JoinColumn(name="qustion_id" ,referencedColumnName = "id"))
    private Set<String> answerList;

    @Override
    public String toString() {
        return "Question [id=" + id + ", questions=" + questions + ", answer=" + answer + "]";
    } 
}
