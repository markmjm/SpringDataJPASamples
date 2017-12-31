package com.mjm.productdata.customer.repos;

import com.mjm.productdata.customer.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findAllByEmailAndName(String email, String name);
    List<Customer> findAllByEmailLike(String email, String name);
    List<Customer> findAllByIdIn(List<Integer> ids);
}
