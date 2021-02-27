package com.Spring.Boot.java_web.config;

import com.Spring.Boot.java_web.Repository.CategotyRepository;
import com.Spring.Boot.java_web.Repository.OrderRepository;
import com.Spring.Boot.java_web.Repository.ProductRepository;
import com.Spring.Boot.java_web.Repository.Repository;
import com.Spring.Boot.java_web.entitits.Category;
import com.Spring.Boot.java_web.entitits.Order;
import com.Spring.Boot.java_web.entitits.Product;
import com.Spring.Boot.java_web.entitits.User;
import com.Spring.Boot.java_web.entitits.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    //Injeção de dependências
    @Autowired
    private Repository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategotyRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

//Assim que o programa inicialialisar os usuarios seram criados
    //usando commandLineRnner e o metodo run
    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        //Associação entre os objetos
        //p1 que um livro "The Lord of the Rings" é da categoria cat2 que é book
        //get para acessar a coleção
        // para adiconar na coleção

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        //NO JPA É ASSIM JÁ NO SQL É DIFERENTE!!!!
        //salvar os produtos com as associacoes feitas no banco de dados
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);
        // salvando os dados no banco de dados
        repository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
