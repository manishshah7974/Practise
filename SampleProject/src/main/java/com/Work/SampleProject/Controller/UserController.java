package com.Work.SampleProject.Controller;

import com.Work.SampleProject.Model.User;
import com.Work.SampleProject.Repository.UserRepository;
import com.Work.SampleProject.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController
{
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping("/check")
    public String check()
    {
        return "home";
    }

    @RequestMapping("/getAllData")
    public List<User> getAllData()
    {
        logger.info("API Call  - getAllData");
        return userService.getAllUsers();
    }

    // Add User
    @PostMapping("/addUser")
    String newEmployee(@RequestBody User newUser) {
        logger.info("API Call  - addUser ");
        logger.info("New User Added {}",newUser);

        return userService.addUser(newUser);
    }

    @PutMapping("/updateUser/{id}")
    User updateData(@RequestBody User newUser, @PathVariable int id) {
        Optional<User> updateUserData = userService.findUserById(id);

//
//        updateUserData.mobile = phone;
//        repo.save(myCustomer);
        logger.info("API Call  - updateUserDetail ");
        logger.info("Data Updated ",updateUserData);

       return userService.updateUser(newUser);
    }
    }
