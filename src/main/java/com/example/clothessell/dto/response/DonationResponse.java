package com.example.clothessell.dto.response;

import com.example.clothessell.entity.Donation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationResponse {
    List<Map<String, Object>> listDonations;
    int totalPage;
    long totalItem;
}
