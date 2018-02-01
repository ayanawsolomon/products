package com.pipelines.main;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductRecord {
    @Id
    String id;
    String prodName;
    String prodDesc;
    Double prodPrice;
    String prodImage;
    Set<String> prePipe;
    Set<String> postPipe;

    public ProductRecord() {
    }

    public ProductRecord(String prodName, String prodDesc, Double prodPrice, String prodImage, Set<String> prePipe, Set<String> postPipe) {
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.prodImage = prodImage;
        this.postPipe = prePipe;
        this.postPipe = postPipe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdImage() {
        return prodImage;
    }

    public void setProdImage(String prodImage) {
        this.prodImage = prodImage;
    }
    
    public void setPrePipe(Set<String> prePipe) {
        this.prePipe = prePipe;
    }
    
    public Set<String> getPrePipe() {
        return prePipe;
    }
    
    public void setPostPipe(Set<String> postPipe) {
        this.postPipe = postPipe;
    }
    
    public Set<String> getPostPipe() {
        return postPipe;
    }

}