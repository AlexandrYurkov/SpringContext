package ru.otus.YurkovAleksandr.impl;

import ru.otus.YurkovAleksandr.Product;

import java.util.List;

public interface CartImpl {
    void addProduct(Product product);
    void removeProduct(Product product);
    List<Product> getProducts();
    ProductRepositoryImpl getProductRepository();
}
