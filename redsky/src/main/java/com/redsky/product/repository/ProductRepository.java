package com.redsky.product.repository;

import com.redsky.product.vo.ProductVo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductVo, Integer> {
}
