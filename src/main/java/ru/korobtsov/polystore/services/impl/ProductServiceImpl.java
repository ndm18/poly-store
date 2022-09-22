package ru.korobtsov.polystore.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.korobtsov.polystore.domain.Product;
import ru.korobtsov.polystore.repositories.ProductRepository;
import ru.korobtsov.polystore.services.ProductService;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        log.debug("Saving {}", product);
        var savedProduct = productRepository.save(product);
        log.debug("Saved {}", savedProduct);
        return savedProduct;
    }

    @Override
    public Product getOneById(Long id) {
        log.debug("Finding by id={}", id);
        var product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with id=%s not found".formatted(id)));
        log.debug("Found by id={} {}", id, product);
        return product;
    }

    @Override
    public Iterable<Product> getAll() {
        log.debug("Finding all");
        var products = productRepository.findAll();
        log.debug("Found {}", products);
        return products;
    }

    @Override
    public Product update(Product product) {
        log.debug("Updating {}", product);
        var updatedProduct = productRepository.save(product);
        log.debug("Updated {}", updatedProduct);
        return updatedProduct;
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Deleting by id={}", id);
        productRepository.deleteById(id);
        log.debug("Deleted by id={}", id);
    }
}
