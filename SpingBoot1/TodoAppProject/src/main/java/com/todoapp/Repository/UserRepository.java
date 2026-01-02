package com.todoapp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todoapp.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
   
    User findByEmail(String email);
    User findByName(String name);
}
