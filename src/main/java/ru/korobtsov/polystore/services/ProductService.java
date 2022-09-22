package ru.korobtsov.polystore.services;

import ru.korobtsov.polystore.domain.Product;

public interface ProductService {

    Product create(Product product);

    Product getOneById(Long id);

    Iterable<Product> getAll();

    Product update(Product product);

    void deleteById(Long id);
}

