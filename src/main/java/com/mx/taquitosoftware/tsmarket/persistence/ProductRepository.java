package com.mx.taquitosoftware.tsmarket.persistence;

import com.mx.taquitosoftware.tsmarket.persistence.crud.ProductCrudRepository;
import com.mx.taquitosoftware.tsmarket.persistence.entity.Product;

import java.util.List;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){
        return (List<Product>) productCrudRepository.findAll();
    }
}
