package com.example.clothessell.service.impl;

import com.example.clothessell.dto.request.ProductForm;
import com.example.clothessell.dto.response.ProductInfoResponse;
import com.example.clothessell.dto.response.ProductResponse;
import com.example.clothessell.entity.Category;
import com.example.clothessell.entity.Picture;
import com.example.clothessell.entity.Product;
import com.example.clothessell.repository.ICategoryRepository;
import com.example.clothessell.repository.IPictureRepository;
import com.example.clothessell.repository.IProductRepository;
import com.example.clothessell.service.IProductService;
import com.example.clothessell.util.FileUtil;
import com.example.clothessell.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IPictureRepository pictureRepository;

    @Override
    public ProductResponse getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> pageItem = productRepository.findAll(pageable);

        long totalItems = pageItem.getTotalElements();
        int totalPages = pageItem.getTotalPages();

        List<Product> listProduct = pageItem.getContent();
        List<ProductInfoResponse> listProductRespon = new ArrayList<>();
        for(Product p: listProduct) {
            ProductInfoResponse pr = new ProductInfoResponse();
            pr.setId(p.getId());
            pr.setCategoryName(p.getCategoryName());
            pr.setName(p.getProductName());
            pr.setDescribe(p.getProductDescribe());
            pr.setSex(p.getProductSex());
            pr.setQuantity(p.getProductQuantity());

            List<Picture> listPicture = pictureRepository.findByProductId(p.getId());
            List<String> listPictureRespon = new ArrayList<>();
            for(Picture picture: listPicture) {
                String rs = getFileLocal(picture.getUri());
                listPictureRespon.add(rs);
            }
            pr.setPicture(listPictureRespon);

            listProductRespon.add(pr);
        }

        ProductResponse productResponse = new ProductResponse();
        productResponse.setProducts(listProductRespon);
        productResponse.setTotalItems(totalItems);
        productResponse.setTotalPages(totalPages);

        return productResponse;
    }

    @Override
    public Product saveProduct(ProductForm productForm) {
        Category cat = categoryRepository.findById(productForm.getCategoryId());

        Product product = new Product();
        product.setProductName(productForm.getName());
        product.setProductDescribe(productForm.getDescribe());
        product.setCategoryId(productForm.getCategoryId());
        product.setCategoryName(cat.getCategoryName());
        product.setProductSex(productForm.getSex());
        product.setIsGift(productForm.getGift());
        Product productRespon = productRepository.save(product);

        int productId = productRepository.findFirstByOrderByIdDesc().getId();

        String pictureBase64 = productForm.getPictureBase64();
        String pictureName = productForm.getPictureName();
        String picutreUri = uploadFileLocal(pictureBase64, pictureName);

        Picture picture = new Picture(pictureName, picutreUri, productId);
        pictureRepository.save(picture);

        return productRespon;
    }

    private String uploadFileLocal(String fileBase64, String name) {
        File theDir = new File("/tmp");
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        String filePath = "tmp/" + StringUtil.converDateToString(new Date(), "yyyyMMddhhmmss") + name;
        File file = FileUtil.convertBase64ToFile(filePath, fileBase64);
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return filePath;
    }

    private String getFileLocal(String path) {
        File file = new File(path);
        try {
            return FileUtil.convertFileToBase64(file);
        } catch (Exception e) {
            System.out.print(e);
        }
        return "";
    }

}
