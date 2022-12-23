package com.example.clothessell.dto.response;

import com.example.clothessell.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    List<Customer> listCustomer;
    int totalPage;
    long totalItem;
}
