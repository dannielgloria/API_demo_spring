package com.mx.taquitosoftware.tsmarket.persistence;

import com.mx.taquitosoftware.tsmarket.persistence.crud.ProductCrudRepository;
import com.mx.taquitosoftware.tsmarket.persistence.entity.Product;
import com.mx.taquitosoftware.tsmarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.mx.taquitosoftware.tsmarket.domain.repository.ProductRepository {
    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<com.mx.taquitosoftware.tsmarket.domain.Product> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<com.mx.taquitosoftware.tsmarket.domain.Product>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<com.mx.taquitosoftware.tsmarket.domain.Product>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return products.map(products1 -> mapper.toProducts(products1));
    }

    @Override
    public Optional<com.mx.taquitosoftware.tsmarket.domain.Product> getProduct(int productId) {

        return productCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public com.mx.taquitosoftware.tsmarket.domain.Product save(com.mx.taquitosoftware.tsmarket.domain.Product product) {
        Product product1 = mapper.toProducto(product);
        return mapper.toProduct(productCrudRepository.save(product1));
    }

    public Product save(Product product){
        return productCrudRepository.save(product);
    }

    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }
}
