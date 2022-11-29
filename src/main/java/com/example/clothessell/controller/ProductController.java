package com.example.clothessell.controller;

import com.example.clothessell.dto.request.ProductForm;
import com.example.clothessell.dto.response.ResponseProduct;
import com.example.clothessell.entity.Product;
import com.example.clothessell.service.impl.CategoryServiceImpl;
import com.example.clothessell.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/api/products/all")
    public ResponseEntity<?> getProduct() {
        List<Product> listAll = productService.getAll();
        List<ResponseProduct> listRes = new ArrayList<>();
        for(Product p : listAll) {
            String cate = categoryService.findById(p.getCategoryId()).getCategoryName();
            ResponseProduct pRes = new ResponseProduct(p.getId(), cate, p.getProductName(), p.getProductDescribe(), p.getProductSex(), p.getProductPicture(), p.getProductQuantity());
            listRes.add(pRes);
        }
        return ResponseEntity.ok(listRes);
    }

    @PostMapping("/api/products/add")
    public ResponseEntity<?> saveProduct(@RequestBody ProductForm product) throws IOException {
        //convert string base64 to arr byte
        String[] strings = product.getPicture().split(",");
        String extension;

        switch (strings[0]) {
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default:
                extension = "jpg";
                break;
        }

        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);

        //save image folder static/images
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }

        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(product.getName() + "." + extension);
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String linkPicture = imagePath.resolve(product.getName()).toString() + "." + extension;

        Product newProduct = new Product(product.getCategoryId(), product.getName(),
                product.getDescribe(), product.getGift(), product.getSex(), linkPicture);

        return ResponseEntity.ok(productService.save(newProduct));
    }

    public ResponseEntity<?> getFile() {

    }

}
