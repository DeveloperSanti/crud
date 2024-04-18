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

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<ProductEntity> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable("idProduct") Long idProduct){
        return productService.getProductById(idProduct).map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
