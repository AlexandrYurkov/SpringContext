package ru.otus.YurkovAleksandr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.YurkovAleksandr.impl.CartImpl;
import ru.otus.YurkovAleksandr.impl.ProductRepositoryImpl;
import ru.otus.YurkovAleksandr.impl.ServiceImpl;

@Configuration
@ComponentScan("ru.otus.YurkovAleksandr")
public class ConfigApp {
    @Bean ProductRepositoryImpl productRepository() {
        return new ProductRepository().setProducts();
    }
    @Bean
    public CartImpl cart(ProductRepositoryImpl productRepository) {
        return new Cart(productRepository);
    }

    @Bean
    public ServiceImpl service(CartImpl cart) {
        return new Service(cart);
    }

}
