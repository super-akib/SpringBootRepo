package com.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="bank_info")
public class Bank {   
	
	//generate user define sequence
	@SequenceGenerator(name = "bankSeq" , sequenceName = "my_bank", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bankSeq")
	@Id
	@Column(name="bank_id")
	private Integer bankId;

	@NonNull
	@Column(name = "bank_name")
    private String bankName;

	@NonNull
	@Column(name = "bank_location")
    private String bankLocation;

	@NonNull
	@Column(name = "bank_type")
    private String bankType;

	@NonNull
	@Column(name = "number_of_users")
    private Long numberOfUsers;

	@NonNull
	@Column(name = "number_of_branches")
    private Integer numberOfBranches;

	@OneToMany(mappedBy = "bank")
	private List<Employee> employeeList;

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bankLocation=" + bankLocation + ", bankType="
				+ bankType + ", numberOfUsers=" + numberOfUsers + ", numberOfBranches=" + numberOfBranches + "]";
	}
}
