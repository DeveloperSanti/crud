package crud.service;

import crud.persistence.entity.ProductEntity;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<ProductEntity> getAll();

    Optional<ProductEntity> getById(Long idProduct);

    ProductEntity save(ProductEntity product);

    boolean delete(Long idProduct);

}
