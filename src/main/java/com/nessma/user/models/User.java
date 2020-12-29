package com.nessma.user.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author malek Bousselmi 03/11/2020
 *
 */
@Entity
@Data
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size(min = 6, message = "Length must be more than 6")
	private String password;
	@NotEmpty
	private String username;
	@NotEmpty
	private String phone;
	@NotEmpty
	private String address;
	@NotEmpty
	private String role = "CUSTOMER";

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

}
