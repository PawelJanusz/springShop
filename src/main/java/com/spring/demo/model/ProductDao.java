package com.spring.demo.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ProductDao {

    List<ProductDto> products = new ArrayList<>();

    public void saveProduct(ProductDto productDto){
        products.add(productDto);
    }

    public List<ProductDto> getAllProducts(){
        return StreamSupport.stream(products.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteProduct(ProductDto productDto){
        products.remove(productDto);
    }


}
