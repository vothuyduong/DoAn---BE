package com.example.clothessell.repository;

import com.example.clothessell.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerUsername(String username);

    Boolean existsByCustomerUsername(String username);

    Boolean existsByCustomerEmail(String email);

    Customer findById(int id);

    Customer save(Customer customer);
}
