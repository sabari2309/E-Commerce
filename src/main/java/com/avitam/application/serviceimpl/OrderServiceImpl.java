package com.avitam.application.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.avitam.application.dao.AddressDao;
import com.avitam.application.dao.OrderDao;
import com.avitam.application.dao.OrderItemDao;
import com.avitam.application.dto.OrderDTO;
import com.avitam.application.dto.OrderItemDTO;
import com.avitam.application.model.Address;
import com.avitam.application.model.CartItem;
import com.avitam.application.model.Order;
import com.avitam.application.model.OrderItem;
import com.avitam.application.model.Product;
import com.avitam.application.model.User;
import com.avitam.application.service.AddressService;
import com.avitam.application.service.CartItemService;
import com.avitam.application.service.OrderService;
import com.avitam.application.service.ProductService;

public class OrderServiceImpl implements OrderService {
     
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private OrderEmailService orderEmailService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private ProductService productService;
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void setOrderItemDao(OrderItemDao orderItemDao) {
		this.orderItemDao = orderItemDao;
	}

	public void setCartItemService(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
    
	@Override
	public int placeOrder(int user_id, int[] cartItemsIds, double total, int addressId,HttpSession session) {
		int orderId=orderDao.createOrder(user_id,addressId,total);
        User user=(User)session.getAttribute("loggedUser");
		List<CartItem> cartItems=cartItemService.getCartItemsByIds(cartItemsIds);
		
		List<OrderItemDTO> emailItems = new ArrayList<>();
		for(CartItem item:cartItems) {
			OrderItem orderItem=new OrderItem();
			orderItem.setOrder_id(orderId);
			orderItem.setProduct_id(item.getProduct_id());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setPrice(item.getProduct().getPrice());
			emailItems.add(new OrderItemDTO(item.getProduct().getName(),item.getQuantity(),item.getProduct().getPrice()));
			orderItemDao.insertOrderItem(orderItem);
		}
		
	    Address addr = addressDao.getByAddressId(addressId);
	    String addressText = addr.getAddress_line() + ", "
	            + addr.getCity() + ", "
	            + addr.getState() + " - "
	            + addr.getPincode();
		cartItemService.removeCartItems(cartItems);
		orderEmailService.sendOrderConfirmation(
		        user.getEmail(),
		        user.getFirstName(),
		        orderId,
		        total,
		        addressText,
		        emailItems
		);
		return orderId;
	}

	public void setOrderEmailService(OrderEmailService orderEmailService) {
		this.orderEmailService = orderEmailService;
	}

	@Override
	public List<Order> getOrdersByUserId(int user_id) {
		return orderDao.getOrderByUser(user_id);
	}

	@Override
	public List<OrderItem> getOrderItemByOrderId(int orderId) {
		return orderDao.getOrderByOrderId(orderId);
	}

	@Override
	public OrderDTO getDetailsByOrderId(int orderId) {
		Order order=orderDao.getDetailsByOrderId(orderId);
		OrderDTO orderDto=new OrderDTO();
		orderDto.setOrder_id(order.getOrder_id());
		orderDto.setTotal(order.getTotal_amount());
		orderDto.setCreated_at(order.getCreated_at());
		orderDto.setStatus(order.getStatus());
		Address address=addressService.getAddressById(order.getAddress_id());
		String adrs=address.getName()+" "+address.getAddress_line()+" "+address.getState()+" "+address.getPincode()+" "+address.getPhone();
		orderDto.setAddress(adrs);
		return orderDto;
	}

	@Override
	public List<OrderItemDTO> getOrderedProducts(List<OrderItem> orderItems) {
		List<OrderItemDTO> orderedProducts=new ArrayList<>();
		for(OrderItem item:orderItems) {
			Product product=productService.findProductById(item.getProduct_id());
			String productName=product.getName();
			String image=product.getImage();
			double price=product.getPrice();
			int quantity=item.getQuantity();
			String description=product.getDescription();
			OrderItemDTO od=new OrderItemDTO(productName,quantity,price,image,description);
			orderedProducts.add(od);
		}
		return orderedProducts;
	}

	@Override
	public List<OrderDTO> getOrderDetails(List<Order> orders) {
		List<OrderDTO> orderDetails=new ArrayList<>();
		for(Order order :orders) {
			OrderDTO od=new OrderDTO();
			System.out.println(order);
			od.setOrder_id(order.getOrder_id());
			od.setTotal(order.getTotal_amount());
			od.setCreated_at(order.getCreated_at());
			od.setStatus(order.getStatus());
			Address address=addressService.getAddressById(order.getAddress_id());
			String adrs=address.getName()+" "+address.getAddress_line()+" "+address.getState()+" "+address.getPincode()+" "+address.getPhone();
			od.setAddress(adrs);
			orderDetails.add(od);
		}
        return orderDetails;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	

	

}
