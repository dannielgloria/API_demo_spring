package com.mx.taquitosoftware.tsmarket.persistence.crud;

import com.mx.taquitosoftware.tsmarket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
}
