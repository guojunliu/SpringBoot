package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findOne(int id) {
        User userObj = new User();
        userObj.setId(id);
        return userRepository.findOne(Example.of(userObj));
    }

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    public List<User> findByAge(int id){
        return userRepository.findByAge(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(User userObj){
        return userRepository.save(userObj);
    }

    public User update(User userObj){
        Optional<User> optionalUserObj = userRepository.findById(userObj.getId());
        if(optionalUserObj.isPresent()) {
            return userRepository.save(userObj);
        }
        return null;
    }

    public boolean delete(User userObj){
        Optional<User> optionalUserObj = userRepository.findById(userObj.getId());
        if(optionalUserObj.isPresent()) {
            userRepository.deleteById(userObj.getId());
            return true;
        }
        return false;
    }
}
