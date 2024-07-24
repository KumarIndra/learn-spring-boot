package com.from28minutes.learnerAppendix.Learn_spring_boot.User;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.from28minutes.learnerAppendix.Learn_spring_boot.jpa.PostJpaRepository;
import com.from28minutes.learnerAppendix.Learn_spring_boot.jpa.UserJpaRepository;

import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/jpa")
public class UserJPAController {

	@Autowired
	private UserJpaRepository userService;
	
	@Autowired
	private PostJpaRepository postRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getOneUser(@PathVariable int id) {
		return userService.findById(id);
	}
	
	//Hateoas and versioning
	@GetMapping("/users/v1/{id}")
	public EntityModel<User> getOneUserV1(@PathVariable int id) {
		Optional<User> user = userService.findById(id);
		
		//Hateoas
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveOne(@Valid @RequestBody User user){
		User usedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteByUser(@PathVariable int id) {
		userService.deleteById(id);
		
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> retrievePostsByUser(@PathVariable int id) {
		Optional<User> user = userService.findById(id);
		return user.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPostByUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = userService.findById(id);
		post.setUser(user.get());
		
		Post savePost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savePost.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("/users/{id}/posts/{post_id}")
	public Post retrievePostByUser(@PathVariable int id,@PathVariable int post_id) {
		Optional<User> user = userService.findById(id);
		List<Post> posts = user.get().getPosts();
		for (Post post : posts) {
			if(post.getId()==post_id) {
				return post;
			}
		}
		return null;
	}
}
