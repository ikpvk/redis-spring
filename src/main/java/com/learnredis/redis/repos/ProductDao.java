package com.learnredis.redis.repos;

import com.learnredis.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    @Autowired
    private RedisTemplate redisTemplate;

    public void save(Product product) {
        redisTemplate.opsForHash().put("Product",product.getId(), product);
        System.out.println("Redis value inserted");
    }

    public List<Product> getAllProducts() {
        return redisTemplate.opsForHash().values("Product");
    }

    public Product findProductById(int id) {
        return (Product) redisTemplate.opsForHash().get("Product", id);
    }

    public void deleteById(int id) {
        redisTemplate.opsForHash().delete("Product", id);
        System.out.println("Redis value deleted");
    }
}
