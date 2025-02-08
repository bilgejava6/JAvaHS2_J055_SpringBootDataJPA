package com.muhammet.jpa.controller;

import com.muhammet.jpa.entity.Product;
import com.muhammet.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.muhammet.jpa.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
@CrossOrigin("*")
public class ProductController {
    private final ProductService productService;

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }
    @PostMapping(ADD_PRODUCT)
    public ResponseEntity<Void> addProduct(String name,String model,Double price) {
        productService.addProduct(name,model,price);
        return ResponseEntity.ok().build();
    }
    @GetMapping(GET_ALL_BY_MODEL)
    public ResponseEntity<List<Product>> getAllProductsByModel(String model){
        return ResponseEntity.ok(productService.getAllByModel(model));
    }


}
