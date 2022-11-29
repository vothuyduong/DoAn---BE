package com.example.clothessell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    @NotEmpty(message = "Customer name is not empty!")
    private String customerName;

    @Column(name = "customer_email")
    @NotEmpty(message = "Customer email is not empty!")
    @Email(message = "Email not valid!")
    private String customerEmail;

    @Column(name = "customer_phone")
    @NotEmpty(message = "Customer phone is not empty!")
    private String customerPhone;

    @Column(name = "customer_address")
    @NotEmpty(message = "Customer address is not empty!")
    private String customerAddress;

    @Column(name = "money_total")
    @NotEmpty(message = "Money toal is not empty!")
    private double moneyTotal = 0;
}
