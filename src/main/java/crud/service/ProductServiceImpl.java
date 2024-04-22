package crud.service;

import crud.persistence.entity.ProductEntity;
import crud.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    HashMap<String, Object> info;


    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> findAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getProductById(Long idProduct) {
        info = new HashMap<>();
        if (!productRepository.existsById(idProduct)) {
            info.put("Error", true);
            info.put("message", "Product Not Found");
            return new ResponseEntity<>(
                    info,
                    HttpStatus.CONFLICT
            );
        }
        info.put("message", "Product Found");
        info.put("Product", productRepository.findById(idProduct));
        return new ResponseEntity<>(
                info,
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<Object> saveProduct(ProductEntity product) {
        Optional<ProductEntity> res = productRepository.findProductByName(product.getName());
        info = new HashMap<>();

        if (res.isPresent() && product.getIdProduct()==null) {
            info.put("Error", true);
            info.put("message", "There is already a product with that name");
            return new ResponseEntity<>(
                    info,
                    HttpStatus.CONFLICT
            );
        }
        info.put("message", "Product saved successfully");
        if(productRepository.findById(product.getIdProduct()).isPresent()){
            info.put("message", "Product update successfully");
        }

        productRepository.save(product);
        info.put("data", product);
        return new ResponseEntity<>(
                info,
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<Object> deleteProduct(Long idProduct) {
        info = new HashMap<>();
        if (!productRepository.existsById(idProduct)) {
            info.put("Error", true);
            info.put("message", "The product does not exist");
            return new ResponseEntity<>(
                    info,
                    HttpStatus.NOT_FOUND
            );
        }
        info.put("message", "Product deleted successfully");
        productRepository.deleteById(idProduct);
        return new ResponseEntity<>(
                info,
                HttpStatus.NO_CONTENT
        );
    }
}
