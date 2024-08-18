package com.example.splunk.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.splunk.demo.dto.Order;
import com.example.splunk.demo.service.OrderService;
import com.example.splunk.demo.util.Mapper;
@RestController
@RequestMapping("/orders")
public class OrderController {
	Logger logger=LogManager.getLogger(OrderService.class);
	@Autowired
	private OrderService orderService;
	@PostMapping
	public Order placeOrder(@RequestBody Order order) {
		logger.info("OrderController:placeOrder persist order request{}",Mapper.mapToJsonString(order));
		Order addOrder=orderService.addOrder(order);
		logger.info("OrderController:placeOrder response from service{}",Mapper.mapToJsonString(addOrder));
		return addOrder;
	}
	@GetMapping
	public List<Order> getOrders(){
		
		List<Order> orders=orderService.getOrders();
		logger.info("OrderController:getOrders response from service{}",Mapper.mapToJsonString(orders));
		return orders;
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable int id) {
		logger.info("OrderController:getOrderById fetch order by id{}",Mapper.mapToJsonString(id));
		Order order=orderService.getOrderById(id);
		logger.info("OrderController:getOrderById response {}",Mapper.mapToJsonString(order));
		return order;
	}


}
