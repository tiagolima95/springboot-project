package com.projetoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetoweb.course.entities.Category;
import com.projetoweb.course.entities.Order;
import com.projetoweb.course.entities.User;
import com.projetoweb.course.entities.enums.OrderStatus;
import com.projetoweb.course.repositories.CategoryRepository;
import com.projetoweb.course.repositories.OrderRepository;
import com.projetoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Tiago", "tiago@tiago.com", "11111-1111", "12345");
		User user2 = new User(null, "Jennifer", "jennifer@jennifer.com", "22222-2222", "23456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, user1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, user2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, user1);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		userRepository.saveAll(Arrays.asList(user1,user2));		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
	}

}
