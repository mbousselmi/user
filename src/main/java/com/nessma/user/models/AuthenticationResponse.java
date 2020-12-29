package com.nessma.user.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
	
    private String token;
    private String type = "Bearer";
    private String account;
    private String name;
    private String role;
    
    public AuthenticationResponse(String token, String account, String name, String role) {
        this.account = account;
        this.name = name;
        this.token = token;
        this.role = role;
    }

}
