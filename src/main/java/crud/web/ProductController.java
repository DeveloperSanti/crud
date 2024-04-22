package crud.web;


import crud.persistence.entity.ProductEntity;
import crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductEntity>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Object> getProductById(@PathVariable("idProduct") Long idProduct){
        return productService.getProductById(idProduct);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductEntity product){
        return productService.saveProduct(product);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductEntity product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("idProduct") Long idProduct){
        return productService.deleteProduct(idProduct);
    }

}
