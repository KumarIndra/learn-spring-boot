package com.from28minutes.learnerAppendix.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount,"Indra","Software Engineer"));
		users.add(new User(++userCount,"Kani","Research Analyst"));
		users.add(new User(++userCount,"Suse","Project Coordinator"));
		users.add(new User(++userCount,"Dinesh","Project Executive"));
		users.add(new User(++userCount,"Hema","Quality Executive"));
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User getOneUser(int id) {
		Predicate<? super User> predicate = user -> user.getId() == (id);
		return users.stream().filter(predicate).findFirst().get();
	}
	
	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == (id);
		users.removeIf(predicate);
	}
}
