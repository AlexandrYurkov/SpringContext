package ru.otus.YurkovAleksandr;

import ru.otus.YurkovAleksandr.impl.CartImpl;
import ru.otus.YurkovAleksandr.impl.ProductRepositoryImpl;
import ru.otus.YurkovAleksandr.impl.ServiceImpl;

import java.util.Optional;
import java.util.Scanner;

import static java.lang.System.exit;

public class Service implements ServiceImpl {
    ProductRepositoryImpl productRepository;
    CartImpl cart;

    public Service(CartImpl cart) {
        this.cart = cart;
        this.productRepository = this.cart.getProductRepository();
    }

    public void run(){
        System.out.println("Service started");
    }

    private void printBasket(){
        cart.getProducts().forEach(product -> {
            System.out.println(product.toString());
        });
    }

    private void addNewProduct(Product product){
        cart.addProduct(product);
    }

    private int generateId(){
        return productRepository.products().size() - 1;
    }

    public int printMenu(){
        System.out.println(
                "1) Добавить новый продукт \n" +
                "2) Вывести список продуктов в корзине\n" +
                "3) Вывести продукт по id \n" +
                "4) Удалить продукт по id \n" +
                "** Для завершения программы введите 0 **");
        int inputDate = new Scanner(System.in).nextInt();
        switch (inputDate){
            case 1: {
                System.out.println("Введите название продукта");
                String name = (new Scanner(System.in)).nextLine();
                System.out.println("Введите стоимость продукта");
                int price = (new Scanner(System.in)).nextInt();
                int id = generateId();
                addNewProduct(new Product(id, name, price));
                System.out.println("Продукт создан : " + productRepository.getProductId(id).toString());
                break;
            }
            case 2: {
                printBasket();
                break;
            }
            case 3: {
                System.out.println("Введите id продукта в корзине");
                int id = (new Scanner(System.in)).nextInt();
                Optional<Product> product = productRepository.getProductId(id);
                if (product.isPresent()) {
                    System.out.println("Продукт : " + product.get());
                }else {
                    System.out.println("Такой продукт не найден");
                }

                break;
            }
            case 4: {
                System.out.println("Введите id продукта который хотите удалить");
                int id = (new Scanner(System.in)).nextInt();
                Optional<Product> product = productRepository.getProductId(id);
                if (product.isPresent()) {
                    cart.removeProduct(product.get());
                }else {
                    System.out.println("Такой продукт не найден");
                }
                break;
            }
            case 0: {
                return -1;
            } default: break;
        }
            return 1;
    }

}
