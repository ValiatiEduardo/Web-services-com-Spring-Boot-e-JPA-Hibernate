package com.Spring.Boot.java_web.Repository;


import com.Spring.Boot.java_web.entitits.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategotyRepository
 extends JpaRepository<Category, Long> {

}

