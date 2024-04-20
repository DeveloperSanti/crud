package crud.service;

import crud.persistence.entity.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<ProductEntity> getAll();

    Optional<ProductEntity> getProductById(Long idProduct);

    ResponseEntity<Object> save(ProductEntity product);

    boolean delete(Long idProduct);

}
