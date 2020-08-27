package com.spring.demo.controller;

import com.spring.demo.model.ProductDao;
import com.spring.demo.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductDao productDao;

    @GetMapping("/addproduct")
    public ModelAndView addProduct(Model model){
        return new ModelAndView("productForm", "productToInsert", new ProductDto());
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute ProductDto productDto){
        productDao.saveProduct(productDto);
        productDto.setProductDate(new Date());
        return "productsaveresult";
    }
    @GetMapping("/productList")
    public String showProducts(Model model){
        List<ProductDto> products = productDao.getAllProducts();
        model.addAttribute("allProducts", products);
        return "productList";
    }
    @PostMapping("/deleteproduct")
    public String deleteProduct(@ModelAttribute("product") ProductDto productDto){
        productDao.deleteProduct(productDto);
        return "productdeleteresult";
    }

}
