package com.RedisDemo.model;

import java.io.Serializable;


import org.springframework.data.redis.core.RedisHash;
@RedisHash("Menu")
public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;

	@org.springframework.data.annotation.Id
	private int id;
	private String item;
	private long price;
	public Menu(int id, String item, long price) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
}
