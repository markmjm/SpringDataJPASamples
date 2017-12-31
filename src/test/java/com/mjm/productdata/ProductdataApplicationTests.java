package com.mjm.productdata;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.mjm.productdata.product.entities.Product;
import com.mjm.productdata.product.repos.ProductRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;



	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate(){
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome Iphone");
		product.setPrice(1000d);
		repository.save(product);

		product.setId(2);
		product.setName("TV");
		product.setDesc("From SamDung");
		product.setPrice(400d);
		repository.save(product);

		product.setId(3);
		product.setName("Washer");
		product.setDesc("From GE");
		product.setPrice(800d);
		repository.save(product);

		product.setId(4);
		product.setName("Dryer");
		product.setDesc("From GE");
		product.setPrice(600d);
		repository.save(product);
	}

	@Test
	public void testRead(){
		Product product = repository.findOne(1);
		assertNotNull(product);
		assertEquals( "Iphone", product.getName());
	}


	@Test
	public void testUpdate(){
		Product product = repository.findOne(1);
		product.setPrice(1200d);
		repository.save(product);
		product = repository.findOne(1);
		assertNotNull(product);
		assertEquals( "1200.0", product.getPrice().toString());
	}

	@Test
	public void testDelete(){
		if(repository.exists(1)) {
			repository.delete(1);
		}
		assertEquals(0, repository.count());
	}

	@Test
	public void testCount(){
		Long count= repository.count();
	}

	@Test
	public void testExists(){
		Boolean doesExist = repository.exists(1);
	}
}
