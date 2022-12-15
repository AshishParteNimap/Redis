package com.RedisDemo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.RedisDemo.model.Menu;

@Repository

public class MenuRepo {

	public static final String HASH_KEY_MAP = "MENU_ITEM";
	@Autowired
	private RedisTemplate redisTemplate;

	public Menu saveMenu(Menu menu) {
		redisTemplate.opsForHash().put(HASH_KEY_MAP, menu.getId(), menu);
		return menu;

	}

	public List<Menu> findAll() {
		return redisTemplate.opsForHash().values(HASH_KEY_MAP);
	}

	public Menu findById(int id) {
		return (Menu) redisTemplate.opsForHash().get(HASH_KEY_MAP, id);

	}

	public String deleteMenu(int id) {
		redisTemplate.opsForHash().delete(HASH_KEY_MAP, id);
		return "menu deleted";
	}

}
