package com.Work.SampleProject.Service;

import com.Work.SampleProject.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String addUser(User newUser);
    List<User> getAllUsers();
    Optional<User> findUserById(int id);

    User updateUser(User updateUser);
}

