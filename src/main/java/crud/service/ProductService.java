package crud.service;

import crud.persistence.entity.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductService {

    List<ProductEntity> findAll();

    ResponseEntity<Object> getProductById(Long idProduct);

    ResponseEntity<Object> saveProduct(ProductEntity product);

    ResponseEntity<Object> deleteProduct(Long idProduct);

}
