package ru.korobtsov.polystore.controllers;

import org.springframework.web.bind.annotation.*;
import ru.korobtsov.polystore.domain.Product;
import ru.korobtsov.polystore.services.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody @Valid Product product) {
        return productService.create(product);
    }

    @GetMapping("/{id}")
    public Product getOneById(@PathVariable(name = "id") Long id) {
        return productService.getOneById(id);
    }

    @GetMapping
    public Iterable<Product> getAll() {
        return productService.getAll();
    }

    @PutMapping
    public Product update(@RequestBody @Valid Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
    }
}
