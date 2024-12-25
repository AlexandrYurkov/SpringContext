package ru.otus.YurkovAleksandr.interfaces;

import ru.otus.YurkovAleksandr.impl.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void remove(Product product);
    Optional<Product> getProductId(int id);

    void setProducts(Product product);

    List<Product> products();
}
