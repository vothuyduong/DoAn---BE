package com.example.clothessell.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    String token;

    String tokenRefresh;
    private String username;
    private String email;

    private List<? extends GrantedAuthority> roles;

    public JwtResponse(String username, String email, List<? extends GrantedAuthority> roles) {
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
