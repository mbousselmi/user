package com.nessma.user.dto;

import lombok.Data;

@Data
public class UserDto {
	
	
    private String email;

    private String password;

    private String username;

    private String phone;

    private String address;
    
    private String role ="CUSTOMER";

}
