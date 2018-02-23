package com.pipelines.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
// to get all products http://myIPAddress/products
    @RequestMapping(method=RequestMethod.GET, value="/products")
    public List<ProductRecord> product() {
        return productService.getAll();
    }
// to get a product by ID you should use http://myIPAddress/products/id/IDOFAProduct
    @RequestMapping(method=RequestMethod.GET, value="/products/id/{id}")
    public List<ProductRecord> show(@PathVariable String id) {
        return productService.getByID(id);
    }

    // to get all products by name
    @RequestMapping(method=RequestMethod.GET, value="/products/name/{name}")
    public List<ProductRecord> showByName(@PathVariable String name) {
        return productService.getByName(name);
    }
    // get all products by price 
    @RequestMapping(method=RequestMethod.GET, value="/products/price/{price}")
    public List<ProductRecord> showByPrice(@PathVariable Double price) {
        return productService.getByPrice(price);
    }
    
    // to get all products by description 
    @RequestMapping(method=RequestMethod.GET, value="/products/desc/{desc}")
    public List<ProductRecord> showByDesc(@PathVariable String desc) {
        return productService.getByDesc(desc);
    }
    
 // to post product send product detail through http://MyIPAddress/products
    @RequestMapping(method=RequestMethod.POST, value="/products")
    public String save(@RequestBody ProductRecord product) {
    	return productService.save(product);

    }
    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public ProductRecord update(@PathVariable String id, @RequestBody ProductRecord product) {
       return productService.put(id, product);
    	
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
    public String delete(@PathVariable String id) {
        return productService.delete(id);
   
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/products/all")
    public String deleteAll() {
        return productService.deleteAll();
   
    }
    
  
}