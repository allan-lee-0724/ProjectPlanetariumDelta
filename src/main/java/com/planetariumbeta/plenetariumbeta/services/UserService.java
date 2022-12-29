package com.planetariumbeta.plenetariumbeta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planetariumbeta.plenetariumbeta.entities.User;
import com.planetariumbeta.plenetariumbeta.repositories.UserDao;

@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;

    public User getUserByUsername(String username){
        Optional<User> possibleUser = this.userDao.findByUsername(username);
        if(possibleUser.isPresent()){
            return possibleUser.get();
        } else{
            return null;
        }
        
    }

    public String register(User user){
       this.userDao.createUser(user.getUsername(), user.getPassword());
       return "NEW USER SUCCESSFULLY CREATED";
    }

}
