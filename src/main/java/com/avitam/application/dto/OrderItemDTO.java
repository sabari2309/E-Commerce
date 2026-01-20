package com.avitam.application.dto;


public class OrderItemDTO {

    private String productName;
    private int quantity;
    private double price;
    private String image;
    private String description;
    public OrderItemDTO(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemDTO(String productName, int quantity, double price,String image,String description) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.image=image;
        this.description=description;
    }

    public String getDescription() {
    	return description;
    }
    
    public String getImage() {
		return image;
	}

	public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
