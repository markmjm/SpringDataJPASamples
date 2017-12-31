package com.mjm.productdata.product.repos;

import com.mjm.productdata.product.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepositoryPageable extends PagingAndSortingRepository<Product, Integer> {
    Page findAllByName(String name, Pageable pageable);
    Page findAllByNameAndDesc(String name, String desc, Pageable pageable);
    Page findAllByPriceGreaterThan(Double price, Pageable pageable);
    Page findAllByDescLike(String desc, Pageable pageable);
    Page findAllByPriceBetween(Double low, Double high, Pageable pageable);
    Page findByIdIn(List<Integer> ids, Pageable pageable);
}
