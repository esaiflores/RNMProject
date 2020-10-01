package com.rnm.omdb.services;

import com.rnm.omdb.daos.UsersRepository;
import com.rnm.omdb.models.User;
import com.rnm.omdb.models.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//This the loader being used by the security configuration file

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UsersRepository users;

    public UserDetailsLoader(UsersRepository users) {this.users = users;}


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);// what this is doing is saying that if a user puts in a blank name or a name not found it will be null and then return the exception
        }

        return new UserWithRoles(user); // this will tie in with the user with roles controller
    }


}
