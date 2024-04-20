package crud.service;

import crud.persistence.entity.ProductEntity;
import crud.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public Optional<ProductEntity> getProductById(Long idProduct) {
        return productRepository.findById(idProduct);
    }

    @Override
    public ResponseEntity<Object> save(ProductEntity product) {
        Optional<ProductEntity> res = productRepository.findProductByName(product.getName());
        HashMap<String, Object> info = new HashMap<>();

        if (res.isPresent()) {
            info.put("Error", true);
            info.put("message", "There is already a product with that name");
            return new ResponseEntity<>(
                    info,
                    HttpStatus.CONFLICT
            );
        }
        productRepository.save(product);
        info.put("data", product);
        info.put("message", "Product saved successfully");
        return new ResponseEntity<>(
                info,
                HttpStatus.CREATED
        );
    }

    @Override
    public boolean delete(Long idProduct) {
        if (getProductById(idProduct).isPresent()) {
            productRepository.deleteById(idProduct);
            return true;
        } else {
            return false;
        }
    }
}
