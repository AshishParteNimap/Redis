package com.RedisDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RedisDemo.model.Menu;
import com.RedisDemo.repo.MenuRepo;

@RestController
@RequestMapping("/Menu")
public class RedisController {

	@Autowired
	private MenuRepo repo;

	@PostMapping("/")
	public Menu saveMenu(@RequestBody Menu menu) {
		return repo.saveMenu(menu);
	}

	@GetMapping("/")
	public List<Menu> getMenu() {
		return repo.findAll();

	}
	
	@GetMapping("/{id}")
	public Menu getById(@PathVariable int id) {
		return repo.findById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteMenu(@PathVariable int id) {
		return repo.deleteMenu(id);
		
	}
}
