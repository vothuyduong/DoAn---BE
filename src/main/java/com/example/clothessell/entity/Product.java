package com.example.clothessell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "product_name")
    private String productName = "";

    @Column(name = "product_describe")
    private String productDescribe = "";

    @Column(name = "is_gift")
    private int isGift;

    @Column(name = "product_sex")
    private int productSex;

    @Column(name = "product_picture")
    private String productPicture;

    @Column(name= "product_quantity")
    private int productQuantity = 0;

    @Column(name = "price_min")
    private double priceMin = 0;

    @Column(name = "price_max")
    private double priceMax = 0;

    public Product(int categoryId, String productName, String productDescribe, int isGift, int productSex, String productPicture) {
        this.categoryId = categoryId;
        this.productName = productName;
        this.productDescribe = productDescribe;
        this.isGift = isGift;
        this.productSex = productSex;
        this.productPicture = productPicture;
    }
}
