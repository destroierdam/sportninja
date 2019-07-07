package com.damian.boytchev.sport.ninja.SportNinja.service.implementation;

import com.damian.boytchev.sport.ninja.SportNinja.dao.UserRepository;
import com.damian.boytchev.sport.ninja.SportNinja.dto.UserDto;
import com.damian.boytchev.sport.ninja.SportNinja.model.User;
import com.damian.boytchev.sport.ninja.SportNinja.service.abstraction.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        try {
            return userRepository.save(user);
        }catch (Exception e){
            //System.out.println();
            log.info("Error registering user: " + e.getMessage());
            return null;
        }
    }

    @Override
    public User read(User user) {
        try {
            return userRepository.getOne(user.getId());
        }catch (Exception e){
            log.info("Error reading user: " + e.getMessage());
            return null;
        }
    }

    @Override
    public User update(User user) {
        User updatedUser = userRepository.getOne(user.getId());
        if(updatedUser != null){
            return userRepository.save(user);
        }else{
            log.info("User not found for update: " + user.getId());
            return null;
        }
    }

    @Override
    public Boolean delete(User user) {
        User deletedUser = userRepository.getOne(user.getId());
        if(deletedUser != null) {
            userRepository.delete(user);
            return true;
        }

        return false;
    }

    @Override
    public User getUserById(UUID userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public Boolean deleteUserById(UUID uuid) {
        User deleted = userRepository.getOne(uuid);
        return delete(deleted);
    }

    @Override
    public List<User> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }
}
