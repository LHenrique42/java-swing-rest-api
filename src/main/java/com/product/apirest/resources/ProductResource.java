package com.product.apirest.resources;

import java.util.List;

import com.product.apirest.model.Product;
import com.product.apirest.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Products")
@CrossOrigin(origins = "*")
public class ProductResource {
    
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    @ApiOperation(value = "Lista produtos")
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Procura produto único")
    public Product findProduct(@PathVariable(value="id") long id) {
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    @ApiOperation(value = "Cadastra novo produto")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")
    @ApiOperation(value = "Deleta um produto")
    public void deleteProduct(@PathVariable(value="id") long id) {
        productRepository.deleteById(id);
    }

    @PutMapping("/product")
    @ApiOperation(value = "Atualiza um produto")
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
