package com.mjm.productdata;


import com.mjm.productdata.product.entities.Product;
import com.mjm.productdata.product.repos.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationProductTests {

	@Autowired
	ProductRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindByName(){
		List<Product> products = repository.findAllByName("Iphone");
		products.forEach(p-> System.out.println(p));
	}

	@Test
	public void testFindAllByNameAAndDesc(){
		List<Product> products = repository.findAllByNameAndDesc("Iphone", "Awesome Iphone");
		products.forEach(p-> System.out.println(p));
	}


	@Test
	public void testFindAllByPriceGreaterThan(){
		List<Product> products = repository.findAllByPriceGreaterThan(1000d);
		products.forEach(p-> System.out.println(p));
	}

	@Test
	public void testFindAllByDescLike(){
		List<Product> products = repository.findAllByDescLike("Awesome");
		products.forEach(p-> System.out.println(p));
	}

	@Test
	public void testFindAllByPriceBetween(){
		List<Product> products = repository.findAllByPriceBetween(100d, 900d);
		products.forEach(p-> System.out.println(p));
	}
	@Test
	public void testFindByIdIn(){
		List<Product> products = repository.findByIdIn(Arrays.asList(1,2));
		products.forEach(p-> System.out.println(p));
	}
}
