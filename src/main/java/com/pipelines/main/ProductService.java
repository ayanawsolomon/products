package com.pipelines.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service 
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<ProductRecord> getAll() {
		List<ProductRecord> productRecords = new ArrayList<>();
		productRepository.findAll().forEach(productRecords::add);
		return productRecords;		
	}
	
	public List<ProductRecord> getByID(String id) {
		return productRepository.findByIdLike(id);
	}
	
	public List<ProductRecord> getByName(String name) {
		return productRepository.findByProdNameLike(name);
	}
	
	public List<ProductRecord> getByPrice(Double price) {
		return productRepository.findByProdPriceLike(price);
	}
	
	public List<ProductRecord> getByDesc(String desc) {
		return productRepository.findByProdDescLike(desc);
	}
	
	public String deleteAll() {
		long total =productRepository.count();
		productRepository.deleteAll();
		return total + " products has been deleted. Now database is empty";
	}
	public String delete(String id) {
		productRepository.delete(id);
		return "product " + id + " has deleted";
	}
	public String save(ProductRecord product) {
		productRepository.save(product);
		return product.getId() + " has saved successfully";
	}
	

	public ProductRecord put(String id, ProductRecord product) {

    	ProductRecord prod = productRepository.findOne(id);
        if(product.getProdName() != null)
            prod.setProdName(product.getProdName());
        if(product.getProdDesc() != null)
            prod.setProdDesc(product.getProdDesc());
        if(product.getProdPrice() != null)
            prod.setProdPrice(product.getProdPrice());
        if(product.getProdImage() != null)
            prod.setProdImage(product.getProdImage());
        productRepository.save(prod);
        return prod;
	}
	

}
