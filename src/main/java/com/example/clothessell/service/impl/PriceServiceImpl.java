package com.example.clothessell.service.impl;

import com.example.clothessell.dto.response.PriceResponse;
import com.example.clothessell.dto.response.ProductSizee;
import com.example.clothessell.entity.ProductSize;
import com.example.clothessell.repository.IPriceRepository;
import com.example.clothessell.repository.IProductRepository;
import com.example.clothessell.repository.ISizeRepository;
import com.example.clothessell.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PriceServiceImpl implements IPriceService {
    @Autowired
    private IPriceRepository priceRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ISizeRepository sizeRepository;

    @Override
    public PriceResponse getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<ProductSize> listProductSize = priceRepository.findAll(pageable);

        List<ProductSize> listProduct = listProductSize.getContent();
        int totalPage = listProductSize.getTotalPages();
        long totalItem = listProductSize.getTotalElements();

        List<ProductSizee> listProductRespon = new ArrayList<>();
        for(ProductSize p: listProduct) {
            String nameProduct = productRepository.findById(p.getProductId()).getProductName();
            String nameSize = sizeRepository.findById(p.getSizeId()).getSizeName();

            ProductSizee pe = new ProductSizee();
            pe.setId(p.getId());
            pe.setIdProduct(p.getProductId());
            pe.setNameProduct(nameProduct);
            pe.setIdSize(p.getSizeId());
            pe.setNameSize(nameSize);
            pe.setPrice(p.getProductPrice());
            pe.setQuantity(p.getProductQuantity());

            listProductRespon.add(pe);
        }

        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setProductSizes(listProductRespon);
        priceResponse.setTotalPage(totalPage);
        priceResponse.setTotalItem(totalItem);
        return priceResponse;
    }


}
