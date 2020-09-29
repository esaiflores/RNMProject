package com.rnm.omdb.daos;

import com.rnm.omdb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
