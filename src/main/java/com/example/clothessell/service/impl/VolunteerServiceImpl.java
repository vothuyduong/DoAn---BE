package com.example.clothessell.service.impl;

import com.example.clothessell.dto.response.VolunteerResponse;
import com.example.clothessell.entity.Volunteer;
import com.example.clothessell.repository.IVolunteerRepository;
import com.example.clothessell.service.IVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class VolunteerServiceImpl implements IVolunteerService {
    @Autowired
    private IVolunteerRepository volunteerRepository;

    @Override
    public VolunteerResponse getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Volunteer> listVolunteer = volunteerRepository.findAll(pageable);

         VolunteerResponse volunteerResponse = new VolunteerResponse();
         volunteerResponse.setVolunteers(listVolunteer.getContent());
         volunteerResponse.setTotalPage(listVolunteer.getTotalPages());
         volunteerResponse.setTotalItem(listVolunteer.getTotalElements());
        return volunteerResponse;
    }
}
