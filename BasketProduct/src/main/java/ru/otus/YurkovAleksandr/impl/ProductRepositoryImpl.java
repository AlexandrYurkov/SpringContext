package ru.otus.YurkovAleksandr.impl;

import ru.otus.YurkovAleksandr.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryImpl {
    void remove(Product product);
    Optional<Product> getProductId(int id);

    void setProducts(Product product);

    List<Product> products();
}
