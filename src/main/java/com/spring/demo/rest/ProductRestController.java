package com.spring.demo.rest;

import com.spring.demo.model.ProductDao;
import com.spring.demo.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    ProductDao productDao;

    @GetMapping("/products")
    public List<ProductDto> showAllProducts(){
        return productDao.getAllProducts();
    }

    @PostMapping("/addproduct")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        productDao.saveProduct(productDto);
        productDto.setProductDate(new Date());
        return productDto;
    }
}
