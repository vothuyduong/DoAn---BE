package com.example.clothessell.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {
    private String name;
    private String describe;
    private int categoryId;
    private int sex;
    private int gift;
    private String picture;
}
