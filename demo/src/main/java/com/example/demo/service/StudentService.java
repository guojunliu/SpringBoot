package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRequestEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private UserRepository userRepository;

    public StudentService(UserRepository userRepository) {
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

    public User save(UserRequestEntity userRequestEntity){
        User userObj = Optional.of(userRequestEntity).map(User::new).get();
        return userRepository.save(userObj);
    }

    public User save(String name, int id){
        Optional<User> optionalUserObj = userRepository.findById(id);
        if(optionalUserObj.isPresent()) {
            User userObj = optionalUserObj.get();
            userObj.setName(name);
            return userRepository.save(userObj);
        }
        return null;
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }
}
