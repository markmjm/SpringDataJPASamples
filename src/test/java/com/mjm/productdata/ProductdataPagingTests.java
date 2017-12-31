package com.mjm.productdata;


import com.mjm.productdata.product.entities.Product;
import com.mjm.productdata.product.repos.ProductRepositoryPageable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataPagingTests {

	@Autowired
	ProductRepositoryPageable repository;

	Pageable pageable2 = new PageRequest(1,1);

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindAll(){
		Pageable pageable = new PageRequest(1,2);
		Page<Product> products = repository.findAll(pageable);
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllSorting(){
		Iterable<Product> products = repository.findAll(new Sort("name"));
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllSorting2(){
		Iterable<Product> products = repository.findAll(new Sort(Sort.Direction.DESC, "name"));
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllMultiSorting(){
		Iterable<Product> products = repository.findAll(new Sort(Sort.Direction.DESC, "name", "desc"));
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllMultiSorting2(){
		Iterable<Product> products = repository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "name"), new Sort.Order(Sort.Direction.ASC,"price")));
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllPagingAndSorting(){
		Pageable pageable = new PageRequest(0, 2, Sort.Direction.DESC, "name");
		Iterable<Product> products = repository.findAll(pageable);
		products.forEach(p-> System.out.println(p.getName()));
	}

	@Test
	public void testFindByName(){
		Pageable pageable = new PageRequest(1,1);
		Page<Product> products = repository.findAllByName("Iphone", pageable);
		products.forEach(p-> System.out.println(p.getName()));
	}


	@Test
	public void testFindAllByNameAAndDesc(){

		Page<Product> products = repository.findAllByNameAndDesc("Iphone", "Awesome Iphone", pageable2);
		products.forEach(p-> System.out.println(p));
	}


	@Test
	public void testFindAllByPriceGreaterThan(){
		Page<Product> products = repository.findAllByPriceGreaterThan(1000d, pageable2);
		products.forEach(p-> System.out.println(p));
	}

	@Test
	public void testFindAllByDescLike(){
		Page<Product> products = repository.findAllByDescLike("Awesome", pageable2);
		products.forEach(p-> System.out.println(p));
	}

	@Test
	public void testFindAllByPriceBetween(){
		Page<Product> products = repository.findAllByPriceBetween(100d, 900d, pageable2);
		products.forEach(p-> System.out.println(p));
	}
	@Test
	public void testFindByIdIn(){
		Page<Product> products = repository.findByIdIn(Arrays.asList(1,2), pageable2);
		products.forEach(p-> System.out.println(p));
	}
}
