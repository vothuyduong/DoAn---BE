package com.example.clothessell.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSizee {
    private int id;
    private int idProduct;
    private String nameProduct;
    private int idSize;
    private String nameSize;
    private double price;
    private int quantity;
}
