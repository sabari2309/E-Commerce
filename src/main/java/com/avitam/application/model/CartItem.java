package com.avitam.application.model;
import com.avitam.application.model.Product;
public class CartItem {
   private int cartItem_id;
   private int cart_id;
   private int product_id;
   private int quantity;
   private Product product;

public int getCartItem_id() {
	return cartItem_id;
}
@Override
public String toString() {
	return "CartItem [cartItem_id=" + cartItem_id + ", cart_id=" + cart_id + ", product_id=" + product_id
			+ ", quantity=" + quantity + ", product=" + product + "]";
}
public void setCartItem_id(int cartItem_id) {
	this.cartItem_id = cartItem_id;
}
public int getCart_id() {
	return cart_id;
}
public void setCart_id(int cart_id) {
	this.cart_id = cart_id;
}

public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
  
   
}
