package ru.otus.YurkovAleksandr.impl;

import ru.otus.YurkovAleksandr.interfaces.Cart;
import ru.otus.YurkovAleksandr.interfaces.ProductRepository;

import java.util.List;

public class CartImpl implements Cart {

    ProductRepository productRepository;
    public CartImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.setProducts(product);
    }
    public void removeProduct(Product product) {
        productRepository.remove(product);
    }

    public List<Product> getProducts() {
        return productRepository.products();
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
