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
    private int cartId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "size_id")
    private int sizeId;

    @Column(name = "product_quantity")
    private int productQuantity = 0;

    @Column(name = "product_price")
    private double productPrice = 0;

    @Column(name = "money_into")
    private double moneyInto = 0;
}
