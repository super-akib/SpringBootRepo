package com.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "user_login_paging")
public class UserData 
{   
	
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Id
	@Column(name = "User_id")
    private Integer userId;
	@NonNull
	@Column(name = "first_name",length = 80)
    private String firstName;
	@NonNull
	@Column(name = "last_name",length = 80)
	private String lastName;
	@NonNull
	@Column(name = "email_id")
	private String emailId;
	@NonNull
	@Column(name = "country_name",length = 70)
	private String countryName;
}
