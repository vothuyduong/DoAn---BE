package com.example.clothessell.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponse {
    List<ProductSizee> productSizes;
    int totalPage;
    long totalItem;
}
