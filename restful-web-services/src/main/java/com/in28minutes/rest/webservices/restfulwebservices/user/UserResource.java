package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{id}")
	public Resource<User> retriveUser(@PathVariable int id) {

		User user= userDaoService.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id -"+id);
		//"all-users", SERVER_PATH + "/users"
				//retrieveAllUsers
				Resource<User> resource = new Resource<User>(user);
				
				ControllerLinkBuilder linkTo = 
						linkTo(methodOn(this.getClass()).retrieveAllUsers());
				
				resource.add(linkTo.withRel("all-users"));
				
				//HATEOAS
				
				return resource;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {

		User user= userDaoService.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id -"+id);
	}
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		User savedUser = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
