package com.rnm.omdb.daos;

import com.rnm.omdb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> { // Jpa is an api and is being used right now to manage the data between the java objects and database

    User findByUsername(String username); // we can use this in other classes now
}
