package com.mx.taquitosoftware.tsmarket.persistence;

import com.mx.taquitosoftware.tsmarket.persistence.crud.ProductCrudRepository;
import com.mx.taquitosoftware.tsmarket.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll(){ return (List<Product>) productCrudRepository.findAll(); }

    public List<Product> getByCategoria(int idCategoria){
        return productCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Product>> getScarce(int cantidad){
        return productCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
