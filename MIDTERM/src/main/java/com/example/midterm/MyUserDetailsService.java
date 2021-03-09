package com.example.midterm;

import com.example.midterm.dao.UserJPADao;
import com.example.midterm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserJPADao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Finds the user by talking the the DAO
        User user = userDao.findByUsername(username);

        if (user==null) throw new UsernameNotFoundException("User 404");

        return new UserDetailsImpl(user);
    }
}
