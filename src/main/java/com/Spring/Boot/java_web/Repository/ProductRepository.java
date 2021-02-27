package com.Spring.Boot.java_web.Repository;

import com.Spring.Boot.java_web.entitits.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
