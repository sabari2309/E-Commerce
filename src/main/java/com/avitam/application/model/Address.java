package com.avitam.application.model;

public class Address {
   private int address_id;
   private int user_id;
   private String name;
   private String phone;
   private String address_line;
   private String city;
   private String state;
   private String pincode;
public int getAddress_id() {
	return address_id;
}
public void setAddress_id(int address_id) {
	this.address_id = address_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress_line() {
	return address_line;
}
public void setAddress_line(String address_line) {
	this.address_line = address_line;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "Address [address_id=" + address_id + ", user_id=" + user_id + ", name=" + name + ", phone=" + phone
			+ ", address_line=" + address_line + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
}
   
   
}
