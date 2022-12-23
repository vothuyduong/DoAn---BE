package com.example.clothessell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private String customerPhone = "";

    @Column(name = "customer_address")
    private String customerAddress = "";

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_username")
    private String customerUsername;

    @Column(name = "customer_password")
    private String customerPassword;

    @Column(columnDefinition = "integer default 0")
    private int customerPoint;

    @Column(name = "customer_avatar")
    private String customerAvatar = "";

    @Column(name = "customer_role")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<Role>();

    public Customer(String name, String username, String email, String encode) {
        this.customerName = name;
        this.customerUsername = username;
        this.customerEmail = email;
        this.customerPassword = encode;
    }
}
