package ru.otus.YurkovAleksandr.impl;

import ru.otus.YurkovAleksandr.interfaces.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;


    private void init(){
        if(products == null){
            products = new ArrayList<>();
        }
    }
    public List<Product> products() {
        return products;
    }

    public ProductRepositoryImpl setProducts(List<Product> products) {
//        init();
        this.products.addAll(products);
        return this;
    }

    public ProductRepositoryImpl setProducts() {
        init();
        for(int i = 0 ; i < 10; i++){
            products.add(new Product(i+1, ("product" + (i+1)), i*100));
        }
        return this;
    }

    public void setProducts(Product product) {
            products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }


    public Optional<Product> getProductId(int id){
        for (Product product : products) {
            if (product.id() == id) return Optional.of(product);
        }
        return Optional.empty();
    }

}
