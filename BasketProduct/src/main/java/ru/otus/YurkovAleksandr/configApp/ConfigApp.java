package ru.otus.YurkovAleksandr.configApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.YurkovAleksandr.impl.CartImpl;
import ru.otus.YurkovAleksandr.impl.ProductRepositoryImpl;
import ru.otus.YurkovAleksandr.impl.ServiceImpl;
import ru.otus.YurkovAleksandr.interfaces.Cart;
import ru.otus.YurkovAleksandr.interfaces.ProductRepository;
import ru.otus.YurkovAleksandr.interfaces.Service;

@Configuration
@ComponentScan("ru.otus.YurkovAleksandr")
public class ConfigApp {
    @Bean
    ProductRepository productRepository() {
        return new ProductRepositoryImpl().setProducts();
    }
    @Bean
    public Cart cart(ProductRepository productRepository) {
        return new CartImpl(productRepository);
    }

    @Bean
    public Service service(Cart cart) {
        return new ServiceImpl(cart);
    }

}
