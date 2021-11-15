package com.codeup.web;

import com.codeup.data.post.Post;
import com.codeup.data.user.User;
import com.codeup.data.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    private List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    private User findById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/findByUsername")
    private User findByUsername(@RequestParam String username) {
        return userRepository.findByUsername(username);
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        userRepository.save(newUser);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        System.out.println("Editing user with ID " + id);
        System.out.println(updateUser.getUsername());
        System.out.println(updateUser.getEmail());
        userRepository.save(updateUser);
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
