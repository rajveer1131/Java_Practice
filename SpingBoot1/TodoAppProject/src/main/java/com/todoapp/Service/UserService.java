package com.todoapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todoapp.Model.User;
import com.todoapp.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
private PasswordEncoder passwordEncoder;

    public User createUser(User userData){
        if(userRepository.findByEmail(userData.getEmail()) !=null){
            throw new RuntimeException("Email " + userData.getEmail() + " is already registered!");
        }
        if(userRepository.findByName(userData.getName()) != null){
            throw new RuntimeException("Name " + userData.getName() + " is already registered!");
        }
        
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));


        return userRepository.save(userData);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User userLogin(User userData){
        User regUser = userRepository.findByEmail(userData.getEmail());
        if(regUser != null && passwordEncoder.matches(userData.getPassword(), regUser.getPassword())){
            return regUser;
        }

        throw new RuntimeException("Invalid email or password");
    }

    public String deleteUserById(String userId){
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        userRepository.delete(user);
        return "User " + user.getName() +" with ID\" "+user.getUserId() +"\" was deleted successfully along with all their tasks.";
    }
    


}
