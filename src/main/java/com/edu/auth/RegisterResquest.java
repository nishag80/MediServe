package com.edu.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResquest {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;

}
