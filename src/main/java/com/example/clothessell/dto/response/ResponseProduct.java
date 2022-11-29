package com.example.clothessell.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProduct {
    private int id;
    private String categoryName;
    private String productName;
    private String productDescribe;
    private int productSex;
    private String productPicture;
    private int productQuantity;
}
