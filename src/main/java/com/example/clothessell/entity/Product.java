package com.example.clothessell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName = "";

    @Column(name = "product_name")
    private String productName = "";

    @Column(name = "product_describe")
    private String productDescribe = "";

    @Column(name = "is_gift")
    private int isGift;

    @Column(name = "product_sex")
    private int productSex;

    @Column(name= "product_quantity")
    private int productQuantity = 0;

    @Column(name = "price_min")
    private double priceMin = 0;

    @Column(name = "price_max")
    private double priceMax = 0;

    public Product(int categoryId, String productName, String productDescribe, int isGift, int productSex) {
        this.categoryId = categoryId;
        this.productName = productName;
        this.productDescribe = productDescribe;
        this.isGift = isGift;
        this.productSex = productSex;
    }

    public Product(int id, int categoryId, String categoryName, String productName, String productDescribe, int productSex) {
        this.id = id;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productName = productName;
        this.productDescribe = productDescribe;
        this.productSex = productSex;
    }
}
