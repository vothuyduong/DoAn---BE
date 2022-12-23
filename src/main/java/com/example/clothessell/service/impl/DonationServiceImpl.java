package com.example.clothessell.service.impl;

import com.example.clothessell.dto.response.DonationResponse;
import com.example.clothessell.entity.Customer;
import com.example.clothessell.entity.Donation;
import com.example.clothessell.entity.Volunteer;
import com.example.clothessell.repository.ICustomerRepository;
import com.example.clothessell.repository.IDonationRepository;
import com.example.clothessell.repository.IVolunteerRepository;
import com.example.clothessell.service.IDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DonationServiceImpl implements IDonationService {

    @Autowired
    private IDonationRepository donationRepository;

    @Autowired
    private IVolunteerRepository volunteerRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public DonationResponse getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Donation> listDo = donationRepository.findAll(pageable);
        List<Donation> listDonation = listDo.getContent();

        DonationResponse donationResponse = new DonationResponse();
        List<Map<String, Object>> listRespo = new ArrayList<>();
        for(Donation don: listDonation) {
            Volunteer volunteer = volunteerRepository.findById(don.getIdVolunteer());
            Customer customer = customerRepository.findById(don.getIdCustomer());

            Map<String, Object> tam = new HashMap<>();
            tam.put("id", don.getId());
            tam.put("picture", don.getPicture());
            tam.put("quantity", don.getQuantity());
            tam.put("takeTime", don.getTakeTime());
            tam.put("takeAddress", don.getTakeAddress());
            tam.put("status", don.getStatu());
            tam.put("idVolunteer", don.getIdVolunteer());
            tam.put("idCustomer", don.getIdCustomer());
            tam.put("receivingTime", don.getReceivingTime());
            tam.put("nameVolunteer", volunteer.getUsername());
            tam.put("nameCustomer", customer.getCustomerName());

            listRespo.add(tam);
        }

        donationResponse.setListDonations(listRespo);
        donationResponse.setTotalPage(listDo.getTotalPages());
        donationResponse.setTotalItem(listDo.getTotalElements());
        return donationResponse;
    }
}
