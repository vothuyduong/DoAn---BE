package com.example.clothessell.security.userprincipal;

import com.example.clothessell.entity.Customer;
import com.example.clothessell.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private ICustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = repository.findByCustomerUsername(username);
        if(customer == null) {
            throw new UsernameNotFoundException("User name not exist!");
        }
        return UserPrinciple.build(customer);
    }
}
