package com.vansh.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResources {

	private UserDaoService service;

	public UserResources(UserDaoService service) {
		this.service = service;
	}

//GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {

		return service.findAll();
	}

//GET//users

	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
//POST/users

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
     User savedUser=service.save(user);
	

	URI location=ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
	return ResponseEntity.created(location).build();
	
	}
	
	//DELETE/users
	
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id) {
        service.deleteById(id);
	}
	





















}