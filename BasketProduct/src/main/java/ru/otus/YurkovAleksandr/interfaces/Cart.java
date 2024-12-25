package ru.otus.YurkovAleksandr.interfaces;

import ru.otus.YurkovAleksandr.impl.Product;

import java.util.List;

public interface Cart {
    void addProduct(Product product);
    void removeProduct(Product product);
    List<Product> getProducts();
    ProductRepository getProductRepository();
}
