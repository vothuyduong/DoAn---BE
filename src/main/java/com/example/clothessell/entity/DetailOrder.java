package com.example.clothessell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detail_order")
public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_id")
    @NotEmpty(message = "Order id is not empty!")
    private int orderId;

    @Column(name = "product_name")
    @NotEmpty(message = "Product name is not empty!")
    private String productName;

    @Column(name = "product_size")
    @NotEmpty(message = "Product size is not empty!")
    private String productSize;

    @Column(name = "product_quantity")
    @NotEmpty(message = "Product quantity is not empty!")
    private int productQuantity = 0;
}
