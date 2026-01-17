package com.avitam.application.model;

import java.time.LocalDateTime;

public class Cart {
   private int id;
   private int user_id;
   private LocalDateTime created_at;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public LocalDateTime getCreated_at() {
	return created_at;
}
public void setCreated_at(LocalDateTime created_at) {
	this.created_at = created_at;
}


@Override
public String toString() {
	return "Cart [id=" + id + ", user_id=" + user_id + ", created_at=" + created_at + "]";
}
    
}
