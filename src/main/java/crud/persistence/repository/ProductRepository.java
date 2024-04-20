package crud.persistence.repository;

import crud.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    Optional<ProductEntity> findProductByName(String id);

}
