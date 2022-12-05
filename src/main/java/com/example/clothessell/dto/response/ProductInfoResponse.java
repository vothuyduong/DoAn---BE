package com.example.clothessell.dto.response;

import com.example.clothessell.entity.Picture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoResponse {
    private int id;
    private String categoryName;
    private String name;
    private String describe;
    private int sex;
    private List<String> picture;
    private int quantity;
}
