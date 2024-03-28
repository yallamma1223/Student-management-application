package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.exception.UserNotFoundException;
import com.user.modal.User;
import com.user.repo.UserRepository;

@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {
	
	// DI(dependency injection)
	@Autowired
	private UserRepository userepo;
	
	@PostMapping("/getuser")
	public User saveuser(@RequestBody User user) 
	{
		return userepo.save(user);
		
	}
	
	@GetMapping("/getAllusers")
	public List<User> getAllusers()
	{
		return userepo.findAll();
		
	}
	
	@GetMapping("/singlegetuser/{id}")
     public User getuser(@PathVariable int id) 
     {
		return userepo.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    	 
     }
	
	@PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable int id) 
	{
        return userepo.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userepo.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }
	

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable int id){
        if(!userepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
	
}
