package com.pipelines.main;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<ProductRecord, String> {
   // List<ProductRecord> findOne(String id);

    @Override
    void delete(ProductRecord deleted);
   // ProductRecord findByprodName(String name);

	List<ProductRecord> findByProdNameLike(String name);
	List<ProductRecord> findByIdLike(String id);
	List<ProductRecord> findByProdPriceLike(Double price);
	List<ProductRecord> findByProdDescLike(String desc);
	


}