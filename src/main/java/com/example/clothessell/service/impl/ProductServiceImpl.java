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
import org.springframework.data.domain.Sort;
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
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
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
            pr.setGift(p.getIsGift());
            pr.setQuantity(p.getProductQuantity());

            List<Picture> listPicture = pictureRepository.findByProductId(p.getId());
            for(Picture picture: listPicture) {
                String rs = getFileLocal(picture.getUri());
                picture.setBase64(rs);
            }
            pr.setPicture(listPicture);

            listProductRespon.add(pr);
        }

        ProductResponse productResponse = new ProductResponse();
        productResponse.setProducts(listProductRespon);
        productResponse.setTotalItems(totalItems);
        productResponse.setTotalPages(totalPages);

        return productResponse;
    }

    @Override
    public ProductInfoResponse getProductById(int id) {
        Product product = productRepository.findById(id);
        ProductInfoResponse proInfor = new ProductInfoResponse();

        proInfor.setId(id);
        proInfor.setCategoryId(product.getCategoryId());
        proInfor.setCategoryName(product.getCategoryName());
        proInfor.setName(product.getProductName());
        proInfor.setDescribe(product.getProductDescribe());
        proInfor.setSex(product.getProductSex());
        proInfor.setGift(product.getIsGift());
        proInfor.setQuantity(proInfor.getQuantity());

        List<Picture> pictures = pictureRepository.findByProductId(id);

        for(Picture p: pictures) {
            String img = getFileLocal(p.getUri());
            p.setBase64(img);
        }
        proInfor.setPicture(pictures);
        return proInfor;
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
        List<String> pictureBase64 = productForm.getPictureBase64();
        List<String> pictureName = productForm.getPictureName();

        int sizeArrBase64 = pictureBase64.size();
        int sizeArrName = pictureName.size();
        if(sizeArrName != sizeArrBase64) {
            return null;
        }

        for(int i = 0; i < sizeArrName; i++) {
            String uri = uploadFileLocal(pictureBase64.get(i), pictureName.get(i));
            Picture picture = new Picture();
            picture.setName(pictureName.get(i));
            picture.setUri(uri);
            picture.setProductId(productId);
            pictureRepository.save(picture);
        }

        return productRespon;
    }

    @Override
    public Product updateProduct(ProductInfoResponse productInfoResponse) {
        Product product = productRepository.findById(productInfoResponse.getId());
        product.setProductName(productInfoResponse.getName());
        product.setProductDescribe(productInfoResponse.getDescribe());
        product.setCategoryId(productInfoResponse.getCategoryId());
        product.setCategoryName(categoryRepository.findById(productInfoResponse.getCategoryId()).getCategoryName());
        product.setProductSex(productInfoResponse.getSex());
        product.setIsGift(productInfoResponse.getGift());
        productRepository.save(product);

        List<Picture> pictures = productInfoResponse.getPicture();
        for(Picture pic: pictures) {
            if(pic.getUri() == "") {
                pic.setUri(uploadFileLocal(pic.getBase64(), pic.getName()));
                pic.setBase64("");
                pictureRepository.save(pic);
            }
        }
        return product;
    }

    private String uploadFileLocal(String fileBase64, String name) {
        File theDir = new File("/tmp");
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        String filePath = "tmp/" + StringUtil.converDateToString(new Date(), "yyyyMMddhhmmss") + "_" + name;
        File file = FileUtil.convertBase64ToFile(filePath, fileBase64);
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
