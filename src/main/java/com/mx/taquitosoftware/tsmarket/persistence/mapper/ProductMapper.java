package com.mx.taquitosoftware.tsmarket.persistence.mapper;

import antlr.collections.impl.LList;
import com.mx.taquitosoftware.tsmarket.domain.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    Product toProduct(com.mx.taquitosoftware.tsmarket.persistence.entity.Product product);

    List<Product> toProducts(List<com.mx.taquitosoftware.tsmarket.persistence.entity.Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    com.mx.taquitosoftware.tsmarket.persistence.entity.Product toProducto(Product product);

}
