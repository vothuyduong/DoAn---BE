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
@Table(name = "detail_cart")
public class DetailCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cart_id")
    @NotEmpty(message = "Cart id is not empty!")
    private int cartId;

    @Column(name = "product_id")
    @NotEmpty(message = "Product id is not empty!")
    private int productId;

    @Column(name = "size_id")
    @NotEmpty(message = "Size id is not empty!")
    private int sizeId;

    @Column(name = "product_quantity")
    @NotEmpty(message = "Product quantity is not empty!")
    private int productQuantity = 0;

    @Column(name = "money_into")
    @NotEmpty(message = "Money into is not empty!")
    private double moneyInto = 0;
}
