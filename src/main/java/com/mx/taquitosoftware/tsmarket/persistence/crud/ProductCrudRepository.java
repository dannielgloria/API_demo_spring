package com.mx.taquitosoftware.tsmarket.persistence.crud;

import com.mx.taquitosoftware.tsmarket.persistence.entity.Product;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    // Native way
    //@Query(value = "SELECT * FROMA productos WHERE id_categoria = ?", nativeQuery = true)
    //List<Product> getByCategory(int idCategoria);

    //Query Methods
    List<Product> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Product>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
