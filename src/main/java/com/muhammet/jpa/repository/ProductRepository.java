package com.muhammet.jpa.repository;

import com.muhammet.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    /**
     *
     * select * from tblproduct where model = ?
     */
    List<Product> findAllByModel(String model);

    /**
     * And, Or
     * select * from tblproduct where model= ? or fiyat=?
     * select * from tblproduct where model=? and stock=?
     */
    List<Product> findAllByModelOrPrice(String model, Double price);
    List<Product> findAllByPriceAndModel(Double price, String model);

    /**
     * GreaterThen
     * select * from tblproduct where stock>10
     * LessThen
     * select * from tblproduct where stock<10
     * GreaterThenEquals
     * select * from tblproduct where stock>=10
     * LessThenEquals
     * select * from tblproduct where stock<=10
     *
     */
    List<Product> findAllByStockLessThan(Integer lowStockCount);

    /**
     *
     * %, _
     * select * from tblproduct where name like ?
     *
     * findAllByNameLike('m%');
     */
    List<Product> findAllByNameLike(String name);

    /**
     * select * from tblproduct where UPPER(name) = UPPER(?)
     */
    List<Product> findAllByNameIgnoreCase(String name);

    /**
     * select * from tblproduct where name like ?+'%'
     * select * from tblproduct where name like '%'+?
     * select * from tblproduct where name like '%'+?+'%'
     */
    List<Product> findAllByNameStartingWith(String name);
    List<Product> findAllByNameEndingWith(String name);
    List<Product> findAllByNameContaining(String name);


}
