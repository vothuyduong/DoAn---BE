package com.example.clothessell.security.userprincipal;

import com.example.clothessell.entity.Customer;
import com.example.clothessell.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPrinciple implements UserDetails {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private int point;
    private String avatar;
    private String username;
    private String password;
    private List<? extends GrantedAuthority> roles;

    public static UserPrinciple build(Customer customer) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = customer.getRoles();

        for(Role r: roles) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(r.getRoleName());
            authorities.add(simpleGrantedAuthority);
        }
        return new UserPrinciple(
                customer.getId(),
                customer.getCustomerName(),
                customer.getCustomerPhone(),
                customer.getCustomerAddress(),
                customer.getCustomerEmail(),
                customer.getCustomerPoint(),
                customer.getCustomerAvatar(),
                customer.getCustomerUsername(),
                customer.getCustomerPassword(),
                authorities
        );
    }

    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
