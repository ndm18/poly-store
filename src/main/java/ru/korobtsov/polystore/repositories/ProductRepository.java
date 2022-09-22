package ru.korobtsov.polystore.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.korobtsov.polystore.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
