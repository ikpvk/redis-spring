package com.learnredis.redis;

import com.learnredis.redis.entity.Product;
import com.learnredis.redis.repos.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/prod")
public class RedisApplication {

	@Autowired
	private ProductDao productDao;

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@PostMapping
	public void save(@RequestBody Product product) {
		productDao.save(product);
	}

	@GetMapping
	public List<Product> getAllProds() {
		return  productDao.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProdById(@PathVariable int id) {
		return productDao.findProductById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		productDao.deleteById(id);
	}

}
