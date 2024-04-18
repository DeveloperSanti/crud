package crud.service;

import crud.persistence.entity.ProductEntity;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    public List<ProductEntity> getAll();

    public Optional<ProductEntity> getById(Long id);

    public ProductEntity save(ProductEntity product);

    public

    public boolean delete(Long id);

}
