package com.mx.taquitosoftware.tsmarket.persistence.mapper;

import com.mx.taquitosoftware.tsmarket.domain.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(com.mx.taquitosoftware.tsmarket.persistence.entity.Category category);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    com.mx.taquitosoftware.tsmarket.persistence.entity.Category toCategoria(Category category);

}
