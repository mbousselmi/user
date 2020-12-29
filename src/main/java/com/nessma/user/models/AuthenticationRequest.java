package com.nessma.user.models;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * 
 * @author malek Bousselmi 06/11/2020
 *
 */
@Data
public class AuthenticationRequest {

	@NotBlank
	private String username;
	@NotBlank
	private String password;

}
