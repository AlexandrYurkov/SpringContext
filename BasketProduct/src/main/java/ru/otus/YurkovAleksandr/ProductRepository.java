package ru.otus.YurkovAleksandr;

import org.springframework.context.annotation.Bean;
import ru.otus.YurkovAleksandr.impl.ProductRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements ProductRepositoryImpl {

    private List<Product> products;


    private void init(){
        if(products == null){
            products = new ArrayList<>();
        }
    }
    public List<Product> products() {
        return products;
    }

    public ProductRepository setProducts(List<Product> products) {
//        init();
        this.products.addAll(products);
        return this;
    }

    public ProductRepository setProducts() {
        init();
        for(int i = 0 ; i < 10; i++){
            products.add(new Product(i+1, ("product" + (i+1)), i*100));
        }
        return this;
    }

    public void setProducts(Product product) {
//        init();
        if(product != null){
            if(product.id() <= 0 || product.id() >= products.size()){
                products.add((products.size() -1),product);
            }if(getProductId(product.id()).isPresent()){
                products.add((products.size() -1),product);
            }else products.add(product.id(), product);
        }

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
