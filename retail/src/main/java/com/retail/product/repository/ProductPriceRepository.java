package com.retail.product.repository;

import com.retail.product.vo.ProductPriceVo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends MongoRepository<ProductPriceVo, Integer> {
}
