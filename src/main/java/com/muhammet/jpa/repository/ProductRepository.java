package com.muhammet.jpa.repository;

import com.muhammet.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByModel(String model);
}
