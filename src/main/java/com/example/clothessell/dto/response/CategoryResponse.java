package com.example.clothessell.dto.response;

import com.example.clothessell.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    List<Category> categories;
    int totalPage;
    long totalItem;
}
