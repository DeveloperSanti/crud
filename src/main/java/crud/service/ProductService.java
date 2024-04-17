package crud.service;

import crud.persistence.entity.ProductEntity;
import crud.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<ProductEntity> getAll(){
        return (List<ProductEntity>) productRepository.findAll();
    }

}
