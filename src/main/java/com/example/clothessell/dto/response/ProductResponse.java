package com.example.clothessell.dto.response;

import com.example.clothessell.entity.Picture;
import com.example.clothessell.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private List<ProductInfoResponse> products;
    private int totalPages;
    private long totalItems;
}
