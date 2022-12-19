package com.example.clothessell.dto.response;

import com.example.clothessell.entity.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SizeResponse {
    List<Size> sizes;
    long size;
    int page;
}
