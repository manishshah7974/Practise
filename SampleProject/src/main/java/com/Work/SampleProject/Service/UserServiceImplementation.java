package com.Work.SampleProject.Service;

import com.Work.SampleProject.Model.User;
import com.Work.SampleProject.Repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

//    @PersistenceContext
//    EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;
    @Override
    public String addUser(User newUser) {
        User data = userRepository.save(newUser);
        return data.getName();
    }

    @Override
    public List<User> getAllUsers() {
       return  userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User updateUser) {
        return userRepository.save(updateUser);
    }
}
