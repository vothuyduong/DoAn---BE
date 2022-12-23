package com.example.clothessell.dto.response;

import com.example.clothessell.entity.Volunteer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerResponse {
    List<Volunteer> volunteers;
    int totalPage;
    long totalItem;
}
