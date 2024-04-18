package crud.service;

import crud.persistence.entity.ProductEntity;
import crud.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> getAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> getById(Long idProduct) {
        return productRepository.findById(idProduct);
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(Long idProduct) {
        if (getById(idProduct).isPresent()) {
            productRepository.deleteById(idProduct);
            return true;
        } else {
            return false;
        }
    }
}
