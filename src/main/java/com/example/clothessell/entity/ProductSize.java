package com.example.clothessell.entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_size")
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "size_id")
    @NotEmpty(message = "Size id is not empty!")
    private int sizeId;

    @Column(name = "product_id")
    @NotEmpty(message = "Product id is not empty!")
    private int productId;

    @Column(name = "product_picture")
    @NotEmpty(message = "Product picture is not empty!")
    private String productPicture;

    @Column(name = "product_price")
    @NotEmpty(message = "Product price is not empty!")
    private double productPrice;

    @Column(name = "product_quantity")
    @NotEmpty(message = "Product quantity is not empty!")
    private int productQuantity = 0;
}
