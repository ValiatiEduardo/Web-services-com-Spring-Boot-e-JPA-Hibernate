package com.Spring.Boot.java_web.Repository;

import com.Spring.Boot.java_web.entitits.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface Repository  extends JpaRepository<User, Long> {

}
