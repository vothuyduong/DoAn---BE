package com.example.clothessell.repository;

import com.example.clothessell.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);

    Customer findByCustomerUsername(String username);

    Customer findById(int id);

    Boolean existsByCustomerUsername(String username);

    Boolean existsByCustomerEmail(String email);

    Customer save(Customer customer);

}
