package ru.otus.YurkovAleksandr;

import org.springframework.context.annotation.Bean;
import ru.otus.YurkovAleksandr.impl.CartImpl;
import ru.otus.YurkovAleksandr.impl.ProductRepositoryImpl;

import java.util.List;

public class Cart implements CartImpl {

    ProductRepositoryImpl productRepository;
    public Cart(ProductRepositoryImpl productRepository) {
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

    public ProductRepositoryImpl getProductRepository() {
        return productRepository;
    }
}
