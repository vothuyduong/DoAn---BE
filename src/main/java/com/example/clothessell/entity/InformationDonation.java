package com.example.clothessell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "information_donation")
public class InformationDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_picture")
    @NotEmpty(message = "Product picture is not empty!")
    private String productPicture;

    @Column(name = "product_quantity")
    @NotEmpty(message = "Product quantity is not empty!")
    private int productQuantity = 0;

    @Column(name = "time_take")
    @NotEmpty(message = "Time take is not empty!")
    private Timestamp timeTake;

    @Column(name = "address_take")
    @NotEmpty(message = "Address take is not empty!")
    private String addressTake;

    @Column(name = "customer_id")
    @NotEmpty(message = "Customer id is not empty!")
    private String customerId;

    @Column(name = "status")
    @NotEmpty(message = "Status is not empty!")
    private int status = 0;
}
