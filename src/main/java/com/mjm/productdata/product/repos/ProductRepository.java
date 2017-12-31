package com.mjm.productdata.product.repos;

import com.mjm.productdata.product.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findAllByName(String name);
    List<Product> findAllByNameAndDesc(String name, String desc);
    List<Product> findAllByPriceGreaterThan(Double price);
    List<Product> findAllByDescLike(String desc);
    List<Product> findAllByPriceBetween( Double low,  Double high);
    List<Product> findByIdIn(List<Integer> ids);
}
